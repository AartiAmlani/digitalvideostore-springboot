package com.example.restapidigitalvideostore.controllers;

import com.example.restapidigitalvideostore.CustomizedResponse;
import com.example.restapidigitalvideostore.models.Movie;
import com.example.restapidigitalvideostore.models.Tvshow;
import com.example.restapidigitalvideostore.services.MovieService;
import com.example.restapidigitalvideostore.services.TvshowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
public class TvshowController {
    @Autowired
    private TvshowService service;

    @GetMapping("/tvshows")
    public ResponseEntity getMovies() {//datatype is response entity caz we want to send a proper response. and showing the status code.

        CustomizedResponse customizedResponse = new CustomizedResponse(" A list of tvshows", service.getTvshows());
        return new ResponseEntity(customizedResponse, HttpStatus.OK);
    }

    @GetMapping("/tvshows/rating")
    public ResponseEntity gettvshowsByRating(@RequestParam(value = "rate") String r)
    {

        CustomizedResponse customizedResponse = new CustomizedResponse(" A list of tvshows with the rating : " , service.getTvshowsWithRating(r));

        return new ResponseEntity(customizedResponse, HttpStatus.OK);
    }

    @GetMapping("/tvshows/featured")
    public ResponseEntity gettvshowsByFeatured(@RequestParam(value ="feat") Boolean x)

    {
        x=true;
        CustomizedResponse customizedResponse = new CustomizedResponse(" A list of tvshows with the featured value true : "+x , service.getTvshowsWithFeatured(x));

        return new ResponseEntity(customizedResponse, HttpStatus.OK);
    }
@GetMapping("/tvshows/title")
public ResponseEntity gettvshowsByTitle(@RequestParam(value = "til") String t)
{

    CustomizedResponse customizedResponse = new CustomizedResponse(" A list of tvshows with the title : " +t , service.getTvshowsWithTitle(t));

    return new ResponseEntity(customizedResponse, HttpStatus.OK);
}
    @GetMapping("/tvshows/{id}")
    public ResponseEntity getATvshow(@PathVariable("id")String id)
    {
        CustomizedResponse customizedResponse = null;
        try {
            customizedResponse = new CustomizedResponse(" Tvshow with id " + id , Collections.singletonList(service.getATvshow(id)));
        } catch (Exception e) {

            customizedResponse = new CustomizedResponse(e.getMessage(), null);

            return new ResponseEntity(customizedResponse, HttpStatus.NOT_FOUND);

        }
//        System.out.println(id);
//        System.out.println(service.getAMovie(id));
        return new ResponseEntity(customizedResponse, HttpStatus.OK);
    }

    @DeleteMapping("/tvshows/{id}")
    public ResponseEntity deleteATvshow(@PathVariable("id")String id)
    {
        service.deleteATvshow(id);
        return new ResponseEntity(HttpStatus.OK);

    }

    @PostMapping(value = "/tvshows", consumes = { //Consume is when we are sending the data into body of req
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity addTvshow(@RequestBody Tvshow tvshow)
    {
        service.insertIntoTvshows(tvshow);
        return new ResponseEntity(tvshow, HttpStatus.OK);

    }
    @PutMapping(value = "/tvshows/{id}", consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity editMovie(@PathVariable("id") String id, @RequestBody Tvshow newTvshow )

    {


        CustomizedResponse customizedResponse = new CustomizedResponse(" Tvshow  with ID:  " + id + "was updated successfully " , Collections.singletonList(service.editTvshow(id, newTvshow)));

        return new ResponseEntity(customizedResponse, HttpStatus.OK);

    }
}
