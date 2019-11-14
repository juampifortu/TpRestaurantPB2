package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Cliente {

	private Usuario usuario;
	protected ArrayList<Pedido> listaHistorialPedido= new ArrayList<Pedido>();

	
	public void pedir(Cliente cliente, Pedido pedido) throws ClienteNoExistenteException{
		cliente.getListaHistorialPedido().add(pedido);	
	}
	
	public void cancelar(Cliente cliente, Pedido pedido) throws PedidoNoExistenteException{
		Iterator<Pedido> it = listaHistorialPedido.iterator(); 
		
		while(it.hasNext()){
			
			if(!listaHistorialPedido.contains(pedido)){
				
				throw new PedidoNoExistenteException();
			}
			
			if(cliente.getListaHistorialPedido().equals(pedido)){
				it.remove();
			}
		}
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public ArrayList<Pedido> getListaHistorialPedido() {
		return listaHistorialPedido;
	}

	public void setListaHistorialPedido(LinkedList<String> listaPedidos) {
		this.listaHistorialPedido = listaHistorialPedido;
	}

}
