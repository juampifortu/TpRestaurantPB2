package ar.edu.unlam.pb2;

public class AdministradorYaExistenteException extends Exception {

	public AdministradorYaExistenteException(){
		super("Ya existe este administrador");
	}
}
