package check;

import yuan.Customer;
import yuan.Movie;
import yuan.Rental;

public class test {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Customer customer = new Customer("ZhangSan"); 

		customer.addRental(new Rental(new Movie("aaa",Movie.REGULAR),1)); 
		customer.addRental(new Rental(new Movie("bbb",Movie.NEW_RELEASE),1)); 
		customer.addRental(new Rental(new Movie("ccc",Movie.CHILDRENS),1)); 
		System.out.println(customer.statement());
	}

}
