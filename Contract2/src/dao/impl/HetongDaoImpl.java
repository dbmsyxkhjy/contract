package dao.impl;

import java.sql.SQLException;
import java.util.List;

import model.Hetong;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.HetongDao;









public class HetongDaoImpl extends HibernateDaoSupport implements  HetongDao{


	public void deleteBean(Hetong Hetong) {
		this.getHibernateTemplate().delete(Hetong);
		
	}

	public void insertBean(Hetong Hetong) {
		this.getHibernateTemplate().save(Hetong);
		
	}

	@SuppressWarnings("unchecked")
	public Hetong selectBean(String where) {
		List<Hetong> list = this.getHibernateTemplate().find("from Hetong " +where);
		if(list.size()==0){
			return null;
		}
		return list.get(0);
	}

	public int selectBeanCount(String where) {
		long count = (Long)this.getHibernateTemplate().find("select count(*) from Hetong "+where).get(0);
		return (int)count;
	}

	@SuppressWarnings("unchecked")
	public List<Hetong> selectBeanList(final int start,final int limit,final String where) {
		return (List<Hetong>)this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(final Session session)throws HibernateException, SQLException {				
				List<Hetong> list = session.createQuery("from Hetong "+where)
				.setFirstResult(start)
				.setMaxResults(limit)
				.list();
				return list;
			}
		});
	}

	public void updateBean(Hetong Hetong) {
		this.getHibernateTemplate().update(Hetong);
		
	}
	
	
}
