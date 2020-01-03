package dao;
import java.util.*;
import entity.IEntity;;

public interface IDao {
	void insert(IEntity entity)throws Exception;
	HashMap<String,String> delete(String temp)throws Exception;
	void update()throws Exception;
	public HashMap<String, IEntity> getAllEntities(); 
	public IEntity getEntity(String Id);
}
