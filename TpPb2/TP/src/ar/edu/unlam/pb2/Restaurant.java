package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.Iterator;

public  class Restaurant {

	private String nombre;
	private ArrayList<Pedido> historialPedidos = new ArrayList<Pedido>();
	
	
	public Restaurant(String nombre){
		this.nombre=nombre;
	}
	
	public Boolean cancelar(Pedido ped) throws PedidoNoExistenteException{
		Boolean exito=false;
		
		Iterator <Pedido> it=historialPedidos.iterator();
		
		while (it.hasNext()) {
			Pedido pedido = it.next();
			if (!historialPedidos.contains(pedido)){
				throw new PedidoNoExistenteException();
			}
			
			if(historialPedidos.equals(ped)){
			it.remove();	
			exito=true;
			}
		}
		return exito;
	}
	
	public void pagarConEfectivo(){
		
	}
	
	public void pagarConTarjeta(){
		
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
}
