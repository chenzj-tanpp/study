package check;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import yuan.Customer;
import yuan.Movie;
import yuan.Rental;

class Checktest {

	@Test
	void test() {
		Customer customer = new Customer("ZhangSan"); 

		customer.addRental(new Rental(new Movie("aaa",Movie.REGULAR),1)); 
		customer.addRental(new Rental(new Movie("bbb",Movie.NEW_RELEASE),1)); 
		customer.addRental(new Rental(new Movie("ccc",Movie.CHILDRENS),1)); 
		System.out.println(customer.statement());
	}

}
