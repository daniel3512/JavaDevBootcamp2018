package org.bootcamp.formula;

import org.bootcamp.vehicle.Vehicle;

public final class BusBasicFormula implements Formula {

    @Override
    public int calculate(Vehicle vehicle) {
        int cost = 200*vehicle.getAge();

        cost += vehicle.isDiesel()?1000:0;

        cost += vehicle.getNumberOfMiles()>200000?1000:vehicle.getNumberOfMiles()>100000?500:0;

        return cost;
    }
}
