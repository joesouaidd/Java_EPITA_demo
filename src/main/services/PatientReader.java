package main.services;

import main.datamodel.Insurance;
import main.datamodel.Patient;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;

public class PatientReader {


    public static final String INPUT_DELIMITER = ";";

    public static List<Patient> readAll(File csvFile) throws IOException {

        List<Patient> patients = new ArrayList<>();
        List<String> lines = Files.readAllLines(csvFile.toPath());
        lines.remove(0);
        System.out.println("Header removed");

        List<String> errors = new ArrayList<>();


        for (String line : lines) {
//            System.out.println(line);
            try {

                String [] patientParts = line.replaceAll("\"", "").split(";");
                if (patientParts.length < 7) {
                    throw new IllegalArgumentException("Invalid line format: " + line);
                }
                Patient patient = new Patient();
                // pat_num_HC;pat_lastname;pat_firstname;pat_address;pat_tel;pat_insurance_id;pat_subscription_date
                patient.setPatientNb(patientParts[0].trim());
                patient.setPat_lastname(patientParts[1].trim());
                patient.setPat_firstname(patientParts[2].trim());
                patient.setPat_address(patientParts[3].trim());
                patient.setPat_tel(patientParts[4].trim());
                patient.setPat_insurance_id(Integer.parseInt(patientParts[5].trim()));
                SimpleDateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");
                patient.setPat_sub_date(new java.sql.Date(dateFormat.parse(patientParts[6].trim()).getTime()));

                patients.add(patient);
            } catch (Exception e) {
                //errors.add(line);
                //System.out.println("Error processing line: " + line);
                System.out.println("Exception type: " + e.getClass().getName());
                System.out.println(e.getMessage());
            }
        }
        System.out.println("patients number read from file: " + patients.size());
        System.out.println("errors number: " +errors.size());
        return patients;
    }





}
