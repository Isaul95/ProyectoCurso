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

import mx.com.mrjob.Dto.Proveedores;
import mx.com.mrjob.Dto.ResponseDto;
import mx.com.mrjob.Services.IProveedores;

@Controller
@RequestMapping("Prov")
public class ControllerProveedores {

	@Autowired
	private IProveedores iProveedores;
	
	//OBTENER TODOS LOS PROVEEDORES
	@ResponseBody
	@RequestMapping(value="/getProveedores", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Proveedores>> getProveedores(){
		final HttpHeaders httpHeaders = new HttpHeaders();
		List<Proveedores> proveedores = iProveedores.getProveedores();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity <List<Proveedores>> (proveedores, httpHeaders, HttpStatus.OK);	
	}
	
	//INSERTAR PROVEEDORES
	@ResponseBody
	@RequestMapping(value="/insertProveedor", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<ResponseDto> insertProveedor(@RequestBody Proveedores proveedor){
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = new ResponseDto();
		response = iProveedores.insertProveedores(proveedor);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity <ResponseDto> (response, httpHeaders, HttpStatus.OK);	
	}
	
	
	//ACTUALIZAR PROVEEDORES
	@ResponseBody
	@RequestMapping(value="/actualizarProveedor", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<ResponseDto> actualizarProveedor(@RequestBody Proveedores proveedor){
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = new ResponseDto();
		System.out.println("Entrando al controlado Prov, metodo actualizarProveedores");
	    response = iProveedores.actualizarProveedores(proveedor);
		System.out.println("Saliendo del metodo actualizarProveedores de la implementación del servicio ");
		System.out.println("Regresando al controlador.");
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity <ResponseDto> (response, httpHeaders, HttpStatus.OK);	
	}
	// CREAR EL CRUD COMPLETO DE LA TABLA VENTA 
	
	//ACTUALIZAR PROVEEDORES
		@ResponseBody
		@RequestMapping(value="/eliminarProveedor", method = RequestMethod.DELETE, produces = "application/json")
		public ResponseEntity<ResponseDto> eliminarProveedor(@RequestBody Proveedores proveedor){
			final HttpHeaders httpHeaders = new HttpHeaders();
			ResponseDto response = new ResponseDto();
			System.out.println("Entrando al controlado Prov, metodo eliminarProveedor");
		    response = iProveedores.eliminarProveedor(proveedor);
			System.out.println("Saliendo del metodo eliminarProveedor de la implementación del servicio ");
			System.out.println("Regresando al controlador.");
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);
			return new ResponseEntity <ResponseDto> (response, httpHeaders, HttpStatus.OK);	
		}
	
	
}