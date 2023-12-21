package mx.com.mrjob.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import mx.com.mrjob.Dto.Proveedores;

public class ProveedoresMapper<T> implements RowMapper<Proveedores> {

	@Override
	public Proveedores mapRow(ResultSet rs, int rowNum) throws SQLException {
		Proveedores proveedor = new Proveedores();
		proveedor.setIdProveedor( rs.getInt("ID_PROVEEDOR") );
		proveedor.setNombreProveedor( rs.getString("NOMBRE_PROVEEDOR") );
		proveedor.setNumEmpleado( rs.getString("NUM_EMPLEADO") );
		proveedor.setFechaIngreso( rs.getDate("FECHA_INGRESO") );
		proveedor.setSalario( rs.getBigDecimal("SALARIO") );
		proveedor.setPuesto( rs.getString("PUESTO") );
		return proveedor;
	}

}
