<?xml version="1.0"?>
<config>
< brandName>HisenseTv</ brandName>
</config>
import javax.xmL.parsers. *;
import org.w3c.dom. * ;
import org.xmL.sax.SAXException;
import java.io.* ;
public class XMLUtilTV{
public static String getBrandName(){
try{
DocumentBuilderFactory dFactory = DocumentBuilderFactory . newInstance(
DocumentBuilder builder = dFactory. newDocumentBuilder();
Document doc = builder.parse(new File("configTV. xml"));
Nodelist nl = doc. getElementsByTagName( "brandName" );
Node classNode = nl. item(0).getFirstChild();
String brandName = classNode.getNodeValue().trim();
return brandName;
} catch(Exception e){
System.out.println(e.getMessage()); 
return null ; 
}
}
}

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
	public static Tv produceTv(String brand){
		if(brand.equals("HaierTv"))
		return new HaierTv();
if(brand.equals("HisenseTv"))
		return new HisenseTv();
return NULL;
}
}
public class Main{
public static void main(String args[]{
Tv tv;
String brandName =XMLUtilTV.getBrandName();
tv =TVFactory.produce(brandName);
tv.play();
}
}