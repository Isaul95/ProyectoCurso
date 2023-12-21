package mx.com.mrjob.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import mx.com.mrjob.Dto.Pagos;

public class PagosMapper<T> implements RowMapper<Pagos> {

	public Pagos mapRow(ResultSet rs, int rowNum) throws SQLException {
		Pagos pago = new Pagos();
		pago.setIdPago(rs.getLong("ID_PAGO"));
		pago.setNombreCliente(rs.getString("NOMBRE_CLIENTE"));
		pago.setCuenta(rs.getLong("CUENTA"));
		pago.setNumeroPago(rs.getInt("NUMERO_PAGO"));
		pago.setMonto(rs.getBigDecimal("MONTO"));
		pago.setImpuesto(rs.getBigDecimal("IMPUESTO"));
		pago.setFechaPago(rs.getDate("FECHA_PAGO"));
		return pago;
	}
}