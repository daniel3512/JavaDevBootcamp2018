package org.bootcamp;

public final class InsurancePolicyCalculator {

    public static InsurancePolicyCalculator INSTANCE = new InsurancePolicyCalculator();

    private InsurancePolicyCalculator(){

    }

    public int calculate(Car car){
        int cost = 100*car.getAge();

        cost += car.isDiesel()?500:0;

        cost += car.getNumberOfMiles()>200000?500:0;

        return cost;
    }

    public int calculate(Bus bus){
        int cost = 200*bus.getAge();

        cost += bus.isDiesel()?1000:0;

        cost += bus.getNumberOfMiles()>200000?1000:bus.getNumberOfMiles()>100000?500:0;

        return cost;
    }

    public int calculate(Tipper tipper){
        int cost = 300*tipper.getAge();

        cost += tipper.getNumberOfMiles()>80000?700:0;

        return cost;
    }

}
