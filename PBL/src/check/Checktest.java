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
		Customer customer1 = new Customer("LiSi");
		customer.addRental(new Rental(new Movie("aaa",Movie.REGULAR),1)); 
		customer.addRental(new Rental(new Movie("bbb",Movie.NEW_RELEASE),1)); 
		customer.addRental(new Rental(new Movie("ccc",Movie.CHILDRENS),1)); 
		customer1.addRental(new Rental(new Movie("aaa2",Movie.REGULAR),2));
		customer1.addRental(new Rental(new Movie("bbb2",Movie.NEW_RELEASE),2));
		customer1.addRental(new Rental(new Movie("ccc2",Movie.CHILDRENS),2));
		System.out.println(customer.statement());
		System.out.println(customer1.statement());
	}

}
