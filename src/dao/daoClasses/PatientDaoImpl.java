package dao.daoClasses;

import dao.PatientDao;
import db.DateBase;
import exceptions.Ex;
import model.Hospital;
import model.Patient;

import java.util.*;


public class PatientDaoImpl implements PatientDao {
    DateBase dateBase;

    public PatientDaoImpl(DateBase dateBase) {
        this.dateBase = dateBase;
    }

    @Override
    public String addPatientToHospital(Long id, Patient patient) {
        try {
            boolean loop = false;
            for (Hospital hospital : dateBase.getHospitals()) {
                if (hospital.getId().equals(id)) {
                    hospital.getPatients().add(patient);
                    return "***" + patient + "***";
                } else {
                    loop = true;
                }
            }
            if (loop) {
                throw new Ex("Id not found!");
            }
        }catch (Ex e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String addPatientsToHospital(Long id, List<Patient> patients) {
        try {
            boolean loop = false;
            for (Hospital hospital : dateBase.getHospitals()) {
                if (hospital.getId().equals(id)) {
                    hospital.setPatients(patients);
                    loop = false;
                } else {
                    loop = true;
                }
            }
            if (loop) {
                throw new Ex("Id not found of patients are empty!");
            }
        }catch (Ex e){
            System.out.println(e.getMessage());
        }
        return "Added";
    }

    @Override
    public String updatePatientById(Long id, Patient patientsNewInfo) {
        try {
            boolean bool = false;
            for (Hospital hospital : dateBase.getHospitals()) {
                for (Patient patient : hospital.getPatients()) {
                    if (patient.getId().equals(id)) {
                        patient = patientsNewInfo;
                        return "*** " + patient;
                    }else{
                        bool = true;
                    }
                }
            }
            if (bool){
                throw new Ex("Id not found!");
            }
        }catch (Ex e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void removePatientById(Long id) {
        try {
            boolean b = false;
            for (Hospital hospital : dateBase.getHospitals()) {
                for (Patient patient : hospital.getPatients()) {
                    if (patient.getId().equals(id)) {
                        System.out.println("*** " + patient);
                        hospital.getPatients().remove(patient);
                    }
                    else {
                        b=true;
                    }
                }
            }
            if (b){
                throw new Ex("Id not found");
            }
        }catch (Ex e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Patient getPatientById(Long id) {
        try {
            boolean loop = true;
            for (Hospital hospital : dateBase.getHospitals()) {
                for (Patient patient : hospital.getPatients()) {
                    if (patient.getId().equals(id)) {
                        return patient;
                    }
                    else{
                        loop = false;
                    }
                }
            }
            if (loop){
                throw new Ex("Id not found!");
            }
        }catch (Ex e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Map<Integer, Patient> getPatientByAge() {
        try {
            boolean bool = false;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Age?");
            int age = scanner.nextInt();
            for (Hospital hospital : dateBase.getHospitals()) {
                for (Patient patient : hospital.getPatients()) {
                    if (patient.getAge() == age) {
                        System.out.println(patient);
                        bool = true;
                    }
                }
            }
            if (!bool){
                throw new Ex("Age not found of something went wrong");
            }
        }catch (Ex e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Patient> sortPatientsByAge(String ascOrDesc) {
        try {
            List<Patient> patients = new ArrayList<>();

            for (Hospital hospital : dateBase.getHospitals()) {
                patients.addAll(hospital.getPatients());
            }
            Comparator<Patient> comparator = Comparator.comparing(Patient::getAge);
            if (ascOrDesc.equals("asc")) {
                patients.sort(comparator);
            } else if (ascOrDesc.equals("desc")) {
                patients.sort(comparator.reversed());
            } else {
                throw new Ex();
            }

            return patients;
        } catch (Ex e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}