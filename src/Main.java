import db.DateBase;
import enums.Gender;
import model.Hospital;
import model.Patient;
import service.impl.PatientServiceImpl;

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