public abstract classTv{
	public abstract void play();
}
public class haierTv extends Tv{
public void play(){
	System.out.println("This is HaierTv.");
}
}
public class HisenseTv extends Tv{
	public void play(){
		System.out.println("This is HisenseTv.");
	}
}
public interface TVFactory{
	public TV produceTV();
}
public 