package service.impl;

import dao.DepartmentDao;
import dao.daoClasses.DepartmentDaoImpl;
import model.Department;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentDao {

DepartmentDaoImpl departmentDaoImpl =  new DepartmentDaoImpl();
    @Override
    public String addDepartmentToHospital(Long id, Department department) {
        return departmentDaoImpl.addDepartmentToHospital(id,department);

    }
    @Override
    public List<Department> getAllDepartmentByHospital(Long id) {
        return departmentDaoImpl.getAllDepartmentByHospital(id);
    }

    @Override
    public Department findDepartmentByName(String name) {
        return departmentDaoImpl.findDepartmentByName(name);
    }

    @Override
    public void deleteDepartmentById(Long id) {
departmentDaoImpl.deleteDepartmentById(id);
    }

    @Override
    public String updateDepartmentById(Long id, Department department) {
        return departmentDaoImpl.updateDepartmentById(id,department);
    }
}


