package org.bootcamp.vehicle;

public final class Bus extends Vehicle{

    private int numerOfSeats;

    public Bus(){

    }

    public Bus(int age, long numberOfMiles, boolean isDiesel, int numerOfSeats ){
        super(age,numberOfMiles,isDiesel);
        this.numerOfSeats = numerOfSeats;
    }

    public int getNumerOfSeats() {
        return numerOfSeats;
    }

    public void setNumerOfSeats(int numerOfSeats) {
        this.numerOfSeats = numerOfSeats;
    }
}
