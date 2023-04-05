package dao.daoClasses;

import dao.DoctorDao;
import db.DateBase;
import model.Doctor;
import model.Hospital;

import java.util.List;

public class DoctorDaoImpl implements DoctorDao {
    DateBase dataBase = new DateBase();
    @Override
    public String addDoctorToHospital(Long id, Doctor doctor) {
        for (Hospital h:dataBase.getHospitals()) {
            if (h.getId().equals(id)){
                System.out.println("adilet baike");
            }
        }
        return null;
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
