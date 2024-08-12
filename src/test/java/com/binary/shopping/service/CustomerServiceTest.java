package com.binary.shopping.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.binary.shopping.entity.Customer;
import com.binary.shopping.entity.Product;
import com.binary.shopping.repository.CustomerRepository;
import com.binary.shopping.service.impl.CustomerServiceImpl;


//Integrates Mockito into JUnit 5 tests, simplifying the creation and management of mock objects.
@ExtendWith(MockitoExtension.class)
@DisplayName(" Customers Service test cases")  //specify a custom name for your test classes and test methods
public class CustomerServiceTest {
	
	// inject mocks objects with the constructor parameters, fields, or setter methods of the class.
	 @InjectMocks
	    private CustomerServiceImpl customerService;

	 //@Mock annotation tells Mockito to create a mock instance of the class or interface you specify. 
	 //This mock object will imitate the behavior of the real object but without executing its actual methods 
	    @Mock
	    private CustomerRepository customerRepository;

	   
	    
	    
	    @Test  // indicate that a particular method is a test method
	    @DisplayName("Get all Customers test case success")  //specify a custom name for your test classes and test methods
	    public void CustomerService_findAllCustomer_success(){

	    	Customer customer1 = new Customer();
			customer1.setCustomerId(1);
			customer1.setFirstName("Ana");
			customer1.setLastName("Dalvi");
			customer1.setProduct(Stream.of( new Product(1, "TV", "Smart TV",customer1)).collect(Collectors.toList()));
			Customer customer2 = new Customer();
			customer2.setCustomerId(2);
			customer2.setFirstName("Megha");
			customer2.setLastName("Dev");
			customer2.setProduct(Stream.of( new Product(1, "Phone", "Smart Phone", customer2)).collect(Collectors.toList()));
	        List<Customer> Customers =  new ArrayList<>();
	        Customers.add(customer1);
	        Customers.add(customer2);

	        Mockito.when(customerRepository.findAll()).thenReturn(Customers);

	        List<Customer> result = customerService.findAllCustomer();

	        Assertions.assertEquals(Customers.size(), result.size());


	    }


}