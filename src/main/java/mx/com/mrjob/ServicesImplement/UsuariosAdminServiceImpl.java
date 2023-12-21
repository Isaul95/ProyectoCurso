package mx.com.mrjob.ServicesImplement;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mx.com.mrjob.Dto.ResponseDto;
import mx.com.mrjob.Dto.UsuariosAdminDTO;
import mx.com.mrjob.Repository.UsuariosAdminDAO;
import mx.com.mrjob.Services.UsuariosAdminService;
import mx.com.mrjob.entidades.UsuariosAdmin;


@Service
public class UsuariosAdminServiceImpl implements UsuariosAdminService{
	
	@Autowired
	private UsuariosAdminDAO usuariosAdminDAO;
	
	
	
	// Regla 01: Necesito un lista de usuarios
	// Regla 02: Necesito que cuando no existan usuarios el sistema me arroje un mensaje -> "No existen registros"
	@Override
	public List<UsuariosAdmin> obtenerUsuarios() {
		
		List<UsuariosAdmin> listaUsuarios = usuariosAdminDAO.getUsuariosAdmin();
		
		if(listaUsuarios.isEmpty() || listaUsuarios == null) { // la lista es vacio o nula
			listaUsuarios.add(null);
		}
//		else { // Cuando la lista no sea vacia
//			listaUsuarios.add(null);
//		}
		
		return listaUsuarios;
	}

	


	@Override
	public List<UsuariosAdmin> obtenerUsuariosPorEstado(UsuariosAdminDTO datos) {
		List<UsuariosAdmin> listaUsuariosPorEstado = usuariosAdminDAO.getUsuariosAdminPorEstado(datos);
		return listaUsuariosPorEstado;
	}

	
	
	

	

	/*
	 * ESTE METODO ES PARA INSERTAR CON HIBERNATE 
	 */
	@Override
	public ResponseDto insertUsuariosAdmin(UsuariosAdminDTO nuevoUsuario) {
		ResponseDto response = new ResponseDto(); // inicializar el obj en vacio
		
		/*Los datos que se mandan desde Postman vienen en el objt -----> nuevoUsuario
		  
nuevoUsuario =	{
					"idUser" : "1",
					"nombreCompleto" : "x",
					"edad" : "18",
					"direccion" : "calle x"
				}
		 */
		
// REGLA #1 -> Para trabajar con hibernate se usa un objeto de la clase entidad para traspasar la informacion 
// JDBC ---> INSERT INTO (CAMPO1, CAMPO2, ...) VALUES (valor1, valor,2,..... las incognitas)
// HIBERNATE --> la inf que trae el DTO hay que trasladar esa info a un obj de la entidad -> create
		
		if(nuevoUsuario != null) {
		
			UsuariosAdmin objtEntidad = new UsuariosAdmin(); // creando un obj con nombre->(objtEntidad) de la clase entiudad
			objtEntidad.setIdUser(nuevoUsuario.getIdUser());
			objtEntidad.setNombreCompleto(nuevoUsuario.getNombreCompleto());
			objtEntidad.setEdad(nuevoUsuario.getEdad());
			objtEntidad.setDireccion(nuevoUsuario.getDireccion());
			objtEntidad.setEstado(nuevoUsuario.getEstado());
			objtEntidad.setRol(nuevoUsuario.getRol());
			
	/*		objtEntidad =	{
						"idUser" : "1",
						"nombreCompleto" : "x",
						"edad" : "18",
						"direccion" : "calle x",
					}
	  */
	 
			usuariosAdminDAO.create(objtEntidad); // create --> insert con hibernate
			response.setCode(200);
			response.setMessage("Los datos se insertaron correctamente..!");
		
		}else {
			response.setCode(100);
			response.setMessage("Los datos vienen vacios");
		}
		
		return response;
	}


	
	

// Validar que el id no sean un valor cero o que vaya null
// Validar que el id sea numerico , que no se mande texto
	@Override
	public ResponseDto eliminarUsuario(UsuariosAdminDTO datos) {
		ResponseDto response = new ResponseDto();
		
/*Los datos que se mandan desde Postman vienen en el objt -----> nuevoUsuario
		  
datos =	{
					"idUser" : "1",
					"nombreCompleto" : "",
					"edad" : "",
					"direccion" : ""
				}
		 */
		if(datos.getIdUser() != 0) {
			usuariosAdminDAO.delete(datos.getIdUser()); // Eliminar con hibernate
			response.setCode(200);
			response.setMessage("El registro se elimino correctamente");
		}else {
			response.setCode(100);
			response.setMessage("El idUser no debe de ser Cero");
		}

		return response;
	}



	
	

	@Override
	public ResponseDto actualizarUsuario(UsuariosAdminDTO datos) {
		ResponseDto response = new ResponseDto();
		
/*Los datos que se mandan desde Postman vienen en el objt -----> datos
		  
datos =	{
					"idUser" : "1",
					"nombreCompleto" : "x",
					"edad" : "18",
					"direccion" : "calle x"
				}
		 */
		
		UsuariosAdmin objteto = new UsuariosAdmin(); // creando un obj con nombre->(objtEntidad) de la clase entiudad
		objteto.setIdUser(datos.getIdUser());
		objteto.setNombreCompleto(datos.getNombreCompleto());
		objteto.setEdad(datos.getEdad());
		objteto.setDireccion(datos.getDireccion());
		objteto.setEstado(datos.getEstado());
		objteto.setRol(datos.getRol());
		
/*		objteto =	{
			"idUser" : "1",
			"nombreCompleto" : "x",
			"edad" : "18",
			"direccion" : "calle x",
		}
*/

		usuariosAdminDAO.update(objteto); // actualizar infor con hibernate
		response.setCode(200);
		response.setMessage("El registro se actualia correctamente...");
		
		return response;
	}


	
	

	// Regla 01: Si el usuario no manda el identiticador
	// Regla 02: No se encuentre el usuario con ese id
	@Override
	public ResponseDto getUsuariosAdminPorId(UsuariosAdminDTO dato) {
		ResponseDto response = new ResponseDto();
		
/*Los datos que se mandan desde Postman vienen en el objt -----> nuevoUsuario
dato =	{
					"idUser" : "1",
					"nombreCompleto" : "",
					"edad" : "",
					"direccion" : ""
				}
		 */
		
		if(dato.getIdUser() != null || dato.getIdUser() != 0) {
			usuariosAdminDAO.read(dato.getIdUser()); // consultas -> SELECT * FROM WHERE ID =?
			response.setCode(200);
			response.setMessage("Usuario encontrado");
		}else {
			response.setCode(100);
			response.setMessage("Usuario no encontrado");
		}
		
		return response;
	}



	
	
	
	
	
	
	
}// fin de la clase
