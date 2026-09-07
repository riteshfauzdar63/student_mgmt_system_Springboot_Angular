package com.ritesh.my_first_app;

import org.springframework.stereotype.Component;

@Component
public class Car {
    private final Engine engine;

    // Constructor Injection — Spring khud Engine ka object yahan bhej dega
    public Car(Engine engine){
        this.engine = engine;
    }

    public void drive(){
        engine.start();
        System.out.println("Car is driving");
    }

}
