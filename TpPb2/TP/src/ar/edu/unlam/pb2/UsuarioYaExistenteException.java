package ar.edu.unlam.pb2;

public class UsuarioYaExistenteException extends Exception {

	public UsuarioYaExistenteException(){
		super("Ya existe un mismo usuario");
	}
	
}
