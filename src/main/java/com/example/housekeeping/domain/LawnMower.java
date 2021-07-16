package com.example.housekeeping.domain;

import com.example.housekeeping.interfaces.GardeningTool;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope("prototype")
public class LawnMower implements GardeningTool {

    @Override
    public void doGardenJob() {
        System.out.println("Mowing the lawn");
    }
}



