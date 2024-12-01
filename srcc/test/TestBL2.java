package test;

import main.datamodel.Patient;
import main.services.PatientBLService;
import main.services.PatientReader;

import java.io.File;
import java.util.HashMap;
import java.util.List;

public class TestBL2 {

    public static void main(String[] args) {

        try {
            File patientsFile = new File("resources/patients.csv");
            List<Patient> patients = PatientReader.readAll(patientsFile);

            HashMap<String,Integer> seniorityByPatient = PatientBLService.computeSeniorityByPatient(patients);
            System.out.println(seniorityByPatient);

        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
