package com.LearningRest.demo.Controller;


import com.LearningRest.demo.Service.JournalEntryService;
import com.LearningRest.demo.entity.JournalEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/journel")
public class JournalEntryControllerV2 {


    @Autowired
    private JournalEntryService jes; //Spring se maang liya


    @GetMapping
    public ArrayList<JournalEntry> getAll(){
        jes.getAll();
        return null;
    }
    @PostMapping
    public boolean addEntry(@RequestBody JournalEntry jy){
        jes.saveEntry(jy);
        return true;
    }
    //for Specific entry
    @GetMapping("/user/{myID}")
    public JournalEntry getByID(@PathVariable Long myID){
        return null;
    }

    @DeleteMapping("/user/{myId}")
    public JournalEntry delById(@PathVariable Long myId){
        return null;
    }

    @PutMapping("/user/{myId}")
    public JournalEntry updateById(@PathVariable Long myId, @RequestBody JournalEntry je){
        return null;
    }


}
