package com.example.housekeeping.services;
import com.example.housekeeping.interfaces.GardeningTool;
import com.example.housekeeping.interfaces.GardeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GardeningServiceImpl implements GardeningService {

    private GardeningTool tool;

    @Autowired
    public void setGardeningTool(GardeningTool tool) {
        this.tool = tool;
    }

    @Override
    public void init() {
        System.out.println("GardeningService preparing for work.");
    }

    @Override
    public void destroy() {
        System.out.println("GardeningService cleaning up.");
    }

    @Override
    public void garden() {
        System.out.println("working in the garden");
        tool.doGardenJob();
    }

    public GardeningServiceImpl() {
        System.out.println("Gardening service: "+this.getClass().getSimpleName()+"  Object created in spring container");
    }
}