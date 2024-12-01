package test;

import main.datamodel.Insurance;
import main.datamodel.Patient;
import main.services.InsuranceReader;
import main.services.PatientBLService;
import main.services.PatientReader;

import java.io.File;
import java.util.List;

public class TestBLI1 {

    public static void main(String[] args) {

        try {
            File patientsFile = new File("resources/patients.csv");
            List<Patient> patients = PatientReader.readAll(patientsFile);

            System.out.println (PatientBLService.computeSeniority(patients.get(5)) + " Years");

        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

}
