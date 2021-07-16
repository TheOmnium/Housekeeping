package com.example.housekeeping.services;

import com.example.housekeeping.interfaces.CleaningService;
import com.example.housekeeping.interfaces.CleaningTool;
import com.example.housekeeping.interfaces.DomesticService;
import com.example.housekeeping.interfaces.GardeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class DomesticServiceImpl implements DomesticService {

    @Autowired // field injection
    private Logger logger;
    private CleaningService cleaningService;

    private GardeningService gardeningService;

    @Autowired // setter injection
    public void setCleaningService(CleaningService cleaningService){
        this.cleaningService = cleaningService;
    }
    @Autowired
    public void setGardeningService(GardeningService gardeningService){
        this.gardeningService = gardeningService;
    }



    @Override
    public void runHousehold() {
        logger.severe("Running the  household");
//        System.out.println("Running the household");
        cleaningService.clean();
        gardeningService.garden();
    }


    public DomesticServiceImpl() {
        System.out.println("Domestic service: "+this.getClass().getSimpleName()+"  Object created in spring container");
    }
}
