package com.LearningRest.demo.Service;

import com.LearningRest.demo.entity.JournalEntry;
import com.LearningRest.demo.repository.JournalEntryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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
}


