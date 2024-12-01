package test;

import main.datamodel.Insurance;
import main.datamodel.Patient;
import main.services.InsuranceReader;
import main.services.PatientReader;
import main.*;

import java.io.File;
import java.util.*;

public class TestOOP2 {

    public static void main(String[] args) {


        try {
            File patientsFile = new File("resources/patients.csv");
            File insurancesFile = new File("resources/insurances.csv");
            List<Patient> patients = PatientReader.readAll(patientsFile);
            List<Insurance> insurances = InsuranceReader.readAll(insurancesFile);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
