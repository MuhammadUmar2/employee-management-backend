package code.with.umar.EmployeeManagement.Services;

import code.with.umar.EmployeeManagement.Entity.Employee;
import code.with.umar.EmployeeManagement.Repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;


    public Employee postEmployee(Employee employee){
            return employeeRepository.save(employee);
    }

    public List<Employee> getEmployee(){
        return employeeRepository.findAll();
    }

    public void deleteById(Long id){
        if (!employeeRepository.existsById(id)){
            throw new EntityNotFoundException("Employee with id " +id+ "Not found");
        }
        employeeRepository.deleteById(id);
    }
    public Employee getEmployeeById(Long id){
        return employeeRepository.findById(id).orElse(null);
    }
}
