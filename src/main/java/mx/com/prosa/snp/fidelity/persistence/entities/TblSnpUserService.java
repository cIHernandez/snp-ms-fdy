package mx.com.prosa.snp.fidelity.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TBL_SNP_USER_SERVICE database table.
 * 
 */
@Entity
@Table(name="TBL_SNP_USER_SERVICE")
@NamedQuery(name="TblSnpUserService.findAll", query="SELECT t FROM TblSnpUserService t")
public class TblSnpUserService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="USER_ID")
	private String userId;

	private String password;
	
	private String salt;

	public TblSnpUserService() {
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

}