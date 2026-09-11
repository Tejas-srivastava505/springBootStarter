package com.LearningRest.demo.Service;

import com.LearningRest.demo.entity.JournalEntry;
import com.LearningRest.demo.repository.JournalEntryRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
//This is for business Logic
public class JournalEntryService {

    @Autowired
    private JournalEntryRepo journalEntryRepo; //implementation of this interface is manganed by spring.

    public void saveEntry(JournalEntry je){
        journalEntryRepo.save(je);
    }
    public List<JournalEntry> getAll(){
        return journalEntryRepo.findAll();
    }

    public Optional<JournalEntry> getbyId(ObjectId id){ //
        return journalEntryRepo.findById(id);
    }
    public JournalEntry deleteById(ObjectId id){
        Optional<JournalEntry> old = this.getbyId(id);
        journalEntryRepo.deleteById(id);
        return old.orElse(null);
    }
}


