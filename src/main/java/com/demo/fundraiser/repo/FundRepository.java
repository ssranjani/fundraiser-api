package com.demo.fundraiser.repo;

import com.demo.fundraiser.model.Fund;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FundRepository extends MongoRepository<Fund, String> {

}
