package mx.com.prosa.snp.fidelity.rs.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import mx.com.prosa.snp.fidelity.exception.GenericException;
import mx.com.prosa.snp.fidelity.model.dto.OperationRequestDTO;
import mx.com.prosa.snp.fidelity.model.dto.OperationResponseDTO;
import mx.com.prosa.snp.fidelity.persistence.dao.UserServiceDao;
import mx.com.prosa.snp.fidelity.persistence.entities.TblSnpUserService;
import mx.com.prosa.snp.fidelity.rs.Operation;
import mx.com.prosa.snp.fidelity.service.OperationService;
import mx.com.prosa.snp.fidelity.util.Sha256;
import java.util.Base64;

@RestController
public class OperationImpl implements Operation  {
	
	Logger logger = LoggerFactory.getLogger(OperationImpl.class);
	
	@Autowired
	OperationService  operationService;
	
	@Autowired
	UserServiceDao userServiceDao;

	@Override
	public OperationResponseDTO getphone(OperationRequestDTO operationRequestDTO)  {
		
		OperationResponseDTO response= null;
		//Long time = (new Date()).getTime();
		logger.info("Request ${time}: ${request?.toString()}");
		
		try {
			if(validateSecurity(operationRequestDTO))
				response=operationService.getPhoneByPan(operationRequestDTO);
			else {
				logger.error("No se puede validar el usuario");
				throw new GenericException(HttpStatus.UNAUTHORIZED,"El usario o password es incorrecto");
				}
		}
			catch(ResponseStatusException rse) {
				logger.error("Error  consulting Phone by Pan",rse);
			}
		logger.info("Response ${time}: ${response?.toString()}");
		return response;
	}
	
	boolean validateSecurity(OperationRequestDTO request){
		
		TblSnpUserService tblSnpUserService = null;
		Sha256 sha256 = new Sha256();
		String password="";
		
		//busca el usuarioServicio por la contraseña
		tblSnpUserService = userServiceDao.findUser(request.getUser());
		if (tblSnpUserService != null) {
			byte [] saltDecode = Base64.getDecoder().decode(tblSnpUserService.getSalt().getBytes());
			password = sha256.generatePassword(request.getPassword(), saltDecode);
				if (password.equals(tblSnpUserService.getPassword()))
					return true;
		}
		
		return false;
	}

}
