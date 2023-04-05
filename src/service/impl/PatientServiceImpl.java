package service.impl;

import dao.daoClasses.PatientDaoImpl;
import model.Patient;
import service.PatientService;

import java.util.List;
import java.util.Map;

public class PatientServiceImpl implements PatientService {
    PatientDaoImpl patientDao = new PatientDaoImpl();

    @Override
    public String addPatientToHospital(Long id, Patient patient) {
        return patientDao.addPatientToHospital(id, patient);
    }

    @Override
    public String addPatientsToHospital(Long id, List<Patient> patients) {
        return patientDao.addPatientsToHospital(id, patients);
    }

    @Override
    public String updatePatientById(Long id, Patient patientsNewInfo) {
        return patientDao.updatePatientById(id, patientsNewInfo);
    }

    @Override
    public void removePatientById(Long id) {
        patientDao.removePatientById(id);
    }

    @Override
    public Patient getPatientById(Long id) {
        return patientDao.getPatientById(id);
    }

    @Override
    public Map<Integer, Patient> getPatientByAge() {
        return patientDao.getPatientByAge();
    }

    @Override
    public List<Patient> sortPatientsByAge(String ascOrDesc) {
        return patientDao.sortPatientsByAge(ascOrDesc);
    }
}
