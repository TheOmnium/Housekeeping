package com.example.housekeeping;
import com.example.housekeeping.domain.*;
import com.example.housekeeping.interfaces.*;
import com.example.housekeeping.services.CleaningServiceImpl;
import com.example.housekeeping.services.DomesticServiceImpl;
import com.example.housekeeping.services.GardeningServiceImpl;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.context.annotation.*;

import java.util.logging.Logger;

@Configuration
public class AppConfig {

    @Bean
    @Scope("prototype")
    @Primary
    @Lazy
    public Broom broom(){
        System.out.println("Broom created");
        return new Broom();
    }
    @Bean
    public Sponge sponge() {
        System.out.println("Sponge created");
        return new Sponge();
    }
    @Bean
    public VacuumCleaner vacuumCleaner(){
        System.out.println("Vacuum cleaner created");
        return new VacuumCleaner();
    }

    @Bean
    @Scope(value="prototype",proxyMode=ScopedProxyMode.INTERFACES)
    public CleaningTool duster(){
        return new DisposableDuster();
    }

    @Bean
    @Lazy
    @Primary
    public GardeningTool lawnMower(){
        return new LawnMower();
    }

    @Bean(value="jill")
    @Primary
    @Lazy
    public CleaningService jill(){
        CleaningServiceImpl cs = new CleaningServiceImpl(broom());
//        cs.setCleaningTool(broom());
        return cs;
    }
    @Bean(value="bob")
    @Lazy
    public CleaningService bob(){
        CleaningServiceImpl cs = new CleaningServiceImpl(vacuumCleaner());
//        cs.setCleaningTool(vacuumCleaner());
        return cs;
    }

    @Bean(value="jane")
    @Lazy
    public CleaningService jane() { // constructor injection like the other ones underneath
        CleaningServiceImpl cs = new CleaningServiceImpl(sponge());
//        cs.setCleaningTool(sponge());
        return cs;
    }

    @Bean(value="scotty")
    public CleaningService scott(){
        CleaningServiceImpl cs = new CleaningServiceImpl(duster());
//        cs.setCleaningTool(broom());
        return cs;
    }

    @Bean(initMethod="init", destroyMethod="destroy")
    public GardeningService renzo(GardeningTool tool){
        GardeningServiceImpl gs = new GardeningServiceImpl();
        gs.setGardeningTool(tool);
        return gs;
    }

    @Bean
    @Lazy
    public DomesticService service1(){
        DomesticServiceImpl ds = new DomesticServiceImpl();
        ds.setGardeningService(renzo(lawnMower()));
        ds.setCleaningService(jane());
        return ds;
    }

    @Bean
    @Scope("prototype")
    public Logger logger(InjectionPoint ip){
        return Logger.getLogger(ip.getClass().getName());
    }

}