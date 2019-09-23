public class Simple(){
     private static Single s=new Single();        
     private Single(){
        
     }  
     public static class Simple getSimple(){
         return s;
     } 

}    
/*一般用于枚举法：*/
enum Single {
    Single;

    private Single() {
        
    }

    public void print(){
        System.out.println("hello world");
    }
}
public class SingleDemo {
    public static void main(String[] args) {
        Single a = Single.Single;
        a.print();
    }