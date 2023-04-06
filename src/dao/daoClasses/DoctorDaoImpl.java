package dao.daoClasses;

import dao.DoctorDao;
import db.DateBase;
import exceptions.Ex;
import model.Department;
import model.Doctor;
import model.Hospital;

import java.util.List;

public class DoctorDaoImpl implements DoctorDao {
    DateBase dataBase = new DateBase();

    @Override
    public String addDoctorToHospital(Long id, Doctor doctor) {
        try {
            boolean loop = false;
            for (Hospital h : dataBase.getHospitals()) {
                if (h.getId().equals(id)) {
                    h.getDoctors().add(doctor);
                } else {
                    loop = true;
                }
            }
            if (loop) {
                throw new Ex("Id not found!");
            }
        } catch (Ex e) {
            System.out.println(e.getMessage());
        }
        return dataBase.toString();
    }

    @Override
    public Doctor findDoctorById(Long id) {
        try {
            boolean looping = true;
            for (Doctor d : dataBase.getDoctors()) {
                if (id.equals(d.getId())) {
                    System.out.println(d);
                } else {
                    looping = false;
                }
            }
            if (looping) {
                throw new Ex("Id not found! ");
            }
        } catch (Ex e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String updateDoctor(Long id, Doctor doctor) {
        try {
            boolean trueFalse = true;
            for (Doctor d : dataBase.getDoctors()) {
                if (d.getId().equals(id)) {
                    d=doctor;
                    doctor = d;
                } else {
                    trueFalse = false;
                }
            }
            if (trueFalse) {
                throw new Ex("Id not found") {
                };
            }
        } catch (Ex e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void deleteDoctorById(Long id) {
        try {
            boolean loopForDelete = false;
            for (Doctor d : dataBase.getDoctors()) {
                if (d.getId().equals(id)) {
                    dataBase.getDoctors().remove(d);
                } else {
                    loopForDelete = true;
                }
            }
            if (loopForDelete) {
                throw new Ex("Id not found");
            }
        } catch (Ex e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId) {
        try {
            boolean loop = false;
            for (Doctor doctor : dataBase.getDoctors()) {
                for (Long idOfDoctor : doctorsId) {
                    for (Department department : dataBase.getDepartments()) {
                        if (doctor.getId().equals(idOfDoctor)) {
                            department.getDoctors().add(doctor);
                            System.out.println(dataBase.getDepartments());
                        } else {
                            loop = true;
                        }
                    }
                }
            }
            if (loop) {
throw new Ex("Id's do not match");
            }
        }catch (Ex e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Doctor> getAllDoctorsByHospitalId(Long id) {
        try {
            boolean loopToGetAllDoctorsByHospital = false;
            for (Hospital h : dataBase.getHospitals()) {
                if (h.getId().equals(id)) {
                    System.out.println(h.getDoctors());
                } else {
                    loopToGetAllDoctorsByHospital = true;
                }
            }
            if (loopToGetAllDoctorsByHospital) {
                throw new Ex("Hospital with same id not found");
            }
        } catch (Ex e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Doctor> getAllDoctorsByDepartmentId(Long id) {
        try {
            boolean getAllDoctorsByDepartment = false;
            for (Department d : dataBase.getDepartments()) {
                if (d.getId().equals(id)) {
                    System.out.println(d.getDoctors());
                } else {
                    getAllDoctorsByDepartment = true;
                }
            }
            if (getAllDoctorsByDepartment) {
                throw new Ex("There is no same id in Department");
            }
        } catch (Ex e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
