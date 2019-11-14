package ar.edu.unlam.pb2;

public class UsuarioNoExistenteException extends Exception {

	public  UsuarioNoExistenteException(){
		
		super("El usuario no existe");
		
	}
}
