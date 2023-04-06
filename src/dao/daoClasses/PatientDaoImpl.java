package dao.daoClasses;

import dao.PatientDao;
import db.DateBase;
import model.Hospital;
import model.Patient;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

import java.util.Objects;

import java.util.Scanner;


public class PatientDaoImpl implements PatientDao {
    DateBase dateBase = new DateBase();

    @Override
    public String addPatientToHospital(Long id, Patient patient) {
        boolean loop = false;
        for (Hospital h : dateBase.getHospitals()) {
            if (Objects.equals(h.getId(), id)) {
                h.getPatients().add(patient);
                loop = false;
            } else {
                loop = true;
            }
        }
        if (loop) {
            return "Tabylgan jok !";
        }

        return "Added";
    }

    @Override
    public String addPatientsToHospital(Long id, List<Patient> patients) {
        boolean loop = false;
        for (Hospital h : dateBase.getHospitals()) {
            if (h.getId() == id) {
                h.setPatients(patients);
                loop = false;
            } else {
                loop = true;
            }
        }
        if (loop) {
            return "Tabylgan jok !";
        }
        return "Added";
    }

    @Override
    public String updatePatientById(Long id, Patient patientsNewInfo) {
        for (Patient p : dateBase.getPatients()) {
            if (id == p.getId()) {
                p.setFirstName(patientsNewInfo.getFirstName());
                p.setLastName(patientsNewInfo.getLastName());
                p.setAge(patientsNewInfo.getAge());
                p.setGender(patientsNewInfo.getGender());
            }
        }
        return "updated..";
    }

    @Override
    public void removePatientById(Long id) {
        for (Patient p : dateBase.getPatients()) {
            if (p.getId() == id) {
                dateBase.getPatients().remove(p);
                System.out.println("removed");
            }
        }

    }

    @Override
    public Patient getPatientById(Long id) {
        for (Patient p : dateBase.getPatients()) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    @Override
    public Map<Integer, Patient> getPatientByAge() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Age?");
        int age = scanner.nextInt();
        for (Patient p : dateBase.getPatients()) {
            if (p.getAge() == age) {
                System.out.println(p);
            }
        }

        return null;
    }

    @Override
    public List<Patient> sortPatientsByAge(String ascOrDesc) {
        if (ascOrDesc.equals("asc")) {
            return dateBase.getPatients().stream().sorted(Comparator.comparing(Patient::getAge)).toList();
        } else if (ascOrDesc.equals("desc")) {
            return dateBase.getPatients().stream().sorted(Comparator.comparing(Patient::getAge).reversed()).toList();
        }
        return null;
    }
}
