package org.bootcamp.calculate;

import org.bootcamp.formula.Formula;
import org.bootcamp.vehicle.Vehicle;

public final class InsurancePolicyCalculator {

    public static InsurancePolicyCalculator INSTANCE = new InsurancePolicyCalculator();

    private InsurancePolicyCalculator(){

    }

    public int calculate(Vehicle vehicle, Formula formula)
    {
        return formula.calculate(vehicle);
    }

}
