package mx.com.mrjob.Repository;

import java.util.List;

import mx.com.mrjob.Dto.Proveedores;

public interface IProveedoresRepository {

	public List<Proveedores> getProveedores();
	
	public Integer insertProveedores(Proveedores proveedor);
	
	public Integer actualizarProveedores(Proveedores proveedor);
	
	public Integer eliminarProveedor(Proveedores proveedor);
}
