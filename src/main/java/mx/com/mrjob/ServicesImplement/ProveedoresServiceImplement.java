package mx.com.mrjob.ServicesImplement;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.mrjob.Dto.Proveedores;
import mx.com.mrjob.Dto.ResponseDto;
import mx.com.mrjob.Repository.IProveedoresRepository;
import mx.com.mrjob.Services.IProveedores;

@Service
public class ProveedoresServiceImplement implements IProveedores{

	@Autowired
	private IProveedoresRepository iProveedoresRepository;
	
	@Override
	public List<Proveedores> getProveedores() {
		return iProveedoresRepository.getProveedores();
	}

	@Override
	public ResponseDto insertProveedores(Proveedores proveedor) {
		ResponseDto response = new ResponseDto();
		Integer respuesta = 0;
		boolean insertar = true;
		
		if( (proveedor.getNombreProveedor()==null||proveedor.getNombreProveedor().isEmpty())
				|| proveedor.getNombreProveedor().length()>100) {
			insertar = false;
		}
		else if( (proveedor.getNumEmpleado()==null||proveedor.getNumEmpleado().isEmpty())
				 || proveedor.getNumEmpleado().length()>8) {
			insertar = false;
		}
		else if(proveedor.getFechaIngreso()==null) {
			insertar = false;
		}
		else if(proveedor.getSalario().compareTo(new BigDecimal("100000"))>=0) {
			insertar = false;
		}
		else if( (proveedor.getPuesto()==null||proveedor.getPuesto().isEmpty())
				 || proveedor.getPuesto().length()>30) {
			insertar = false;
		}
		
		if(insertar==true) {
			respuesta = iProveedoresRepository.insertProveedores(proveedor);
		}
		
		if(respuesta==1) {
			response.setCode(1);
			response.setMessage("Se inserto correctamente");
		}
		else {
			response.setCode(0);
			response.setMessage("No se inserto correctamente");
		}		
		return response;
	}

	@Override
	public ResponseDto actualizarProveedores(Proveedores proveedor) {
		System.out.println("Llegando a la implementación del servicio, en el metodo actualizarProveedores");

		ResponseDto response = new ResponseDto();
		Integer respuesta = iProveedoresRepository.actualizarProveedores(proveedor);
		System.out.println("Saliendo del metodo actualizarProveedores de la implementación del repositorio");
		if(respuesta==1) {
			response.setCode(1);
			response.setMessage("Se actualizo correctamente el proveedor: "+proveedor.getNombreProveedor()+" con id: "+proveedor.getIdProveedor());
		}
		else {
			response.setCode(0);
			response.setMessage("No se actualizo correctamente el proveedor: "+proveedor.getNombreProveedor()+" con id: "+proveedor.getIdProveedor());
		}	
		return response;
	}

	@Override
	public ResponseDto eliminarProveedor(Proveedores proveedor) {
	    ResponseDto response = new ResponseDto();
	    Integer respuesta = iProveedoresRepository.eliminarProveedor(proveedor);
	    if(respuesta==1) {
			response.setCode(1);
			response.setMessage("Se elimino correctamente el proveedor: "+proveedor.getNombreProveedor()+" con id: "+proveedor.getIdProveedor());
		}
		else {
			response.setCode(0);
			response.setMessage("No se elimino correctamente el proveedor: "+proveedor.getNombreProveedor()+" con id: "+proveedor.getIdProveedor());
		}	
	    
		return response;
	}

}
