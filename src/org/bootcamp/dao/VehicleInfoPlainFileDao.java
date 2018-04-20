package org.bootcamp.dao;

import org.bootcamp.calculate.InsurancePolicyCalculator;
import org.bootcamp.formula.Formula;
import org.bootcamp.model.VehicleInfo;
import org.bootcamp.vehicle.Bus;
import org.bootcamp.vehicle.Car;
import org.bootcamp.vehicle.Tipper;
import org.bootcamp.vehicle.Vehicle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class VehicleInfoPlainFileDao implements VehicleDao{
    private static final String SEPARATOR = ";";
    private static final int VEHICLE_TYPE = 1;
    private static final int VEHICLE_AGE = 3;
    private static final int VEHICLE_MILES = 4;
    private static final int VEHICLE_IS_DIESEL = 5;
    private static final int VEHICLE_FORMULA = 2;
    private static final int VEHICLE_ID = 0;
    private final String filePath;
    private  List<VehicleInfo> vehicleInfos;

    public VehicleInfoPlainFileDao(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<VehicleInfo> getAllVehicles(){
        vehicleInfos = new ArrayList<VehicleInfo>();

            final File inputFile = new File(filePath);

            try {
                final InputStream inputStream = new FileInputStream(inputFile);
                final Scanner scanner = new Scanner(inputStream);

                while(scanner.hasNextLine()){
                    final String line = scanner.nextLine();

                    final String[] tokens = line.split(SEPARATOR);

                    final VehicleInfo vehicleInfo = new VehicleInfo(tokens[VEHICLE_ID],tokens[VEHICLE_TYPE],
                            tokens[VEHICLE_FORMULA], Integer.parseInt(tokens[VEHICLE_AGE]), Long.parseLong(tokens[VEHICLE_MILES]),
                            Boolean.parseBoolean(tokens[VEHICLE_IS_DIESEL]));
                    
                    vehicleInfos.add(vehicleInfo);
                }

                scanner.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            return vehicleInfos;
    }
}
