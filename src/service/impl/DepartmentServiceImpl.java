package service.impl;

import dao.DepartmentDao;
import db.DateBase;
import model.Department;
import model.Doctor;
import model.Hospital;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentDao {


    @Override
    public String addDepartmentToHospital(Long id, Department department) {
        return null;

    }
    @Override
    public List<Department> getAllDepartmentByHospital(Long id) {
        return null;
    }

    @Override
    public Department findDepartmentByName(String name) {
        return null;
    }

    @Override
    public void deleteDepartmentById(Long id) {

    }

    @Override
    public String updateDepartmentById(Long id, Department department) {
        return null;
    }
}


