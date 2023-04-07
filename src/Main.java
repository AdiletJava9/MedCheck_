import dao.daoClasses.DepartmentDaoImpl;
import dao.daoClasses.HospitalDaoImpl;
import db.DateBase;
import enums.Gender;
import exceptions.Ex;
import model.Department;
import model.Doctor;
import model.Hospital;
import model.Patient;
import service.impl.DepartmentServiceImpl;
import service.impl.DoctorServiceImpl;
import service.impl.HospitalServiceImpl;
import service.impl.PatientServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DateBase dateBase = new DateBase();
        DepartmentServiceImpl departmentServiceImpl = new DepartmentServiceImpl(dateBase);
        DoctorServiceImpl doctorServiceImpl = new DoctorServiceImpl(dateBase);
        HospitalServiceImpl hospitalServiceImpl = new HospitalServiceImpl(dateBase);
        PatientServiceImpl patientServiceImpl = new PatientServiceImpl(dateBase);
//------------------------------------------------------------------------------------------------------------
        Patient patient1 = new Patient(1L, "adi", "is", 22, Gender.MALE);
        Patient patient2 = new Patient(2L, "adi", "is", 22, Gender.MALE);
        Patient patient3 = new Patient(3L, "adi", "is", 22, Gender.MALE);
        List<Patient> patients = new ArrayList<>(Arrays.asList(patient1, patient2, patient3));
//------------------------------------------------------------------------------------------------------------
        Doctor doctor = new Doctor(11L, "jk", "kll", Gender.MALE, 3);
        Doctor doctor1 = new Doctor(22L, "jk", "kll", Gender.MALE, 2);
        List<Doctor> doctors = new ArrayList<>(Arrays.asList(doctor1, doctor));
//------------------------------------------------------------------------------------------------------------
        Department department = new Department(33L, "hjlk", doctors);
        Department department1 = new Department(44L, "hjlk", doctors);
        List<Department> departments = new ArrayList<>(Arrays.asList(department1, department));
//------------------------------------------------------------------------------------------------------------
        Hospital hospital = new Hospital(212L, "№1 Gorodskaia Bolnica", "Ahunbaeva", null, null, null);
        Hospital hospital1 = new Hospital(339L, "Erbol Bolnicasy", "Isaeva", null, null, null);
        Scanner scanner = new Scanner(System.in);
