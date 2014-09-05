package com.demo.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.demo.dao.UserDao;
import com.demo.po.User;
@Repository("userDao")
public class UserDaoImpl extends HibernateDaoSupport implements UserDao{
	@Resource(name="sessionFactory")
	public void setBaseDaoSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	@Override
	public String save(User user) {
		// TODO Auto-generated method stub
		
//		List lists=this.getHibernateTemplate().execute(new HibernateCallback() {
//				public Object doInHibernate(Session session)throws HibernateException, SQLException {
//					Query query = session.createSQLQuery("select sysdate from dual");
//					return query.list();
//				}
//			});
//		for(Object str:lists){
//			System.out.println(lists);
//		}
		System.out.println("id="+user.getId());
		this.getHibernateTemplate().save(user);
		
		System.out.println("dao saved");
		return null;
	}

}
