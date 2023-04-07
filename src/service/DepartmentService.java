package service;

import dao.DepartmentDao;
import dao.daoClasses.DepartmentDaoImpl;
import db.DateBase;
import model.Department;

import java.util.List;


public interface DepartmentService {

    String addDepartmentToHospital(Long id, Department department);

    List<Department> getAllDepartmentByHospital(Long id);
    Department findDepartmentByName(String name);
    void deleteDepartmentById(Long id);
    String updateDepartmentById(Long id, Department department);
}
