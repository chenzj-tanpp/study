package dao;

import entity.IEntity;

import java.io.*;
import java.util.*;
import entity.*;

public class SCDao implements IDao {
	private static SCDao instance;
	private HashMap<String, SC> scs = new HashMap<String, SC>();
	private SC sc;

	public static SCDao getInstance() throws Exception {
		if (instance == null) {
			synchronized (SCDao.class) {
				if (instance == null) {
					instance = new SCDao();
					return instance;
				}
			}
		}
		return instance;
	}

	public void insert(IEntity entity) throws Exception {
		// TODO Auto-generated method stub
		CourseDao courseDao=CourseDao.getInstance();
		SC sc=(SC)entity;
		courseDao.add(sc.getStudentNo(), sc.getCourseNo());
		StudentDao studentDao=StudentDao.getInstance();
		studentDao.add(sc.getStudentNo(), sc.getCourseNo());
		
		update();
	}

	// ´ý¶¨
	@Override
	public ArrayList delete(String CourseNo) {
		// TODO Auto-generated method stub
		// scs.remove(key, value)
		return null;
	}

	@Override
	public void update() throws Exception {
		// TODO Auto-generated method stub
		FileOutputStream fis = new FileOutputStream("sc.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fis);
		oos.writeObject(scs);
		oos.close();
		fis.close();
	}

	@Override
	public HashMap<String, IEntity> getAllEntities() {
		// TODO Auto-generated method stub
		return null;
	}

	public IEntity getEntity(String Id) {
		sc=(SC)scs.get(Id);
		//sc=(SC)scs.values();
		return sc;
	}

}
