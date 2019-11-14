package ar.edu.unlam.pb2;

public class PedidoNoExistenteException extends Exception {
	public PedidoNoExistenteException(){
		super("El pedido no existe");
	}
}
