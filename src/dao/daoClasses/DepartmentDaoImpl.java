package dao.daoClasses;

import dao.DepartmentDao;
import db.DateBase;
import model.Department;

import java.util.List;

public class DepartmentDaoImpl implements DepartmentDao {
    DateBase dateBase = new DateBase();
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
