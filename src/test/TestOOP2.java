package test;

import main.datamodel.Insurance;
import main.datamodel.Patient;
import main.services.InsuranceReader;
import main.services.PatientReader;
import main.*;
import java.util.*;

public class TestOOP2 {

    public static void main(String[] args) {

        List<Patient> patients = PatientReader.readAll();
        List<Insurance> insurances = InsuranceReader.readAll();

    }
}
