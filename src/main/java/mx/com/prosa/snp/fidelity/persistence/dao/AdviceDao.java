package mx.com.prosa.snp.fidelity.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import mx.com.prosa.snp.fidelity.persistence.entities.TblSnpAdvice;

@Repository
public interface AdviceDao extends JpaRepository<TblSnpAdvice, String>{
	
	@Query("SELECT a.phone FROM TblSnpAdvice a WHERE a.pan =?1")
	String findPhoneByPan(String pan);

}
