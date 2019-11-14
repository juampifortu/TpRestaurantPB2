package ar.edu.unlam.pb2;

public class RestaurantNoExistenteException extends Exception {

public  RestaurantNoExistenteException(){
		
		super("El restaurant no existe");
		
	}
}
