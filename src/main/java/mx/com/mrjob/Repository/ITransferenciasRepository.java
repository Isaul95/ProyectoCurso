package mx.com.mrjob.Repository;

import java.util.List;

import mx.com.mrjob.Dto.Pagos;
import mx.com.mrjob.Dto.ResponseDto;

public interface ITransferenciasRepository {

	public String getTransferencias();
	
	public List<Pagos> getPagos();

	public ResponseDto insertPagos(Pagos pago);
	
}
