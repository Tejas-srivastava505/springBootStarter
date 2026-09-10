package com.LearningRest.demo.repository;

import com.LearningRest.demo.entity.JournalEntry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalEntryRepo extends MongoRepository<JournalEntry,String> {


}
