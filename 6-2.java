class Father { 
private String name = "chen"; 
class Child { 
public void introFather() {
 System.out.println("My Father's name is " + name); 
}
 }
 
}
class Test02 {
 public static void main(String[] args) { 
Father.Child child = new Father().new Child();
child.introFather();
 }
 }