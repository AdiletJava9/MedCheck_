package service;

import model.Department;

import java.util.List;

public interface DepartmentService {
    public String addDepartmentToHospital(Long id, Department department);
    public List<Department> getAllDepartmentByHospital(Long id);
    public Department findDepartmentByName(String name);
    public void deleteDepartmentById(Long id);
    public String updateDepartmentById(Long id, Department department);
}
