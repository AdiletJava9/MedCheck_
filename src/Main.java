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
        //////////////////////////////////////////////////////////////////////////////
        Patient patient = new Patient(1L, "Adilet", "Islambek uulu", 22, Gender.MALE);
        Patient patient1 = new Patient(2L, "Erbol", "Ashirali uulu", 19, Gender.MALE);
        Patient patient2 = new Patient(3L, "Gulmira", "Osmonova", 18, Gender.FEMALE);
        Patient patient3 = new Patient(4L, "Ainazik", "Amangeldieva", 18, Gender.FEMALE);
        //////////////////////////////////////////////////////////////////////////////
        List<Patient> patients = new ArrayList<>(Arrays.asList(patient1, patient, patient2, patient3));
        List<Patient> patients1 = new ArrayList<>(Arrays.asList(patient, patient2));
        //////////////////////////////////////////////////////////////////////////////
        Doctor doctor = new Doctor(1L, "Albert", "Maxim", Gender.MALE, 4);
        Doctor doctor1 = new Doctor(2L, "Ron", "Cr7", Gender.MALE, 3);
        Doctor doctor2 = new Doctor(3L, "Messi", "Lionel", Gender.MALE, 5);
        Doctor doctor3 = new Doctor(4L, "Neymar", "Jr", Gender.MALE, 7);
        //////////////////////////////////////////////////////////////////////////////
        List<Doctor> doctors = new ArrayList<>(Arrays.asList(doctor1, doctor, doctor3, doctor2));
        List<Doctor> doctors1 = new ArrayList<>(Arrays.asList(doctor1, doctor2));
        List<Doctor> doctors2 = new ArrayList<>(Arrays.asList(doctor1, doctor2));
        List<Doctor> doctors3 = new ArrayList<>(Arrays.asList(doctor1, doctor2));
        //////////////////////////////////////////////////////////////////////////////
        Department department = new Department(1L, "Hirurgia", doctors);
        Department department1 = new Department(2L, "Teraphia", doctors1);
        Department department2 = new Department(2L, "Teraphia", doctors1);
        Department department3 = new Department(2L, "Teraphia", doctors1);
        ///////////////////////////////////////////////////////////////////////////////
        List<Department> departments = new ArrayList<>(Arrays.asList(department1, department));
        List<Department> departments1 = new ArrayList<>(Arrays.asList(department3, department2));
        ///////////////////////////////////////////////////////////////////////////////
        Hospital hospital = new Hospital(1L, "N34", "Vostok5", departments1, doctors, patients);
        Hospital hospital1 = new Hospital(2L, "N1", "Bishkek", departments, doctors2, patients1);
        Hospital hospital2 = new Hospital(3L, "N4", "Tokomok", departments1, doctors1, patients);
        Hospital hospital3 = new Hospital(4L, "N324", "Almata", departments, doctors3, patients1);
        ///////////////////////////////////////////////////////////////////////////////
        hospitalService.addHospital(hospital);
        hospitalService.addHospital(hospital1);
        hospitalService.addHospital(hospital2);
        hospitalService.addHospital(hospital3);
        ////////////////////////////////////////////////////////////////////////////////
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~PATIENTS~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(hospitalService.getAllPatientFromHospital(2L));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~HOSPITALS~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(hospitalService.getAllHospital());
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~FIND ID~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(hospitalService.findHospitalById(2L));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~DELETED~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(hospitalService.deleteHospitalById(3L));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~BY ADDRESS~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        hospitalService.getAllHospitalByAddress("Almata");


    }

}