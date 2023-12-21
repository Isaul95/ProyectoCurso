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
import mx.com.mrjob.Dto.ResponseDto;
import mx.com.mrjob.Dto.UsuariosAdminDTO;
import mx.com.mrjob.Services.UsuariosAdminService;
import mx.com.mrjob.entidades.UsuariosAdmin;


@Controller
@RequestMapping("/usuariosAdmin")
public class ControllerUsuariosAdmin {
	
	// Inyeccion de dependencias
	@Autowired
	private UsuariosAdminService usuariosAdminService;
	/*
	 * CRUD => insert - select - update - delete
	 * 
	 * Json => un conjunto de atributos - valor  -> {"NombreCompleto" : "Isaul Hdez Ramirez", "x": "x"}
	 * 
	 */
	
	
	// Lista de usuarios por Hibernate --> lista de usuarios -> select * from tabla;
	@ResponseBody
    @RequestMapping(value="/getListaUsuarios", method = RequestMethod.GET, produces = "application/json")
	ResponseEntity <List<UsuariosAdmin>> obtenerUsuariosAdmin(){
		
		final HttpHeaders httpHeaders = new HttpHeaders();
		List<UsuariosAdmin> lista = usuariosAdminService.obtenerUsuarios();
	
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity <List<UsuariosAdmin>> (lista, httpHeaders, HttpStatus.OK);	
    } 
	
	
	
	
	

	// Servicio para inserta un nuevo usuario por Hibernate -> insert into () values(?,?,?,?)
	@ResponseBody
	@RequestMapping(value="/insertUsuarios", method= RequestMethod.POST, produces = "application/json")
	ResponseEntity <ResponseDto> insertUsuarios(@RequestBody UsuariosAdminDTO nuevoUsuario){
		final HttpHeaders httpHeaders = new HttpHeaders();
		
		ResponseDto response = usuariosAdminService.insertUsuariosAdmin(nuevoUsuario);
		
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		
		return new ResponseEntity <ResponseDto> (response, httpHeaders, HttpStatus.OK);
	}
	
	
	
	
	
	// Lista de usuarios por Hibernate --> lista de usuarios los que tengan el estado 1 -> select * from tabla where estado = 1;
		@ResponseBody
	    @RequestMapping(value="/getListaUsuarios", method = RequestMethod.POST, produces = "application/json")
		ResponseEntity <List<UsuariosAdmin>> obtenerUsuariosAdminPorEstado(@RequestBody UsuariosAdminDTO datos){
			
			final HttpHeaders httpHeaders = new HttpHeaders();
			List<UsuariosAdmin> lista = usuariosAdminService.obtenerUsuariosPorEstado(datos);
		
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);
			return new ResponseEntity <List<UsuariosAdmin>> (lista, httpHeaders, HttpStatus.OK);	
	    } 
	
	
		
		

		// Eliminar registro
			@ResponseBody
		    @RequestMapping(value="/eliminarUsuario", method = RequestMethod.DELETE, produces = "application/json")
			public ResponseEntity <ResponseDto> eliminarUsuario(@RequestBody UsuariosAdminDTO datos){
				final HttpHeaders httpHeaders = new HttpHeaders();

				ResponseDto respuesta = usuariosAdminService.eliminarUsuario(datos);
				
				httpHeaders.setContentType(MediaType.APPLICATION_JSON);
				
				return new ResponseEntity <ResponseDto> (respuesta, httpHeaders, HttpStatus.OK);	
		    }
		
			
			
			
			
			// Actualizar registro
			@ResponseBody
		    @RequestMapping(value="/actualizarDatos2", method = RequestMethod.PUT, produces = "application/json")
			ResponseEntity < ResponseDto > actualizarDatosUsuario(@RequestBody UsuariosAdminDTO datos){
				final HttpHeaders httpHeaders = new HttpHeaders();

				ResponseDto respuesta = usuariosAdminService.actualizarUsuario(datos);
				
				httpHeaders.setContentType(MediaType.APPLICATION_JSON);
				
				return new ResponseEntity <ResponseDto> (respuesta, httpHeaders, HttpStatus.OK);	
		    }
		
			
			
			
//			Consultar por identificador --> select * from tabla where id = ?
			
			@ResponseBody
			@RequestMapping(value="/getUsuariosPorId", method= RequestMethod.POST, produces = "application/json")
			public ResponseDto getUsuariosAdminPorId(@RequestBody UsuariosAdminDTO dato){
				
				return usuariosAdminService.getUsuariosAdminPorId(dato);
			}
		
		

}// Fin de la clase
