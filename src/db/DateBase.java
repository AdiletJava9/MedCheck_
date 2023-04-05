package db;

import model.Department;
import model.Doctor;
import model.Hospital;
import model.Patient;

import java.util.ArrayList;
import java.util.List;

public class DateBase {
    private List<Department> departments = new ArrayList<>();
    private List<Doctor> doctors = new ArrayList<>();
    private List<Hospital> hospitals = new ArrayList<>();
    private List<Patient> patients = new ArrayList<>();

    public DateBase() {
    }

    public DateBase(List<Department> departments, List<Doctor> doctors, List<Hospital> hospitals, List<Patient> patients) {
        this.departments = departments;
        this.doctors = doctors;
        this.hospitals = hospitals;
        this.patients = patients;


    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public List<Hospital> getHospitals() {
        return hospitals;
    }

    public void setHospitals(List<Hospital> hospitals) {
        this.hospitals = hospitals;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    @Override
    public String toString() {
        return "DateBase{" +
                "departments=" + departments +
                ", doctors=" + doctors +
                ", hospitals=" + hospitals +
                ", patients=" + patients +
                '}';
    }

}
