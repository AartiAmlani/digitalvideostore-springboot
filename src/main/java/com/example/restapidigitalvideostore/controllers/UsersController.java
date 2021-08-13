package com.example.restapidigitalvideostore.controllers;

import com.example.restapidigitalvideostore.CustomizedResponse;
import com.example.restapidigitalvideostore.models.UserModel;
import com.example.restapidigitalvideostore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collections;

@Controller
public class UsersController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity getUsers(){
        CustomizedResponse response =new CustomizedResponse("A list of all user",userService.getUsers());
       return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity getAUser(@PathVariable("id") String id)
    {
//        CustomizedResponse response =new CustomizedResponse("A user with the id:"+id, Collections.singletonList(userService.getAUser(id)));
//        return new ResponseEntity(response, HttpStatus.OK);
        CustomizedResponse response = null;
        try {
            response =new CustomizedResponse("A user with the id:"+id, Collections.singletonList(userService.getAUser(id)));
        } catch (Exception e) {

            response = new CustomizedResponse(e.getMessage(), null);

            return new ResponseEntity(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(response, HttpStatus.OK);


    }

    @PostMapping(value = "/users", consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })

    public ResponseEntity createUsers(@RequestBody UserModel user)
    {

        CustomizedResponse response = new CustomizedResponse( " User created successfully", Collections.singletonList(userService.addUser(user)));

        return new ResponseEntity( response, HttpStatus.OK);
    }
}
