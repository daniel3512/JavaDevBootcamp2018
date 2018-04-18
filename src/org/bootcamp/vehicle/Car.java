package org.bootcamp.vehicle;

public final class Car extends Vehicle {

    private String transmission="manual";

    public Car(){

    }

    public Car(int age, long numberOfMiles, boolean isDiesel, String transmission){
        super(age,numberOfMiles,isDiesel);
        this.transmission = transmission;
    }

    public String getTransmisie() {
        return transmission;
    }

    public void setTransmisie(String transmission) {
        this.transmission = transmission;
    }
}
