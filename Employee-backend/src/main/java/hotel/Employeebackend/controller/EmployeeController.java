package hotel.Employeebackend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hotel.Employeebackend.exception.ResourceNotFoundException;
import hotel.Employeebackend.model.Employee;
import hotel.Employeebackend.repository.EmployeeRespository;

@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {
	@Autowired
	private EmployeeRespository employeeRespository;
	
	//get all Customers
	@GetMapping("/employees")
	public List<Employee> getAllCustomer()
	{
		return employeeRespository.findAll();
	}
	
	@PostMapping("/employees")
	public Employee createCustomer(@RequestBody Employee customer)
	{
		return employeeRespository.save(customer);
	}
	
	@GetMapping("employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id){
		Employee employee=employeeRespository.findById(id)
				.orElseThrow(() ->new ResourceNotFoundException("Employee not exist with id:"+id));
		return ResponseEntity.ok(employee);
	}
	
	
	
	
	

}
