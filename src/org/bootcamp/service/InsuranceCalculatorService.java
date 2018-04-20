package org.bootcamp.service;

import org.bootcamp.calculate.InsurancePolicyCalculator;
import org.bootcamp.dao.VehicleInfoPlainFileDao;
import org.bootcamp.formula.Formula;
import org.bootcamp.model.VehicleInfo;
import org.bootcamp.vehicle.Bus;
import org.bootcamp.vehicle.Car;
import org.bootcamp.vehicle.Tipper;
import org.bootcamp.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class InsuranceCalculatorService {
    private String filePath;

    public InsuranceCalculatorService(String filePath){
        this.filePath = filePath;
    }

    public List<InsuranceCalculationResult> calculateAll() {
        final InsurancePolicyCalculator calculator = InsurancePolicyCalculator.INSTANCE;
        final VehicleInfoPlainFileDao vehicleInfo = new VehicleInfoPlainFileDao(filePath);
        final List<VehicleInfo> vehicleInfoList = vehicleInfo.getAllVehicles();
        List<InsuranceCalculationResult> resultList = new ArrayList<InsuranceCalculationResult>();

        if (vehicleInfoList.isEmpty()) {
            return Collections.emptyList();
        } else {
            for (VehicleInfo info : vehicleInfoList) {

                final Vehicle vehicle = getVehicle(info.getVehicleTypeName(), info.getAge(),info.getNumberOfMiles(), info.isDiesel());
                final Formula formula = Formula.valueOf(info.getVehicleTypeFormula());
                final int totalCost = calculator.calculate(vehicle, formula);
                final InsuranceCalculationResult insuranceCalculationResult = new InsuranceCalculationResult(info.getId(),totalCost);

                final String output = String.format("vehicle with id %s has total cost %d", info.getId(), totalCost);

                System.out.println(output);
            }
        }

        return resultList;
    }

    private static Vehicle getVehicle(String vehicleName, int age, long numberOfmiles, boolean isDiesel){
        String carClassName = Car.class.getSimpleName().toUpperCase();
        String busClassName = Bus.class.getSimpleName().toUpperCase();
        String tipperClassName = Tipper.class.getSimpleName().toUpperCase();

        if(vehicleName.equals(carClassName)){
            return new Car();
        }

        if(vehicleName.equals(busClassName)){
            return new Bus();
        }

        if(vehicleName.equals(tipperClassName)){
            return new Tipper();
        }

        return null;
    }
}
