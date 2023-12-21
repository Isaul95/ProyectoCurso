package mx.com.mrjob.Services;

import java.util.List;
import mx.com.mrjob.Dto.Pagos;
import mx.com.mrjob.Dto.ResponseDto;

public interface ITransferencias {

	public String getTransferencias();
	
	public List<Pagos> getPagos();

	public ResponseDto insertPagos(Pagos pago);
	
}
