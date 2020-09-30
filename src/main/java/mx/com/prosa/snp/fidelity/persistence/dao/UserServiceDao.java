package mx.com.prosa.snp.fidelity.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mx.com.prosa.snp.fidelity.persistence.entities.TblSnpUserService;

public interface UserServiceDao extends JpaRepository<TblSnpUserService, String> {

	@Query("SELECT u FROM TblSnpUserService u WHERE u.userId =?1")
	TblSnpUserService findUser(String userId);
}
