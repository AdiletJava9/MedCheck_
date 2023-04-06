import dao.daoClasses.DepartmentDaoImpl;
import dao.daoClasses.HospitalDaoImpl;
import db.DateBase;
import enums.Gender;
import model.Department;
import model.Doctor;
import model.Hospital;
import model.Patient;
import service.impl.DepartmentServiceImpl;
import service.impl.DoctorServiceImpl;
import service.impl.HospitalServiceImpl;
import service.impl.PatientServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DateBase dateBase = new DateBase();
        DepartmentServiceImpl departmentService = new DepartmentServiceImpl(dateBase);
        DoctorServiceImpl doctorService = new DoctorServiceImpl(dateBase);
        HospitalServiceImpl hospitalService = new HospitalServiceImpl(dateBase);
        PatientServiceImpl patientService = new PatientServiceImpl(dateBase);
//        ----------------------------------------------------------------------
        Patient patient1 = new Patient(1L, "adi", "is", 22, Gender.MALE);
        Patient patient2 = new Patient(2L, "adi", "is", 22, Gender.MALE);
        Patient patient3 = new Patient(3L, "adi", "is", 22, Gender.MALE);

        List<Patient> patients = new ArrayList<>(Arrays.asList(patient1, patient2));

        Doctor doctor = new Doctor(1L, "jk", "kll", Gender.MALE, 3);
        Doctor doctor1 = new Doctor(2L, "jk", "kll", Gender.MALE, 3);
        List<Doctor> doctors = new ArrayList<>(Arrays.asList(doctor1, doctor));

        Department department = new Department(1L, "hjlk", doctors);
        Department department1 = new Department(2L, "hjlk", doctors);

        List<Department> departments = new ArrayList<>(Arrays.asList(department1, department));

        Hospital hospital = new Hospital(1L, "HH", "h",departments,doctors,patients);
        System.out.println(hospitalService.getAllPatientFromHospital(1L));
    }

}