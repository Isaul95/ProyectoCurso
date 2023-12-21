package mx.com.mrjob.Services;

import java.util.List;

import mx.com.mrjob.Dto.ResponseDto;
import mx.com.mrjob.Dto.UsuariosAdminDTO;
import mx.com.mrjob.entidades.UsuariosAdmin;

public interface UsuariosAdminService {

	List<UsuariosAdmin> obtenerUsuarios();

	ResponseDto insertUsuariosAdmin(UsuariosAdminDTO nuevoUsuario);

	List<UsuariosAdmin> obtenerUsuariosPorEstado(UsuariosAdminDTO datos);

	ResponseDto eliminarUsuario(UsuariosAdminDTO datos);

	ResponseDto actualizarUsuario(UsuariosAdminDTO datos);

	ResponseDto getUsuariosAdminPorId(UsuariosAdminDTO dato);
	

}
