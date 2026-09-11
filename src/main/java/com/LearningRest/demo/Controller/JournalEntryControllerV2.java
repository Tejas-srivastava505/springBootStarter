package com.LearningRest.demo.Controller;


import com.LearningRest.demo.Service.JournalEntryService;
import com.LearningRest.demo.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {


    @Autowired
    private JournalEntryService jes; //Spring se maang liya


    @GetMapping
    public ArrayList<JournalEntry> getAll(){
        return new ArrayList<>(jes.getAll());
    }
    @PostMapping
    public JournalEntry addEntry(@RequestBody JournalEntry jy){
        jy.setDate(LocalDateTime.now());
        jes.saveEntry(jy);
        return jy;
    }
    //for Specific entry
    @GetMapping("/user/{myID}")
    public JournalEntry getByID(@PathVariable ObjectId myID){
        return jes.getbyId(myID).orElse(null);
    }

    @DeleteMapping("/user/{myId}")
    public JournalEntry delById(@PathVariable ObjectId myId){
        return jes.deleteById(myId);
    }

    @PutMapping("/user/{myId}")
    public JournalEntry updateById(@PathVariable ObjectId myId, @RequestBody JournalEntry je){
        return null;
    }


}
