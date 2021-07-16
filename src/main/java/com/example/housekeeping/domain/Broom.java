package com.example.housekeeping.domain;

import com.example.housekeeping.interfaces.CleaningTool;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Qualifier("broom")

public class Broom implements CleaningTool {


    @Override
    public void doCleanJob() {
        System.out.println("Scrub scrub");
    }


}


