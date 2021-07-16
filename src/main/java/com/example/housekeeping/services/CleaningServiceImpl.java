package com.example.housekeeping.services;

import com.example.housekeeping.interfaces.CleaningTool;
import com.example.housekeeping.interfaces.CleaningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CleaningServiceImpl implements CleaningService {

    private CleaningTool tool;

    public void setCleaningTool(CleaningTool tool){
        this.tool = tool;
    }

//    @Autowired
//    public CleaningServiceImpl(CleaningTool tool) {
//        this.tool = tool;
//    }

    @Override
    public void clean() {
        System.out.println("Cleaning the house");
        tool.doCleanJob();
    }

    @Autowired // constructor injection
    public CleaningServiceImpl(@Qualifier("broom")CleaningTool tool) {
        System.out.println("CleaningService: "+this.getClass().getSimpleName()+"  Object created in spring container");
        this.tool= tool;
    }
}
