abstruct class BMW()
{
    public BMW();
}
pubblic class BMW100 extends BMW
{
    public BMW100()
    {
        System.out.println("this is BMW100");
    }
}
pubblic class BMW109 extends BMW
{
    public BMW109()
    {
        System.out.println("this is BMW100");
    }
}
pubblic class BMW200 extends BMW
{
    public BMW200()
    {
        System.out.println("this is BMW200");
    }
}
pubblic class BMW209 extends BMW
{
    public BMW209()
    {
        System.out.println("this is BMW209");
    }
}
interface Factory
{
    BMW createBMW();
}
public class FactoryBMW1 implements FactoryBMW{  

    @Override  
    public BMW100 createBMW() {  
        return new BMW100();  
    }  

}  
public class FactoryBMW2 implements FactoryBMW {  
    @Override  
    public BMW200 createBMW() {  

        return new BMW200();  
    }  
}
