package com.example.housekeeping;

import com.example.housekeeping.interfaces.CleaningService;
import com.example.housekeeping.interfaces.DomesticService;
import com.example.housekeeping.interfaces.GardeningService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HouseApp {
    public static void main(String[] args) {

        System.out.println("Welke plaats is dit :p");
        try (ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class)) {

            System.out.println("Container initiliazed");
            CleaningService jill = ctx.getBean("jill", CleaningService.class);
            CleaningService bob = ctx.getBean("bob", CleaningService.class);
            CleaningService jane = ctx.getBean("jane", CleaningService.class);
            CleaningService scott = ctx.getBean("scotty", CleaningService.class);
            GardeningService renzo = ctx.getBean("renzo", GardeningService.class);
            DomesticService service1 = ctx.getBean("service1", DomesticService.class);
//            Thread.sleep(2000);

//            jill.clean();
//            bob.clean();
//            jane.clean();
//            scott.clean();
//            renzo.garden();
            service1.runHousehold();
            ctx.close();
//        Thread.sleep(5000);
        }
    }
}
