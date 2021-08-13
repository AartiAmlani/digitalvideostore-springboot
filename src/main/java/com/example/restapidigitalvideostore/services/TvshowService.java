package com.example.restapidigitalvideostore.services;

import com.example.restapidigitalvideostore.models.Movie;
import com.example.restapidigitalvideostore.models.Tvshow;
import com.example.restapidigitalvideostore.models.TvshowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TvshowService {
    @Autowired
    private TvshowRepository repository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Tvshow> getTvshows()

    {
        //validation or calculation or call model
        return repository.findAll();
    }
    public List<Tvshow> getTvshowsWithRating(String r) {
        // business logics
        Query query = new Query();
        query.addCriteria(Criteria.where(" rating").is(r));
        List<Tvshow> tvshows = mongoTemplate.find(query, Tvshow.class);
        return tvshows;
    }
    public List<Tvshow> getTvshowsWithFeatured(Boolean x) {
        // business logics
        Query query = new Query();
        query.addCriteria(Criteria.where("featured").is(x));
        List<Tvshow> tvshows = mongoTemplate.find(query, Tvshow.class);
       return tvshows;
    }
    public List<Tvshow> getTvshowsWithTitle(String t) {

        // business logics
        Query query = new Query();
        query.addCriteria(Criteria.where("title").is(t));
        List<Tvshow> tvshows = mongoTemplate.find(query, Tvshow.class);
        return tvshows;
    }
    public void insertIntoTvshows(Tvshow tvshow)
    {

        repository.insert(tvshow);
    }
    public Tvshow editTvshow(String id, Tvshow newTvshowData)
    {
        // get the resource based on the id

        Optional<Tvshow> tvshow = repository.findById(id);

        // validation code to validate the id

        tvshow.get().setTitle(newTvshowData.getTitle());
        tvshow.get().setDescription(newTvshowData.getDescription());
        tvshow.get().setRating(newTvshowData.getRating());
        tvshow.get().setPoster(newTvshowData.getPoster());
        tvshow.get().setDateReleased(newTvshowData.getDateReleased());
        tvshow.get().setBuy(newTvshowData.getBuy());
        tvshow.get().setRent(newTvshowData.getRent());
        tvshow.get().setFeatured(newTvshowData.getFeatured());

        Tvshow updateTvshow = repository.save(tvshow.get());

        return updateTvshow;
    }
    //it might return null so we use optional
    public Optional<Tvshow> getATvshow(String id) throws Exception
    {
        Optional<Tvshow> tvshow=repository.findById(id);
//        return repository.findById(id);
        if(!tvshow.isPresent())
        {
            throw new Exception("tvshow with" +id+"is not found");
        }
        return tvshow;
    }

    public void deleteATvshow(String id)
    {
        repository.deleteById(id);
    }
}
