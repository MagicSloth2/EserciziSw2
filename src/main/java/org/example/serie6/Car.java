package org.example.serie6;

import jakarta.inject.Inject;

public class Car {

    @Inject
    private IEngine engine;

    @Inject
    private IBody body;

    private Frame frame;
    private Interior interior;
    private Wheel[] wheels;


    @Inject
    public Car(IBody body, IEngine engine, Interior interior, Wheel[] wheels, Frame frame) {
        this.engine = engine;
        this.body = body;
        this.interior = interior;
        this.wheels = wheels;
        this.frame = frame;

    }

//    public double getWeight() {
//        // ad esempio: somma dei pesi delle componenti
//        return body.getWeight() + engine.getWeight() + frame.getWeight()
//                + interior.getWeight() + (wheels.length * wheels[0].getWeight());
//    }
}
