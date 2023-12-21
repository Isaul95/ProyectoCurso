package mx.com.mrjob.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import mx.com.mrjob.Dto.Pagos;
import mx.com.mrjob.Dto.ResponseDto;
import mx.com.mrjob.Services.ITransferencias;

@Controller  // PERMITE DEFINIR NUESTRA CLASE COMO UN CONTROLADOR
@RequestMapping("Transfer") // PERMITE DEFINIR UN NOMBRE PARA EL CONTROLADOR
public class ControllerTransferencias {

	@Autowired   // INYECCI�N DE DEPENDENCIAS
	private ITransferencias iTransferencias;
	
	@RequestMapping("getTransferencias") // PERMITE DEFINIR UN NOMBRE PARA UN SERVICIO DENTRO DE NUESTRO CONTROLADOR
	public String getTransferencias() {
		iTransferencias.getTransferencias();
		
		return "Transferencias";
	}
	
	//GET - OBTENER INFORMACI�N
	// POST - RECIBIR Y OBTENER INFORMACI�N
	//PUT - RECIBIR Y OBTENER INFORMACI�N Y ACTUALIZAR
	//DELETE RECIBIR Y OBTENER INFORMACI�N Y ELIMINAR
	
	//CODIGOS DE RESPUESTA HTTP
	//404 - NO SE ENCUENTRA EL RECURSO REQUERIDO DISPONIBLE
	// 500 - EXCEPCI�N INTERNAR (UNICAMENTE EN EL CODIGO)
	// 200 - LA PETICI�N REALIZADA FUE EXITOSA
	// 202 - LA PETICI�N REALIZADA FUE EXITOSA Y RETORNO ALGO O SE EJECUTO BIEN, ETC.
	//503 - PERMISO DENEGADO . CUANDO NO TIENES ACCESO A UNA FUNCI�N O MODULO.
	
	@ResponseBody //NOS PERMITE RETORNAR UNICAMENTE DATOS, Y NO UNA VISTA
    @RequestMapping(value="/getPagos", method = RequestMethod.GET, produces = "application/json")
	ResponseEntity <  List<Pagos> > getPagosMetodo(){
		final HttpHeaders httpHeaders = new HttpHeaders();
		List<Pagos> lista = iTransferencias.getPagos();
	
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity <List<Pagos>> (lista, httpHeaders, HttpStatus.OK);	
    } 
	
	
	// INSERTAR REGISTROS
	
		@ResponseBody //NOS PERMITE RETORNAR UNICAMENTE DATOS, Y NO UNA VISTA
    @RequestMapping(value="/insertPagos", method = RequestMethod.POST, produces = "application/json")
	ResponseEntity <  ResponseDto > insertPagos(@RequestBody Pagos pago){
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = new ResponseDto();
	    response = iTransferencias.insertPagos(pago);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity <ResponseDto> (response, httpHeaders, HttpStatus.OK);	
    } 



	// OTRA PERSONA LE MOVIO AL CODIGO DE TRASNFERENCIAS
	
}
