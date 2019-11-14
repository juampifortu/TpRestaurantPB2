package ar.edu.unlam.pb2;

public class ClienteNoExistenteException extends Exception {

	public ClienteNoExistenteException(){
		super("No existe el cliente");
	}
}
