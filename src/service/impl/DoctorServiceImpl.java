package service.impl;

import dao.daoClasses.DoctorDaoImpl;
import model.Doctor;
import service.DoctorService;

import java.util.List;

public class DoctorServiceImpl implements DoctorService {
    DoctorDaoImpl doctorDaoImpl = new DoctorDaoImpl();
    @Override
    public String addDoctorToHospital(Long id, Doctor doctor) {
        return doctorDaoImpl.addDoctorToHospital(id,doctor);
    }

    @Override
    public Doctor findDoctorById(Long id) {
        return null;
    }

    @Override
    public String updateDoctor(Long id, Doctor doctor) {
        return null;
    }

    @Override
    public void deleteDoctorById(Long id) {

    }

    @Override
    public String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId) {
        return null;
    }

    @Override
    public List<Doctor> getAllDoctorsByHospitalId(Long id) {
        return null;
    }

    @Override
    public List<Doctor> getAllDoctorsByDepartmentId(Long id) {
        return null;
    }
}
