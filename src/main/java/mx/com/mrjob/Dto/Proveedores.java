package mx.com.mrjob.Dto;

import java.math.BigDecimal;
import java.util.Date;

public class Proveedores {

	private Integer idProveedor;
	private String nombreProveedor;
	private String numEmpleado;
	private Date fechaIngreso;
	private BigDecimal salario;
	private String puesto;

	
	public Integer getIdProveedor() {
		return idProveedor;
	}
	public void setIdProveedor(Integer idProveedor) {
		this.idProveedor = idProveedor;
	}
	public String getNombreProveedor() {
		return nombreProveedor;
	}
	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}
	public String getNumEmpleado() {
		return numEmpleado;
	}
	public void setNumEmpleado(String numEmpleado) {
		this.numEmpleado = numEmpleado;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public BigDecimal getSalario() {
		return salario;
	}
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
	public String getPuesto() {
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	@Override
	public String toString() {
		return "Proveedores [idProveedor=" + idProveedor + ", nombreProveedor=" + nombreProveedor + ", numEmpleado="
				+ numEmpleado + ", fechaIngreso=" + fechaIngreso + ", salario=" + salario + ", puesto=" + puesto + "]";
	}
	
	
	
	
	
}
