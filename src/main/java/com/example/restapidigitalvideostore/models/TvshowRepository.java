package com.example.restapidigitalvideostore.models;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TvshowRepository extends MongoRepository<Tvshow,String>
{
}
