import db.DateBase;
import enums.Gender;
import model.Department;
import model.Doctor;
import model.Hospital;
import model.Patient;
import service.impl.HospitalServiceImpl;
import service.impl.PatientServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PatientServiceImpl patientServiceImpl = new PatientServiceImpl();
        Patient patient = new Patient(2L, "kjhdf", "lkjh", 33, Gender.MALE);
        System.out.println(patientServiceImpl.addPatientToHospital(2L, patient));
        DateBase dateBase = new DateBase();
        System.out.println(dateBase.getHospitals());
        System.out.println("---------------");
        System.out.println("--------------");







    }

}