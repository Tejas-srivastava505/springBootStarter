package com.LearningRest.demo.Controller;


import com.LearningRest.demo.Service.JournalEntryService;
import com.LearningRest.demo.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ArrayList<JournalEntry>> getAll(){ //get ok or get NOT_FOUND.
        try{
            return new ResponseEntity<>(new ArrayList<>(jes.getAll()), HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping
    public ResponseEntity<JournalEntry> addEntry(@RequestBody JournalEntry jy){  //created or bad request.
        try {
            jy.setDate(LocalDateTime.now());
            jes.saveEntry(jy);
            return new ResponseEntity<>(jy,HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
    }
    //for Specific entry
    @GetMapping("/user/{myID}")  //either found or not_found
    public ResponseEntity<JournalEntry> getByID(@PathVariable ObjectId myID){
        JournalEntry found=jes.getbyId(myID).orElse(null);
        if(found!=null){
            return new ResponseEntity<>(found,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/user/{myId}") //Either deleted or not found
    public ResponseEntity<JournalEntry> delById(@PathVariable ObjectId myId){
        try{
            jes.deleteById(myId);  //invalid request is also returning 204 No_Content
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/user/{myId}")
    public ResponseEntity<JournalEntry> updateById(@PathVariable ObjectId myId, @RequestBody JournalEntry je){
        JournalEntry old =  jes.getbyId(myId).orElse(null); //get the object, if present.
        if(old == null){
            return new ResponseEntity<>(je,HttpStatus.NOT_FOUND);
        }
        //check if new is not null and empty
        old.setTitle( ((je.getTitle()!=null) && (!je.getTitle().isEmpty())) ? je.getTitle() : old.getTitle());
        old.setContent( ((je.getContent()!=null) && (!je.getContent().isEmpty()) ) ? je.getContent() : old.getContent());
        jes.saveEntry(old);
        return new ResponseEntity<>(old,HttpStatus.OK);
    }

}