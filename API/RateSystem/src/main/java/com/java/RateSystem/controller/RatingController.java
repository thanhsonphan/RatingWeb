package com.java.RateSystem.controller;

import com.java.RateSystem.models.Rating;
import com.java.RateSystem.models.ResponseObject;
import com.java.RateSystem.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/v1/rate")
public class RatingController {
    @Autowired
    private RatingRepository ratingRepository;

    @GetMapping("")
    List<Rating> getAllService(){
        return ratingRepository.findAll();
    }

    @GetMapping("{id}")
    ResponseEntity<ResponseObject>findByUUId(@PathVariable UUID id){
        Optional<Rating> foundService = ratingRepository.findById(id);
        return foundService.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("ok","Querry Service successfully", foundService)
                ):
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("false", "Cannot find Service with id =" + id,"")
                );

    }

    //insert data
    @PostMapping("/insert")
    ResponseEntity<ResponseObject> insertRating(@RequestBody Rating newRate){
        Optional<Rating> foundRate = ratingRepository.findByUUID(newRate.getId());
        return foundRate.isPresent() ?
                ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                        new ResponseObject("failed", "Service Name already taken", "")
                ):
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("Ok","Insert Service successfully",ratingRepository.save(newRate))
                );
    }

    //Update data
    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateRate(@RequestBody Rating newRate, @PathVariable UUID id){
        Rating updateRate =  ratingRepository.findByUUID(id)
                .map(rate -> {
                    rate.setUserName(newRate.getUserName());
                    rate.setServiceid(newRate.getServiceid());
                    rate.setPoint(newRate.getPoint());
                    rate.setComment(newRate.getComment());
                    rate.setDate(newRate.getDate());
                    return ratingRepository.save(rate);
                }).orElseGet(()->{
                    newRate.setId(id);
                    return ratingRepository.save(newRate);
                });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("Ok","Update Service successfully",ratingRepository.save(newRate))
        );
    }

    @DeleteMapping("/{id}")
    ResponseEntity<ResponseObject> deleteRate (@PathVariable UUID id){
        boolean exists = ratingRepository.existsById(id);
        if(exists)
        {
            ratingRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("Ok", "Delete Service successfully","")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("Failed", "Cannot find Service to delete ", "")
        );
    }
}
