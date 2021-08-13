package com.example.restapidigitalvideostore.services;

import com.example.restapidigitalvideostore.models.Movie;
import com.example.restapidigitalvideostore.models.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MovieService
{
    @Autowired
    private MovieRepository repository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Movie> getMovies()

    {
        //validation or calculation or call model
        return repository.findAll();
    }
    public List<Movie> getMoviesWithRating(String r) {
        // business logics
        Query query = new Query();
        query.addCriteria(Criteria.where("rating").is(r));
        List<Movie> movies = mongoTemplate.find(query, Movie.class);
        return movies;
    }

    public List<Movie> getMoviesWithFeatured(Boolean x) {
        // business logics
        Query query = new Query();
        query.addCriteria(Criteria.where("featured").is(x));
        List<Movie> movies = mongoTemplate.find(query, Movie.class);
        return movies;
    }
    public List<Movie> getMoviesWithTitle(String t) {
        // business logics
        Query query = new Query();
        query.addCriteria(Criteria.where("title").is(t));
        List<Movie> movies = mongoTemplate.find(query, Movie.class);
        return movies;
    }
    public void insertIntoMovies(Movie movie)
    {

        repository.insert(movie);
    }

    public Movie editMovie(String id, Movie newMovieData)
    {
        // get the resource based on the id

        Optional<Movie> movie = repository.findById(id);

        // validation code to validate the id

        movie.get().setTitle(newMovieData.getTitle());
        movie.get().setDescription(newMovieData.getDescription());
        movie.get().setRating(newMovieData.getRating());
        movie.get().setPoster(newMovieData.getPoster());
        movie.get().setDateReleased(newMovieData.getDateReleased());
        movie.get().setBuy(newMovieData.getBuy());
        movie.get().setRent(newMovieData.getRent());
        movie.get().setFeatured(newMovieData.getFeatured());

        Movie updateMovie = repository.save(movie.get());

        return updateMovie;



    }

    //it might return null so we use optional
    public Optional<Movie> getAMovie(String id) throws Exception
    {
        Optional<Movie> movie=repository.findById(id);
//        return repository.findById(id);
        if(!movie.isPresent())
        {
            throw new Exception("movie wit" +id+"is not found");
        }
        return movie;
    }

    public void deleteAMovie(String id)
    {
        repository.deleteById(id);
    }
}
