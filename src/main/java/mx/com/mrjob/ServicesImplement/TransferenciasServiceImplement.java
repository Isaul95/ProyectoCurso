package mx.com.mrjob.ServicesImplement;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mx.com.mrjob.Dto.Pagos;
import mx.com.mrjob.Dto.ResponseDto;
import mx.com.mrjob.Repository.ITransferenciasRepository;
import mx.com.mrjob.Services.ITransferencias;

@Service   // ESTA CLASE ES DE SERVICIO, PERTENECIENTE A LA CAPA DE NEGOCIOA Y AQUI VAN LAS REGLAS DE NEGOCO
public class TransferenciasServiceImplement implements ITransferencias{

	@Autowired
	private ITransferenciasRepository iTransferenciasRepository;

	public String getTransferencias() {	
		iTransferenciasRepository.getTransferencias();
		return "";
	}
	public List<Pagos> getPagos() {
		return iTransferenciasRepository.getPagos();
	}
	public ResponseDto insertPagos(Pagos pago) {
		ResponseDto response = new ResponseDto();
		response = iTransferenciasRepository.insertPagos(pago);
	    return response;
	}
	
}