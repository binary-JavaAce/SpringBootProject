package com.binary.shopping.controller;

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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.binary.shopping.entity.Customer;
import com.binary.shopping.entity.Product;
import com.binary.shopping.service.impl.CustomerServiceImpl;


//Integrates Mockito into JUnit 5 tests, simplifying the creation and management of mock objects.
@ExtendWith(MockitoExtension.class)
@DisplayName(" Shopping Controller test cases")  //specify a custom name for your test classes and test methods
public class ShoppingControllerTest {

	
	@InjectMocks    // inject mocks objects with the constructor parameters, fields, or setter methods of the class.
	private ShoppingController shoppingController;
	 //@Mock annotation tells Mockito to create a mock instance of the class or interface you specify. 
	 //This mock object will imitate the behavior of the real object but without executing its actual methods 
	@Mock
	private CustomerServiceImpl customerService;


	@Test  // indicate that a particular method is a test method
	@DisplayName("Retrieving All Customers Test")  //specify a custom name for your test classes and test methods
	public void customerController_getCustomers_success(){
		
		List<Customer> customers = new ArrayList<Customer>();
		Customer customer = new Customer();
		customer.setCustomerId(1);
		customer.setFirstName("Ana");
		customer.setLastName("Dalvi");
		customer.setProduct(Stream.of( new Product(1, "TV", "Smart TV", customer)).collect(Collectors.toList()));
		customers.add(customer);

	
		Mockito.when(customerService.findAllCustomer()).thenReturn(customers);
		ResponseEntity<List<Customer>> result = shoppingController.getCustomers();

		Assertions.assertEquals(1,result.getBody().size());
		Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());

		}


		@Test
		@DisplayName("Get Customer by ID success test case")
		public void shoppingController_getCustomerById_success(){

			Customer customer = new Customer();
			customer.setCustomerId(1);

			int expectedCustomerID = 1;

			Mockito.when(customerService.findCustomerById(expectedCustomerID)).thenReturn(customer);

			ResponseEntity<Customer> result = shoppingController.getCustomerById(expectedCustomerID);

			Assertions.assertEquals(expectedCustomerID, result.getBody().getCustomerId());
			Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());

		}


		@Test
		@DisplayName("Create Customer success test case")
		public void shoppingController_saveCustomer_success(){
			
			Customer customer = new Customer();
			customer.setCustomerId(2);
			customer.setFirstName("Anita");
			customer.setLastName("Dev");
			customer.setProduct(Stream.of( new Product(2, "Phone", "Smart Phone", customer)).collect(Collectors.toList()));
			
			Mockito.when(customerService.saveCustomer(Mockito.any())).thenReturn(customer);

			ResponseEntity<Customer> result = shoppingController.saveCustomer(customer);


			Assertions.assertEquals(customer.getCustomerId(), result.getBody().getCustomerId());
			Assertions.assertNotNull(result.getBody().getCustomerId());
			Assertions.assertEquals(HttpStatus.CREATED, result.getStatusCode());

		}


		@Test
		@DisplayName("Shopping controller update Customer success test case")
		public void shoppingController_updateCustomer_success(){

			Customer customer = new Customer();
			customer.setCustomerId(2);
			customer.setFirstName("Anita");
			customer.setLastName("Dev");

			int CustomerIdThatNeedToBeUpdated = 2;

			Customer updatedCustomer = new Customer();
			updatedCustomer.setCustomerId(CustomerIdThatNeedToBeUpdated);
			updatedCustomer.setFirstName(customer.getFirstName());
			updatedCustomer.setLastName(customer.getLastName());

			Mockito.when(customerService.updateCustomer(CustomerIdThatNeedToBeUpdated, customer)).thenReturn(updatedCustomer);
			ResponseEntity<Customer> result = shoppingController.updateCustomer(CustomerIdThatNeedToBeUpdated, customer);

			Assertions.assertEquals(updatedCustomer.getFirstName(), result.getBody().getFirstName());
			Assertions.assertEquals(HttpStatus.ACCEPTED, result.getStatusCode());
			Assertions.assertEquals(CustomerIdThatNeedToBeUpdated, result.getBody().getCustomerId());

		}


		@Test
		@DisplayName("Delete Customer By Id success test case")
		public void  shoppingController_deleteCustomerById_success(){
			int customerId = 1;

			Mockito.when(customerService.deleteCustomerById(customerId)).thenReturn("User deleted");

			ResponseEntity<String> result = shoppingController.deleteCustomerById(customerId);

			Assertions.assertEquals("User deleted", result.getBody());
			Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());


		}

	}


