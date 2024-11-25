package main.services;

import main.datamodel.Insurance;
import main.datamodel.Patient;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class PatientReader {


    public static final String INPUT_DELIMITER = ";";

    public static List<Patient> readAll(File csvFile) throws IOException {

        List<Patient> patients = new ArrayList<>();
        List<String> lines = Files.readAllLines(csvFile.toPath());
        System.out.println(lines.get(0));

        List<String> errors = new ArrayList<>();


        for (String line : lines){
            System.out.println(line);
            try {
                String[] patientParts = line.split(INPUT_DELIMITER);
                Patient patient = new Patient();
                //pat_num_HC;pat_lastname;pat_firstname;pat_address;pat_tel;pat_insurance_id;pat_subscription_date
                patient.setPatientNb(patientParts[0].trim());
                patient.setPat_lastname(patientParts[1].trim());
                patient.setPat_firstname(patientParts[2].trim());
                patient.setPat_address(patientParts[3].trim());
                patient.setPat_tel(patientParts[4].trim());
                patient.setPat_insurance_id(Integer.parseInt(patientParts[5].trim()));
                patient.setPat_sub_date(Date.valueOf(patientParts[6].trim()));

                patients.add(patient);

            } catch (Exception e){
                errors.add(line);
                System.out.println(e.getMessage());
            }
        }
        System.out.println("patients number: " + patients.size());
        System.out.println("errors size: " +errors.size());
        return patients;
    }





}
