package main.services;

import main.datamodel.Patient;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

public class PatientBLService {

    public static Integer computeSeniority(Patient patient){
    // method body

        Integer seniority;
        java.sql.Date currentDate = new Date(System.currentTimeMillis());
        long differenceInMillis = currentDate.getTime() - patient.getPat_sub_date().getTime();
        seniority = (int) (differenceInMillis / (1000L * 60 * 60 * 24 * 365));

        return seniority;
    }

    public static HashMap<String,Integer> computeSeniorityByPatient(List<Patient> patients){
        // method body
        HashMap<String,Integer> seniorityByPatient = new HashMap<>();
        for (Patient patient : patients) {
            seniorityByPatient.put(patient.getPatientNb(), computeSeniority(patient));
        }
        return seniorityByPatient;
    }

}