//------------------------------------------------------------------------------------------------------------
        try {
            while (true) {
                System.out.println("""
                        1 - addHospitalToDataBase | 2 - getAllHospitals | 3 - findHospitalById
                        4 - addPatientToHospital | 5 - addListPatientsToHospital | 6 - removeHospitalById
                        7 - getHospitalByAddress | 8 - getAllDoctorsFromHospital | 9 - updatePatientById
                        10 - removePatientById | 11 - getPatientById | 12 - getPatientByAge
                        13 - sortPatientByAge | 14 - addDoctorToHospital | 15 - findDoctorById
                        16 - updateDoctorById | 17 - deleteDoctorById | 18 - addDepartmentToHospital
                        19 - assignDoctorToDepartment | 20 - getAllDepartmentsByHospital'sId
                        21 - findDepartmentByName | 22 - removeDepartmentById | 23 - updateDepartmentById""");
                int a = scanner.nextInt();
                switch (a) {
//------------------------------------------------------------------------------------------------------------
                    case 1:
                        System.out.println(hospitalServiceImpl.addHospital(hospital));
                        break;
//------------------------------------------------------------------------------------------------------------
                    case 2:
                        System.out.println(hospitalServiceImpl.getAllHospital());
                        break;
//------------------------------------------------------------------------------------------------------------
                    case 3:
                        System.out.print("Enter id of hospital: ");
                        Long enterId = new Scanner(System.in).nextLong();
                        System.out.println(hospitalServiceImpl.findHospitalById(enterId));
                        break;
//------------------------------------------------------------------------------------------------------------
                    case 4:
                        System.out.println(patientServiceImpl.addPatientToHospital(212L, patient1));
                        break;
//------------------------------------------------------------------------------------------------------------
                    case 5:
                        System.out.println(patientServiceImpl.addPatientsToHospital(212L, patients));
                        break;
//------------------------------------------------------------------------------------------------------------
                    case 6:
                        System.out.print("Enter id of hospital that you wanna remove: ");
                        Long enterIdOfHospital = new Scanner(System.in).nextLong();
                        System.out.println(hospitalServiceImpl.deleteHospitalById(enterIdOfHospital));
                        break;
//------------------------------------------------------------------------------------------------------------
                    case 7:
                        System.out.print("Enter Address: ");
                        String enteringAddress = new Scanner(System.in).next();
                        System.out.println(hospitalServiceImpl.getAllHospitalByAddress(enteringAddress));
                        break;
//------------------------------------------------------------------------------------------------------------
                    case 8:
                        System.out.print("Hospital's id to get from it Doctors");
                        Long doctorsByHospitalId = new Scanner(System.in).nextLong();
                        System.out.println(doctorServiceImpl.getAllDoctorsByHospitalId(doctorsByHospitalId));
//------------------------------------------------------------------------------------------------------------
                    case 9:
                        Long enterIdPatient = new Scanner(System.in).nextLong();
                        Patient patient = new Patient(923L, "Erbol", "Ashirali uulu", 19, Gender.MALE);
                        System.out.println(patientServiceImpl.updatePatientById(enterIdPatient, patient));
                        break;
//------------------------------------------------------------------------------------------------------------
                    case 10:
                        Long enterPatientOfId = new Scanner(System.in).nextLong();
                        patientServiceImpl.removePatientById(enterPatientOfId);
                        break;
//------------------------------------------------------------------------------------------------------------
                    case 11:
                        Long getPatientById = new Scanner(System.in).nextLong();
                        System.out.println(patientServiceImpl.getPatientById(getPatientById));
                        break;
//------------------------------------------------------------------------------------------------------------
                    case 12:
                        System.out.println(patientServiceImpl.getPatientByAge());
                        break;
//------------------------------------------------------------------------------------------------------------
                    case 13:
                        System.out.println("asc|desc");
                        String ascendingDescending = new Scanner(System.in).next();
                        System.out.println(patientServiceImpl.sortPatientsByAge(ascendingDescending));
                        break;
//------------------------------------------------------------------------------------------------------------
                    case 14:
                        Long doctorToHospital = new Scanner(System.in).nextLong();
                        System.out.println(doctorServiceImpl.addDoctorToHospital(doctorToHospital, doctor1));
                        break;
//------------------------------------------------------------------------------------------------------------
                    case 15:
                        Long findDoctorById = new Scanner(System.in).nextLong();
                        System.out.println(doctorServiceImpl.findDoctorById(findDoctorById));
                        break;
//------------------------------------------------------------------------------------------------------------
                    case 16:
                        Long updateDoctorById = new Scanner(System.in).nextLong();
                        System.out.println(doctorServiceImpl.updateDoctor(updateDoctorById, doctor));
                        break;
//------------------------------------------------------------------------------------------------------------
                    case 17:
                        Long removeDoctorById = new Scanner(System.in).nextLong();
                        doctorServiceImpl.deleteDoctorById(removeDoctorById);
                        break;
//------------------------------------------------------------------------------------------------------------
                    case 18:
                        Long idOfHospital = new Scanner(System.in).nextLong();
                        System.out.println(departmentServiceImpl.addDepartmentToHospital(idOfHospital, department));
                        break;
//------------------------------------------------------------------------------------------------------------
                    case 19:
                        List<Long> doctorsId = new ArrayList<>();
                        doctorsId.add(doctor.getId());
                        doctorsId.add(doctor1.getId());
                        System.out.print("Enter here department's id: ");
                        Long departmentsId = new Scanner(System.in).nextLong();
                        System.out.println(doctorServiceImpl.assignDoctorToDepartment(departmentsId, doctorsId));
                        break;
//------------------------------------------------------------------------------------------------------------
                    case 20:
                        System.out.print("Enter the id of the hospital");
                        Long hospitalsId = new Scanner(System.in).nextLong();
                        System.out.println(departmentServiceImpl.getAllDepartmentByHospital(hospitalsId));
                        break;
//------------------------------------------------------------------------------------------------------------
                    case 21:
                        System.out.print("Enter the name of the department");
                        String nameOfDepartment = new Scanner(System.in).next();
                        System.out.println(departmentServiceImpl.findDepartmentByName(nameOfDepartment));
                        break;
//------------------------------------------------------------------------------------------------------------
                    case 22:
                        System.out.print("Department's id to delete: ");
                        Long departmentsIdToRemove = new Scanner(System.in).nextLong();
                        departmentServiceImpl.deleteDepartmentById(departmentsIdToRemove);
                        break;
//------------------------------------------------------------------------------------------------------------
                    case 23:
                        Long idToUpdateDepartment = new Scanner(System.in).nextLong();
                        System.out.println(departmentServiceImpl.updateDepartmentById(idToUpdateDepartment, department1));
                        break;
                }
                if (a > 23) {
                    throw new Ex("Youhave only 23 functions");
                }
            }

        } catch (Ex e) {
            System.out.println(e.getMessage());
        }
    }
}