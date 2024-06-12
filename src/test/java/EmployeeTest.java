import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import model.Employee;
import service.EmployeeService;

public class EmployeeTest {

	private EmployeeService employeeService;
	private List<Employee> mockEmployeeDatabase;

	@BeforeEach
	public void setUp() {
		mockEmployeeDatabase = Mockito.mock(List.class); // Use List interface for mocking
		employeeService = new EmployeeService(mockEmployeeDatabase);
	}

	@Test
	@DisplayName("ajouter employee")
	public void testAddEmployee() {
		when(mockEmployeeDatabase.add(any(Employee.class))).thenReturn(true); // Mock the add method

		Iterator<Employee> mockIterator = mock(Iterator.class);
		when(mockEmployeeDatabase.iterator()).thenReturn(mockIterator);
		when(mockIterator.hasNext()).thenReturn(false);

		Employee employee = employeeService.addEmployee("John", "Doe", "john.doe@example.com", "Developer",
				LocalDate.now());

		verify(mockEmployeeDatabase, times(1)).add(any(Employee.class));
		assertEquals("John", employee.getFirstname());
	}

	@Test
	@DisplayName("suppression employee")
	public void testDeleteEmployee() {

		 Employee mockEmployee = mock(Employee.class);
		    when(mockEmployee.getFirstname()).thenReturn("John");
		    when(mockEmployee.getLastname()).thenReturn("Doe");
		    when(mockEmployee.getEmail()).thenReturn("john.doe@example.com");
		    when(mockEmployee.getOccupation()).thenReturn("Developer");
		    when(mockEmployee.getHiringDate()).thenReturn(LocalDate.now());

		  
		    Iterator<Employee> mockIterator = mock(Iterator.class);
		    when(mockIterator.hasNext()).thenReturn(true, false); 
		    when(mockIterator.next()).thenReturn(mockEmployee);
		    when(mockEmployeeDatabase.iterator()).thenReturn(mockIterator);

		  
		    employeeService.removeEmployee("john.doe@example.com");

		    
		    verify(mockEmployeeDatabase, times(1)).remove(mockEmployee);

		   
		    Iterator<Employee> updatedMockIterator = mock(Iterator.class);
		    when(updatedMockIterator.hasNext()).thenReturn(false); 
		    when(mockEmployeeDatabase.iterator()).thenReturn(updatedMockIterator);

	}
	
	

}
