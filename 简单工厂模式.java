abstract class BMW{
    public BMW(){}
}
public class BMW100 extends BMW{
    public BMW100(){
        System.out.println("this is BMW100");
    }
}
public class BMW200 extends BMW{    
    public BMW200(){
        System.out.println("this is BMW200");
   }
}
public class Factory{
    public BMW CreateBMW(int type){
        if(type ==100) return new BMW100();
        if(type ==200) return new BMW200();
        else return null;
    }
}