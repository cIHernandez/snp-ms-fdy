package mx.com.prosa.snp.fidelity.service.imp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import mx.com.prosa.snp.fidelity.model.dto.OperationRequestDTO;
import mx.com.prosa.snp.fidelity.model.dto.OperationResponseDTO;
import mx.com.prosa.snp.fidelity.persistence.dao.AdviceDao;
import mx.com.prosa.snp.fidelity.service.OperationService;

@Service("OperationServiceImpl")
public class OperationServiceImpl implements OperationService{
	
	Logger logger = LoggerFactory.getLogger(OperationServiceImpl.class);
	@Autowired AdviceDao adviceDao;

	@Override
	public OperationResponseDTO getPhoneByPan(OperationRequestDTO request) {
		
		OperationResponseDTO response = new OperationResponseDTO();
		String phone;
		
		try {
			String pan = String.format("%-19s", request.getPan());
			phone = adviceDao.findPhoneByPan(pan);
			if ("".equals(phone) || phone==null){
				logger.info("No se encontro telefono asociado a la tarjeta");
				response.setMessage("No se encontro telefono asociado a la tarjeta");
			}else {
				response.setMessage(HttpStatus.OK.getReasonPhrase());
			}
		}catch (DataAccessException dae){
			logger.error("Error obteniendo el telefono", dae);
			 throw new ResponseStatusException(
			          HttpStatus.INTERNAL_SERVER_ERROR, "Failed to get data", dae);
			
		}
		response.setStatus(HttpStatus.OK.value());
		response.setPhone(phone.trim());
		response.setPan(request.getPan());
		
		return response;
	}

}
