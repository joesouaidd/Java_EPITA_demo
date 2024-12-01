package test;

import main.datamodel.Patient;
import main.services.PatientDAO;
import main.services.PatientReader;

import java.io.File;
import java.util.List;

public class TestJDB2 {

    public static void main(String[] args) {
        try {
            File patientsFile = new File("resources/patients.csv");
            System.out.println("File exists: " + patientsFile.exists());

            List<Patient> patients = PatientReader.readAll(patientsFile);


            PatientDAO dao = new PatientDAO();
            dao.createTable();
            System.out.println("Table created");


            for (Patient p : patients) {
                dao.createPatient(p);
                System.out.println("Added to the DB \n" + p + " " +p.getPatientNb());
            }

            System.out.println( "the searched for patient from the DB is: \n" + dao.getPatientByNumber("1256987452365"));
            dao.deletePatient("1256987452365");

            System.out.println( "the searched for patient from the DB is: \n" + dao.getPatientByNumber("1256987452365"));

            System.out.println("Searching for patiend by first and last name: ");
            System.out.println (dao.getPatientByName("Anna", "Solti"));

            Patient toUpdate = dao.getPatientByName("Anna", "Solti");

            toUpdate.setPat_tel("6969");
            dao.updatePatient(toUpdate);
            System.out.println("Updated patient: \n" + dao.getPatientByName("Anna", "Solti"));

            dao.deletePatient(toUpdate.getPatientNb());
            System.out.println("Deleted patient: " + toUpdate.getPat_firstname());






        } catch(Exception e){
                e.printStackTrace();
        }



    }
}