package service.impl;

import dao.daoClasses.DoctorDaoImpl;
import db.DateBase;
import model.Doctor;
import service.DoctorService;

import java.util.List;

public class DoctorServiceImpl implements DoctorService {
    DateBase dateBase = new DateBase();

    public DoctorServiceImpl(DateBase dateBase) {
        this.dateBase = dateBase;
    }

    DoctorDaoImpl doctorDaoImpl = new DoctorDaoImpl(dateBase);
    @Override
    public String addDoctorToHospital(Long id, Doctor doctor) {
        return doctorDaoImpl.addDoctorToHospital(id,doctor);
    }

    @Override
    public Doctor findDoctorById(Long id) {
        return doctorDaoImpl.findDoctorById(id);
    }

    @Override
    public String updateDoctor(Long id, Doctor doctor) {
        return doctorDaoImpl.updateDoctor(id,doctor);
    }

    @Override
    public void deleteDoctorById(Long id) {
        doctorDaoImpl.deleteDoctorById(id);
    }

    @Override
    public String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId) {
        return doctorDaoImpl.assignDoctorToDepartment(departmentId,doctorsId);
    }

    @Override
    public List<Doctor> getAllDoctorsByHospitalId(Long id) {
        return doctorDaoImpl.getAllDoctorsByHospitalId(id);
    }

    @Override
    public List<Doctor> getAllDoctorsByDepartmentId(Long id) {
        return doctorDaoImpl.getAllDoctorsByDepartmentId(id);
    }
}
