package com.LearningRest.demo.Controller;


import com.LearningRest.demo.entity.JournelEntry;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/_journel")
public class JourneyEntryController {
    private Map<Long,JournelEntry> journalEntries=new HashMap<>(); //Long will have id, serves as index.



    @GetMapping
    public ArrayList<JournelEntry> getAll(){

        return new ArrayList<>(journalEntries.values());
    }
    @PostMapping
    public boolean addEntry(@RequestBody JournelEntry jy){
        journalEntries.put(jy.getId(), jy);
        return true;
    }
    //for Specific entry
    @GetMapping("/user/{myID}")
    public JournelEntry getByID(@PathVariable Long myID){
        return journalEntries.get(myID);
    }

    @DeleteMapping("/user/{myId}")
    public JournelEntry delById(@PathVariable Long myId){
        return journalEntries.remove(myId);
    }

    @PutMapping("/user/{myId}")
    public JournelEntry updateById(@PathVariable Long myId, @RequestBody JournelEntry je){
        return journalEntries.put(myId,je);
    }


}
