package mx.com.mrjob.Dto;

import java.math.BigDecimal;
import java.sql.Date;

public class Pagos {

	private Long idPago;
	private String nombreCliente;
	private Long cuenta;
	private Integer numeroPago;
	private BigDecimal monto;
	private BigDecimal impuesto;
	private Date fechaPago;
	
	/*
	 * 
	 * [
	 * {
	 *   "idPago" : 1,
	 *   "nombreCliente": "JOSE",
	 *   "cuenta": 9987522,
	 *   "numeroPago": 1,
	 *   "monto": 200.00
	 *   "impuesto": 50.00
	 *   "fechaPago": "2023/11/16"
	 * },
	 * {
	 *   "idPago" : null,
	 *   "nombreCliente": null,
	 *   "cuenta": null,
	 *   "numeroPago": null,
	 *   "monto": null
	 *   "impuesto": null
	 *   "fechaPago": null
	 * }
	 * ]
	 * 
	 */
	public Long getIdPago() {
		return idPago;
	}
	public void setIdPago(Long idPago) {
		this.idPago = idPago;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public Long getCuenta() {
		return cuenta;
	}
	public void setCuenta(Long cuenta) {
		this.cuenta = cuenta;
	}
	public Integer getNumeroPago() {
		return numeroPago;
	}
	public void setNumeroPago(Integer numeroPago) {
		this.numeroPago = numeroPago;
	}
	public BigDecimal getMonto() {
		return monto;
	}
	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}
	public BigDecimal getImpuesto() {
		return impuesto;
	}
	public void setImpuesto(BigDecimal impuesto) {
		this.impuesto = impuesto;
	}
	public Date getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}
	
	
	
	
}
