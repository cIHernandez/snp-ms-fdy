package mx.com.prosa.snp.fidelity.persistence.dao.impl;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import mx.com.prosa.snp.fidelity.persistence.GenericDao;

public abstract class AbstractGenericDaoHibernateImpl <T,PK extends java.io.Serializable> extends HibernateDaoSupport implements GenericDao<T,PK>{

}