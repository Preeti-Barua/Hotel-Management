package hotel.Employeebackend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hotel.Employeebackend.model.Employee;


@Repository
public interface EmployeeRespository extends JpaRepository<Employee,Integer>{

}
