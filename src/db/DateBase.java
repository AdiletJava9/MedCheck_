package db;

import model.Department;
import model.Doctor;
import model.Hospital;
import model.Patient;

import java.util.ArrayList;
import java.util.List;

public class DateBase {
    private List<Hospital> hospitals = new ArrayList<>();
    public DateBase() {
    }

    public DateBase(List<Hospital> hospitals) {
        this.hospitals = hospitals;


    }

    public List<Hospital> getHospitals() {
        return hospitals;
    }

    public void setHospitals(List<Hospital> hospitals) {
        this.hospitals = hospitals;
    }

    @Override
    public String toString() {
        return "DateBase{" +
                "hospitals=" + hospitals +
                '}';
    }
}
