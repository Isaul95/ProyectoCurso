package mx.com.mrjob.Repository;

import java.util.List;

import mx.com.mrjob.Dto.UsuariosAdminDTO;
import mx.com.mrjob.entidades.UsuariosAdmin;

// DAO - Es un patron de diseño -(Tiene una estructura que hay que cumplir) -> Data Access Object
//                                        DAO<Tipo de clase, PK -primary key>
//                                       DAO<Clase Entidad, IDENTIFICADOR>
public interface UsuariosAdminDAO extends DAO<UsuariosAdmin, Long>{

	List<UsuariosAdmin> getUsuariosAdmin();

	List<UsuariosAdmin> getUsuariosAdminPorEstado(UsuariosAdminDTO datos);
	
	
	

}
