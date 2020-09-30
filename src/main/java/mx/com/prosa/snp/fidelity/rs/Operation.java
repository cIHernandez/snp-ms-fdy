package mx.com.prosa.snp.fidelity.rs;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mx.com.prosa.snp.fidelity.model.dto.OperationRequestDTO;
import mx.com.prosa.snp.fidelity.model.dto.OperationResponseDTO;

@RequestMapping("/ms-snp-fdy")
public interface Operation {
	
	@RequestMapping(method=RequestMethod.POST, value="/getphone")
	public OperationResponseDTO getphone(@RequestBody OperationRequestDTO operationRequestDTO);

}
