package com.java.RateSystem.controller;

import com.java.RateSystem.models.ResponseObject;
import com.java.RateSystem.models.User;
import com.java.RateSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
//@RequestMapping(path = "api/v1/user")
public class UserController {
// Login & Register
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String getRegisterPage(Model model)
    {
        model.addAttribute("registerRequest", new User());
        return "register_page" ;
    }

    @GetMapping("/login")
    public String getLoginPage(Model model)
    {
        model.addAttribute("loginRequest", new User());
        return "login_page";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user){
        System.out.println("register request: " + user);
        User registerUser = userService.registerUser(user.getUserName(), user.getPassword(), user.getEmail(), user.getRole());
        return registerUser == null ? "error_page" : "redirect:/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user, Model model){
        System.out.println("login request: " + user);
        User authenticated = userService.authenticate(user.getUserName(), user.getPassword());
        if(authenticated != null){
            model.addAttribute("userName", authenticated.getUserName());
            return "personal_page";
        }else {
            return "error_page";
        }
    }



//    //Call API
//    @Autowired
//    private UserRepository userRepository;
//    @GetMapping("")
//    List<User> getAllUserName(){return userRepository.findAll();}
//
//    @GetMapping("/{id}")
//    ResponseEntity<ResponseObject>findByUserId(@PathVariable Integer id){
//        Optional<User> foundUser = userRepository.findById(id);
//        return foundUser.isPresent() ?
//                ResponseEntity.status(HttpStatus.OK).body(
//                        new ResponseObject("ok","Querry product successfully", foundUser)
//                ):
//                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
//                        new ResponseObject("False","Cannot find", foundUser)
//                );
//    }
//
//    @PostMapping("/insert")
//    ResponseEntity<ResponseObject> insertUser(@RequestBody User newUser){
//        Optional<User> foundUser = userRepository.findByEmail(newUser.getEmail().trim());
//        return foundUser.isPresent() ?
//                ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
//                        new ResponseObject("failed", "Email already taken", "")
//                ):
//                ResponseEntity.status(HttpStatus.OK).body(
//                        new ResponseObject("Ok","Register User Name successfully",userRepository.save(newUser))
//                );
//    }
//
//    @PutMapping("/{id}")
//    ResponseEntity<ResponseObject> updateUser (@RequestBody User newUser, @PathVariable Integer id){
//        User updateUser =  userRepository.findById(id)
//                .map(user -> {
//                    user.setUserName(newUser.getUserName());
//                    user.setEmail(newUser.getEmail());
//                    user.setRole(newUser.getRole());
//                    return userRepository.save(user);
//                }).orElseGet(()->{
//                    newUser.setUserId(id);
//                    return userRepository.save(newUser);
//                });
//        return ResponseEntity.status(HttpStatus.OK).body(
//                new ResponseObject("Ok","Update User successfully",userRepository.save(newUser))
//        );
//    }
//
//    @DeleteMapping("/{id}")
//    ResponseEntity<ResponseObject> deleteUser (@PathVariable Integer id){
//        boolean exists = userRepository.existsById(id);
//        if(exists)
//        {
//            userRepository.deleteById(id);
//            return ResponseEntity.status(HttpStatus.OK).body(
//                    new ResponseObject("Ok", "Delete User successfully","")
//            );
//        }
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
//                new ResponseObject("Failed", "Cannot find User to delete ", "")
//        );
//    }
}
