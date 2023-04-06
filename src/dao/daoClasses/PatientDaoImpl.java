package dao.daoClasses;

import dao.PatientDao;
import db.DateBase;
import model.Hospital;
import model.Patient;

import java.util.List;
import java.util.Map;
import java.util.Objects;

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
        return null;
    }

    @Override
    public String updatePatientById(Long id, Patient patientsNewInfo) {
        return null;
    }

    @Override
    public void removePatientById(Long id) {

    }

    @Override
    public Patient getPatientById(Long id) {
        return null;
    }

    @Override
    public Map<Integer, Patient> getPatientByAge() {
        return null;
    }

    @Override
    public List<Patient> sortPatientsByAge(String ascOrDesc) {
        return null;
    }
}
