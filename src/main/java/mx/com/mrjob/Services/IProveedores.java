package mx.com.mrjob.Services;

import java.util.List;

import mx.com.mrjob.Dto.Proveedores;
import mx.com.mrjob.Dto.ResponseDto;

public interface IProveedores {

	public List<Proveedores> getProveedores();
	
	public ResponseDto insertProveedores(Proveedores proveedor);
	
	public ResponseDto actualizarProveedores(Proveedores proveedor);
	
	public ResponseDto eliminarProveedor(Proveedores proveedor);
}
