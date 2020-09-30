package mx.com.prosa.snp.fidelity.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the TBL_SNP_ADVICE database table.
 * 
 */
@Entity
@Table(name="TBL_SNP_ADVICE")
@NamedQuery(name="TblSnpAdvice.findAll", query="SELECT t FROM TblSnpAdvice t")
public class TblSnpAdvice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String pan;

	private String comentario;

	private String email;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_REGISTRO")
	private Date fechaRegistro;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_ULTIMA_ACTUALIZACION")
	private Date fechaUltimaActualizacion;

	private String fiid;

	private String modif;

	@Column(name="OLD_PAN")
	private String oldPan;

	@Column(name="PAN_REEMPLAZADO")
	private String panReemplazado;

	private String phone;

	@Column(name="SEND_EMAIL")
	private String sendEmail;

	@Column(name="SEND_PHONE")
	private String sendPhone;

	@Column(name="SEND_PUSH")
	private String sendPush;

	private String status;

	@Column(name="TIPO_TH")
	private String tipoTh;

	public TblSnpAdvice() {
	}

	public String getPan() {
		return this.pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getComentario() {
		return this.comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Date getFechaUltimaActualizacion() {
		return this.fechaUltimaActualizacion;
	}

	public void setFechaUltimaActualizacion(Date fechaUltimaActualizacion) {
		this.fechaUltimaActualizacion = fechaUltimaActualizacion;
	}

	public String getFiid() {
		return this.fiid;
	}

	public void setFiid(String fiid) {
		this.fiid = fiid;
	}

	public String getModif() {
		return this.modif;
	}

	public void setModif(String modif) {
		this.modif = modif;
	}

	public String getOldPan() {
		return this.oldPan;
	}

	public void setOldPan(String oldPan) {
		this.oldPan = oldPan;
	}

	public String getPanReemplazado() {
		return this.panReemplazado;
	}

	public void setPanReemplazado(String panReemplazado) {
		this.panReemplazado = panReemplazado;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSendEmail() {
		return this.sendEmail;
	}

	public void setSendEmail(String sendEmail) {
		this.sendEmail = sendEmail;
	}

	public String getSendPhone() {
		return this.sendPhone;
	}

	public void setSendPhone(String sendPhone) {
		this.sendPhone = sendPhone;
	}

	public String getSendPush() {
		return this.sendPush;
	}

	public void setSendPush(String sendPush) {
		this.sendPush = sendPush;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTipoTh() {
		return this.tipoTh;
	}

	public void setTipoTh(String tipoTh) {
		this.tipoTh = tipoTh;
	}

}