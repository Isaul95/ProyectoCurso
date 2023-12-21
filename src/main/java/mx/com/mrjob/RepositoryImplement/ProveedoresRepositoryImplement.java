package mx.com.mrjob.RepositoryImplement;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mx.com.mrjob.Dto.Proveedores;
import mx.com.mrjob.Dto.ResponseDto;
import mx.com.mrjob.Mapper.ProveedoresMapper;
import mx.com.mrjob.Repository.IProveedoresRepository;

@Repository
public class ProveedoresRepositoryImplement implements IProveedoresRepository{

	@Autowired
	private DataSource dataSource;  //TIENE LA CONEXIÓN A BASE DE DATOS, ESTO TAMBIEN LO PUEDES VER EN LA CLASE
	//DATA BASE CONFIG
	private JdbcTemplate jdbcTemplate = new JdbcTemplate();// SE VA A ENCARGAR DE LAS CONSULTAS A BASE DE DATOS
	
	@Override
	public List<Proveedores> getProveedores() {
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.query("SELECT P.NOMBRE, A.EDAD, V.COLONIA FROM PROVEEDORES P INNER JOIN ALUMNOS A ON P.ID = A.id"
				+ "inner join VECINOS V ON P.ID = V.ID", new ProveedoresMapper<Proveedores>() );
	}
	
	@Override
	public Integer insertProveedores(Proveedores proveedor) {
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.update("INSERT INTO PROVEEDORES " + 
				"(NOMBRE_PROVEEDOR, NUM_EMPLEADO, FECHA_INGRESO, SALARIO, PUESTO) " + 
				"VALUES(?,?,?,?,?)", new Object[]{proveedor.getNombreProveedor(), proveedor.getNumEmpleado(),
						proveedor.getFechaIngreso(), proveedor.getSalario(), proveedor.getPuesto()} );
	}
	
	@Override
	public Integer actualizarProveedores(Proveedores proveedor) {
		System.out.println("Llegando a la implementación del repositorio en el metodo actualizarProveedores");
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.update("UPDATE PROVEEDORES SET NOMBRE_PROVEEDOR = ?, NUM_EMPLEADO = ?, FECHA_INGRESO = ?"+
		                             ",SALARIO = ?, PUESTO = ? WHERE ID_PROVEEDOR = ? ", 
		                             new Object[] {proveedor.getNombreProveedor(),proveedor.getNumEmpleado(),
		                            		 proveedor.getFechaIngreso(),proveedor.getSalario(), proveedor.getPuesto()
		                            		 ,proveedor.getIdProveedor()});
	}
	
	@Override
	public Integer eliminarProveedor(Proveedores proveedor) {
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.update("DELETE FROM PROVEEDORES WHERE ID_PROVEEDOR = ?", proveedor.getIdProveedor());
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	

	


	
	

}
