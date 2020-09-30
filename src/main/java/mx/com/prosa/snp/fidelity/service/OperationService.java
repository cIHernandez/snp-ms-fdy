package mx.com.prosa.snp.fidelity.service;

import mx.com.prosa.snp.fidelity.model.dto.OperationRequestDTO;
import mx.com.prosa.snp.fidelity.model.dto.OperationResponseDTO;

public interface OperationService {
	
	public OperationResponseDTO getPhoneByPan (OperationRequestDTO resquest);

}
