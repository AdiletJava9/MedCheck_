package dao.daoClasses;

import dao.DepartmentDao;
import db.DateBase;
import exceptions.Ex;
import model.Department;
import model.Hospital;

import java.util.*;

public class DepartmentDaoImpl implements DepartmentDao {
    DateBase dateBase = new DateBase();

    @Override
    public String addDepartmentToHospital(Long id, Department department) {
        try{
        boolean Loop = false;
        for (Hospital hos : dateBase.getHospitals()) {
            if (Objects.equals(hos.getId(), id)) {
                hos.getDepartments().add(department);
            } else {
                Loop = true;
            }
        }
            if (Loop) {
                throw new Ex("Not found");
            }
        }catch (Ex e){
            System.out.println(e.getMessage());
        }
        return "successfully added";
    }

    @Override
    public List<Department> getAllDepartmentByHospital(Long id) {
          try {
              boolean b = true;
              for (Hospital hospital:dateBase.getHospitals()) {
                      if (hospital.getId().equals(id)){
                          System.out.println(hospital.getDepartments());
                      }else {
                          b = false;
                      }
                  }
              if (b){
                  throw new Ex("Id not found");
              }
          }catch (Ex e){
              System.out.println(e.getMessage());
          }
          return null;
    }


    @Override
    public Department findDepartmentByName(String name) {
        try {
            boolean loop = false;
            for (Department department : dateBase.getDepartments()) {
                if (department.getDepartmentName().equals(name)) {
                    System.out.println(department);
                }
                else{
                    loop = true;
                }
            }
            if (loop){
             throw new Ex("Name not found");
            }
        }catch (Ex e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void deleteDepartmentById(Long id) {
        try{
            boolean b = false;
            for (Department department : dateBase.getDepartments()) {
                if (department.getId().equals(id)) {
                    System.out.println(department);
                }else {
                    b=true;
                }
            }
            if (b){
                throw new Ex("Id not found");
            }
        }catch (Ex e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String updateDepartmentById(Long id, Department department) {
        try{
            boolean b = true;
            for (Department dept : dateBase.getDepartments()) {
                if (dept.getId().equals(id)) {
                    dept.setDepartmentName(department.getDepartmentName());
                }else {
                    b = false;
                }
            }
            if (b){
                throw new Ex("Id not found");
            }
                return "Department with id" + id + "update successfully";

        }catch (Ex e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}