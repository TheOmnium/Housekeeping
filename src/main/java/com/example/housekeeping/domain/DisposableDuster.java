package com.example.housekeeping.domain;

import com.example.housekeeping.interfaces.CleaningTool;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype",proxyMode= ScopedProxyMode.INTERFACES)
@Qualifier("duster")
public class DisposableDuster implements CleaningTool {

    private Boolean used = false;

    @Override
    public void doCleanJob() {
        if(used){
            System.out.println("I'm already used. Please throw me away");
        }else {
            System.out.println("Wipe the dust away");
            used = true;
        }
    }
}
