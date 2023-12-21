package mx.com.mrjob.RepositoryImplement;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import mx.com.mrjob.Dto.Pagos;
import mx.com.mrjob.Dto.ResponseDto;
import mx.com.mrjob.Mapper.PagosMapper;
import mx.com.mrjob.Repository.ITransferenciasRepository;

@Repository  //ESTA CAPA ES DE BASE DE DATOS Y SIRVE PARA EJECUTAR CONSULTAS A BASE DE DATOS
public class TransferenciasRepositoryImplement implements ITransferenciasRepository{

	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate = new JdbcTemplate();
	
	public String getTransferencias() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Pagos> getPagos() {
		jdbcTemplate.setDataSource(getDataSource());// CON ESTO SE ASINGA LA CONEXIÓN A LA BASE DE DATOS
		return jdbcTemplate.query("SELECT * FROM PAGOS_TEST", new PagosMapper<Pagos>() );
	}
	@Override
	public ResponseDto insertPagos(Pagos pago) {
		// TODO Auto-generated method stub
		return null;
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