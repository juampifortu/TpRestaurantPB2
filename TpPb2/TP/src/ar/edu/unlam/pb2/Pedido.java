package ar.edu.unlam.pb2;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ArrayList;

public class Pedido {

	private String producto;
	private Double precio;
	private Integer cantidad;
	private Integer mesa;
	private Date fecha;
	private Integer nro_pedido;
	private Usuario usuario;
	
	
	public Pedido(String producto,Double precio,Integer cantidad,Integer mesa,Date fecha,Integer nro_pedido,Usuario usuario){
		this.producto=producto;
		this.precio=precio;
		this.cantidad=cantidad;
		this.mesa=mesa;
		this.fecha=fecha;
		this.nro_pedido=nro_pedido;
		this.usuario=usuario;
		
	}
	

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Integer getMesa() {
		return mesa;
	}

	public void setMesa(Integer mesa) {
		this.mesa = mesa;
	}


	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getNro_pedido() {
		return nro_pedido;
	}

	public void setNro_pedido(Integer nro_pedido) {
		this.nro_pedido = nro_pedido;
	}
	

	
}
