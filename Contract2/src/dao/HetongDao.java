package dao;

import java.util.List;

import model.Hetong;


public interface HetongDao  {
	
	
	
	public void insertBean(Hetong Hetong);
	
	public void deleteBean(Hetong Hetong);
	
	public void updateBean(Hetong Hetong);

	public Hetong selectBean(String where);
	
	public List<Hetong> selectBeanList(final int start, final int limit,final String where);
	
	public int selectBeanCount(final String where);
	
	
}
