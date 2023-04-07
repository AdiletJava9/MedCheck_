package dao.daoClasses;

import dao.HospitalDao;
import db.DateBase;
import exceptions.Ex;
import model.Department;
import model.Doctor;
import model.Hospital;
import model.Patient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HospitalDaoImpl implements HospitalDao {
    DateBase dateBase = new DateBase();

    public HospitalDaoImpl(DateBase dateBase) {
        this.dateBase = dateBase;
    }

    @Override
    public String addHospital(Hospital hospital) {
        dateBase.getHospitals().add(hospital);
        return "Hospital added successfully!";
    }

    @Override
    public Hospital findHospitalById(Long id) {
        try{
           boolean findHospitalById = true;
            for (Hospital hospital : dateBase.getHospitals()) {
                if (id.equals(hospital.getId())) {
                    System.out.println(hospital);
                }else{
                    findHospitalById = false;
                }
            }
            if(!findHospitalById){
                throw  new Ex("Hospital id is not found!");
            }
        }catch(Ex ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Hospital> getAllHospital() {
        return dateBase.getHospitals();
    }

    @Override
    public List<Patient> getAllPatientFromHospital(Long id) {
        try {
            boolean getAllPatientFromHospital = false;
            for (Hospital hospital : dateBase.getHospitals()) {
                    if (hospital.getId().equals(id)) {
                        System.out.println("***"+hospital.getPatients()+"***");
                    } else {
                        getAllPatientFromHospital = true;
                    }
            }
            if (getAllPatientFromHospital) {
                throw new Ex("Patient is not found!");
            }
        }catch(Ex ex) {
            System.out.println(ex.getMessage());
        }
        return null;

    }

    @Override
    public String deleteHospitalById(Long id) {
        try {
            boolean deleteHospital = true;
            for (Hospital hospital : dateBase.getHospitals()) {
                if (hospital.getId().equals(id)) {
                    dateBase.getHospitals().remove(hospital);
                    System.out.println("Hospital deleted successfully!");
                    break;
                } else {
                    deleteHospital = false;
                }
            }
            if (deleteHospital) {
                throw new Ex("Id not found!");
            }

        } catch (Ex ex) {
            return ex.getMessage();
        }
        return "Hospital deleted successfully!";
    }

    @Override
    public Map<String, Hospital> getAllHospitalByAddress(String address) {

        Map<String,Hospital>hospitalMap = new HashMap<>();
        for (Hospital hospital: dateBase.getHospitals()) {

            if (address.equals(hospital.getAddress())){
                hospitalMap.put(hospital.getAddress(),hospital);
                System.out.println(hospitalMap);
            }
        }
        return null;
    }
}
