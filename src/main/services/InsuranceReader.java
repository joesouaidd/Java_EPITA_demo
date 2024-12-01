package main.services;

import main.datamodel.Insurance;

import java.io.*;
import java.util.*;
import java.nio.file.Files;
import java.util.ArrayList;

public class InsuranceReader {

    public static final String INPUT_DELIMITER = ";";

    public static List<Insurance> readAll(File csvFile) throws IOException{

            List<Insurance> insurances = new ArrayList<>();
            List<String> lines = Files.readAllLines(csvFile.toPath());
            System.out.println(lines.get(0));
            lines.remove(0);
            List<String> errors = new ArrayList<>();


        for (String line : lines) {
            System.out.println(line);
            try {
                String[] insuranceParts = line.split(INPUT_DELIMITER);
                if (insuranceParts.length < 2) {
                    throw new IllegalArgumentException("Invalid line format: " + line);
                }
                Insurance insurance = new Insurance();
                // id ; name
                insurance.setInsurance_id(Integer.parseInt(insuranceParts[0].trim()));
                insurance.setInsurance_name(insuranceParts[1].trim());

                insurances.add(insurance);
            } catch (Exception e) {
                errors.add(line);
                System.out.println(e.getMessage());
            }
        }
            System.out.println("Insurance size: " + insurances.size());
            System.out.println("errors size: " +errors.size());
            return insurances;
        }




}
