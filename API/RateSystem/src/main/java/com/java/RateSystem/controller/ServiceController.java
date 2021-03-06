package com.java.RateSystem.controller;

import com.java.RateSystem.models.ResponseObject;
import com.java.RateSystem.models.Servicerate;
import com.java.RateSystem.repository.ServiceRepository;
import com.java.RateSystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@CrossOrigin(origins = "*", allowedHeaders = "")
@RestController
@RequestMapping(path = "api/v1/services")
public class ServiceController {

    @Autowired
    private ProductService productService;

    @GetMapping("")
    List<Servicerate> getAllServiceName() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    ResponseEntity<ResponseObject> findById(@PathVariable Integer id){
        Optional<Servicerate> foundProduct = productService.findById(id);
        return foundProduct.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("ok","Querry Service successfully", foundProduct)
                ):
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("false", "Cannot find Service with id =" + id,"")
                );

    }

    //insert data
    @PostMapping("/insert")
    ResponseEntity<ResponseObject> insertProduct(@RequestBody Servicerate newService){
        Optional<Servicerate> foundService = productService.findById(newService.getId());
        return foundService.isPresent() ?
                ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                        new ResponseObject("failed", "Service Name already taken", "")
                ):
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("Ok","Insert Service successfully",productService.save(newService))
                );
    }

    //Update data
    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateService(@RequestBody Servicerate newService, @PathVariable Integer id){
        Servicerate updateService =  productService.findById(id)
                .map(service -> {
                    service.setName(newService.getName());
                    service.setImage(newService.getImage());
                    service.setDescription(newService.getDescription());
                    return productService.save(service);
                }).orElseGet(()->{
                    newService.setId(id);
                    return productService.save(newService);
                });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("Ok","Update Service successfully",productService.save(newService))
        );
    }

    @DeleteMapping("/{id}")
    ResponseEntity<ResponseObject> deleteProduct (@PathVariable Integer id){
        boolean exists = productService.existsById(id);
        if(exists)
        {
            productService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("Ok", "Delete Service successfully","")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("Failed", "Cannot find Service to delete ", "")
        );
    }
}