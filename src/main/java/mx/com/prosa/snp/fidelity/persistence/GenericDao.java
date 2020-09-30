package mx.com.prosa.snp.fidelity.persistence;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface GenericDao <T, PK extends Serializable> {
	
	/**
	 * creates a new object in the database
	 * @param persistObject
	 */
	void  create(T persistObject);
	/**
	 * reads the object from the database given the provided PK object
	 * @param id
	 * @return
	 */
	T read(PK id);
	
	/**
	 * 
	 * @param persistObject
	 */
	void update(T persistObject);
	
	void update(String sql); //agregado 13Feb2012: ejecuta una sentencia de update de sql
	
	void delete(T persistObject);
	
	void deleteById(PK id);
	
	
	void createOrUpdate(T persisObject); //agregado 11Marzo2003: se agrega metodo para usos futuros y facilitar operaciones
	
	
	List<T> listAll();

	boolean exists(T persistObject);
	
	boolean exist(PK id);
	
	int getTotal();
	
	int getTotalByCriteria(T persistObject);
	
	T findById(PK id);
	
	T findByCriteria(T persistObject);
	
	List<T> listByCriteria(T persistObject);
	
	List<T> listByCriteria(T persistObject,Map<String, String> orderBy);
	
	List<T> listByCriteria(T persisObject, Integer start, Integer end, Map<String,String> orderBy);
	
	List<T> listByCriteria(T persisObject,Map<String,Object[]> persistObjectAdditionalRestrictionValues, Integer start, Integer end, Map<String,String> orderBy);
	
	
	
	/**
	 * detaches an object from session
	 */
	void evict(T persistObject);
	
	/**
	 * re attaches an object to session  
	 * @param persistObject
	 */
	void merge(T persistObject);
	
	
	public String getPersistenceClassId();
	
	public  List<String> getPersistenceClassSkippedProperties();
	

}
