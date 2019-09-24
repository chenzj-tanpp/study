interface Animal {    
	void shout();
}

class Cat implements Animal {    

	public void shout() {			  
		System.out.println("ß÷ß÷¡­¡­");
	}

	void sleep() {
		System.out.println("Ã¨Ë¯¾õ¡­¡­");
	}
}
class Dog implements Animal {

	public void shout() {			   
		System.out.println("ÍôÍô¡­¡­");
	}
}

public class Example15 {
	public static void main(String[] args) {
          Cat cat =new Cat(); 
		animalShout(cat);   
	}

	public static void animalShout(Animal animal) {
			Cat cat=(Cat)animal;   
			cat.sleep();           
			cat.shout();           
	}
}
