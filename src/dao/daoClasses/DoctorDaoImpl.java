package dao.daoClasses;

import dao.DoctorDao;
import db.DateBase;
import exceptions.Ex;
import model.Department;
import model.Doctor;
import model.Hospital;

import javax.print.Doc;
import java.util.List;

public class DoctorDaoImpl implements DoctorDao {
    DateBase dataBase = new DateBase();

    public DoctorDaoImpl(DateBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public String addDoctorToHospital(Long id, Doctor doctor) {
        try {
            boolean loop = false;
            for (Hospital hospital : dataBase.getHospitals()) {
                if (hospital.getId().equals(id)) {
                    hospital.getDoctors().add(doctor);
                    return "Added!";
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
        return null;
    }

    @Override
    public Doctor findDoctorById(Long id) {
        try {
            boolean looping = true;
            for (Hospital hospital : dataBase.getHospitals()) {
                for (Doctor doctor : hospital.getDoctors()) {
                    if (id.equals(doctor.getId())) {
                        System.out.println(doctor);
                    } else {
                        looping = false;
                    }
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
            for (Hospital hospital : dataBase.getHospitals()) {
                for (Doctor doctor1 : hospital.getDoctors()) {
                    if (doctor1.getId().equals(id)) {
                        doctor1 = doctor;
                        System.out.println(doctor1);
                    } else {
                        trueFalse = false;
                    }
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
            for (Hospital hospital : dataBase.getHospitals()) {
                for (Doctor doctor : hospital.getDoctors()) {
                    if (doctor.getId().equals(id)) {
                        hospital.getDoctors().remove(doctor);
                    } else {
                        loopForDelete = true;
                    }
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
            for (Hospital hospital : dataBase.getHospitals()) {
                for (Department department : hospital.getDepartments()) {
                    for (Doctor doctor : hospital.getDoctors()) {
                        for (Long doctorId : doctorsId) {
                            if (doctorId.equals(doctor.getId()) && department.getId().equals(departmentId)) {
                                department.getDoctors().add(doctor);
                                System.out.println(hospital.getDepartments());
                            } else {
                                loop = true;
                            }
                        }
                    }
                }
            }
            if (loop) {
                throw new Ex("Id's do not match");
            }
        } catch (Ex e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Doctor> getAllDoctorsByHospitalId(Long id) {
        try {
            boolean loopToGetAllDoctorsByHospital = false;
            for (Hospital hospital : dataBase.getHospitals()) {
                for (Doctor doctor : hospital.getDoctors()) {
                    if (hospital.getId().equals(id)) {
                        System.out.println(doctor);
                    } else {
                        loopToGetAllDoctorsByHospital = true;
                    }
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
            for (Hospital hospital : dataBase.getHospitals()) {
                for (Department department : hospital.getDepartments()) {
                    for (Doctor doctor : department.getDoctors()) {
                        if (department.getId().equals(id)) {
                            System.out.println(doctor);
                        } else {
                            getAllDoctorsByDepartment = true;
                        }
                    }
                }
            }
            if (getAllDoctorsByDepartment) {
                throw new Ex("Id not found in Department");
            }
        } catch (Ex e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
