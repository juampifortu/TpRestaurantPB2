package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.Iterator;

public class Administrador extends Sistema{

	private String user;
	private String password;
	
	public Administrador(String user,String password){
		this.user=user;
		this.password=password;
	}
	
	public void agregarRestaurant(Restaurant restaurant) throws UsuarioYaExistenteException{
		
		if(super.getListaRestaurant().isEmpty()){
			super.getListaRestaurant().add(restaurant);
			
		}
		else{
	for (Restaurant  rest : super.getListaRestaurant()) {
		if(rest.getNombre().equals(restaurant.getNombre())){
			throw new UsuarioYaExistenteException();
			
		}
	else{
		super.getListaRestaurant().add(restaurant);
	}
		
	}
	}}
	
	public Boolean borrarRestaurant(String nombre) throws RestaurantNoExistenteException{
		Boolean exito=false;
		Iterator<Restaurant> it=listaRestaurant.iterator();
		
		while (it.hasNext()) {
			Restaurant restaurant = it.next();
			if(!listaRestaurant.contains(restaurant)){
				throw new RestaurantNoExistenteException();
			}
			
			if(restaurant.getNombre().equals(nombre)){
				it.remove();
				exito=true;
			}
		}
		return exito;
	}
	
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public ArrayList<Restaurant> getListaRestaurant() {
		return listaRestaurant;
	}

	public void setListaRestaurant(ArrayList<Restaurant> listaRestaurant) {
		this.listaRestaurant = listaRestaurant;
	}


}
