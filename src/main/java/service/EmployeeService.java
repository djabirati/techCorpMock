package service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Employee;

public class EmployeeService {

	private List<Employee> employees;
	private Employee employee;

	

	

	public EmployeeService(List<Employee> employees) {
		this.employees = employees;
	}

	public Employee addEmployee(String firstname, String lastname, String email, String occupation,
			LocalDate hiringDate) {
		if (IsExistingEmail(email)) {
			throw new IllegalArgumentException("L'email est déjà utilisé");

		}
		Employee employee = new Employee(firstname, lastname, email, occupation, hiringDate);
		employees.add(employee);
		return employee;
	}
	
	public void removeEmployee(String email) {
		Employee employeeToRemove = null;
		for (Employee employee : employees) {
			if (employee.getEmail().equals(email)) {
				employeeToRemove = employee;
				break;
			}
		}
		if (employeeToRemove != null) {
			employees.remove(employeeToRemove);
		} else {
			throw new IllegalArgumentException("L'email n'existe pas");
		}
		
		
	}


	private boolean IsExistingEmail(String email) {
		for (Employee employee : employees) {
			if (employee.getEmail().equals(email)) {
				return true;
			}
		}
		return false;
	}
	
	

}
