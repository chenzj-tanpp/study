
class SingleObject {
    private static SingleObject instance = new SingleObject();
    private SingleObject(){ }
   public static SingleObject getInstance(){
      return instance;
   }
    public void showMessage(){
      System.out.println("Hello World!");
   }
}
 class SingletonPatternDemo {
   public static void main(String[] args) {
     //SingleObject object = new SingleObject();/**在无错时，不可见*/
       SingleObject object = SingleObject.getInstance();
       object.showMessage();
   }
}
