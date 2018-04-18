package org.bootcamp;

public final class InsurancePolicyCalculator {

    public static InsurancePolicyCalculator INSTANCE = new InsurancePolicyCalculator();

    private InsurancePolicyCalculator(){

    }

    public int calculate(Vehicle vehicle, Formula formula){
        return formula.calculate(vehicle);
    }

}
