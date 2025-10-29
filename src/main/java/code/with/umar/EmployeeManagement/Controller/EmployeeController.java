package code.with.umar.EmployeeManagement.Controller;

import code.with.umar.EmployeeManagement.Entity.Employee;
import code.with.umar.EmployeeManagement.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // ✅ Create
    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.postEmployee(employee);
    }

    // ✅ Read All
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getEmployee();
    }

    // ✅ Read by ID  --> FIX for your fetch error
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    // ✅ Update by ID  --> FIX for your PUT error
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee) {
        Employee existing = employeeService.getEmployeeById(id);
        if (existing == null) {
            throw new RuntimeException("Employee not found with id " + id);
        }

        existing.setName(updatedEmployee.getName());
        existing.setEmail(updatedEmployee.getEmail());
        existing.setPhone(updatedEmployee.getPhone());
        existing.setDepartment(updatedEmployee.getDepartment());

        return employeeService.postEmployee(existing);
    }

    // ✅ Delete
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteById(id);
    }
}
