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

//import static jdk.internal.org.jline.utils.Colors.h;

public class HospitalDaoImpl implements HospitalDao {
    DateBase dateBase = new DateBase();

    @Override
    public String addHospital(Hospital hospital) {
        dateBase.getHospitals().add(hospital);
        System.out.println("Hospital added successfully ! ");
        return "Hospital added successfully!";
    }

    @Override
    public Hospital findHospitalById(Long id) {
        try{
           boolean findHospitalById = true;
            for (Hospital h : dateBase.getHospitals()) {
                if (id.equals(h.getId())) {
                    System.out.println(h);
                }else{
                    findHospitalById = false;
                }
            }
            if(findHospitalById){
                throw  new Ex("Hospital id is not found!");
            }
        }catch(Ex ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Hospital> getAllHospital() {
        System.out.println(dateBase.getHospitals());
        return dateBase.getHospitals();
    }

    @Override
    public List<Patient>

    getAllPatientFromHospital(Long id) {
        try {
            boolean getAllPatientFromHospital = false;
            for (Hospital h : dateBase.getHospitals()) {
                if (h.getId().equals(id)) {
                    System.out.println("Patients in Hospital " + h.getHospitalName() + h.getPatients());
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
            for (Hospital h : dateBase.getHospitals()) {
                if (h.getId().equals(id)) {
                    dateBase.getHospitals().remove(h);
                    System.out.println("Hospital deleted successfully!");
                    return null;
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
        for (Hospital h: dateBase.getHospitals()) {

            if (address.equals(h.getAddress())){
                hospitalMap.put(h.getAddress(),h);
                System.out.println(hospitalMap);
                return hospitalMap ;
            }
        }
        return null;
    }
}
