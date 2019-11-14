package ar.edu.unlam.pb2;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;

public class Sistema {

	private ArrayList<Usuario> listaUsuarios;
	private String producto;
	private Double precio;
	private Integer cantidad;
	private Integer mesa;
	private String correo;
	private Date fecha;
	private Integer nro_pedido;
	//private Usuario usuario;
	protected ArrayList<Restaurant> listaRestaurant=new ArrayList<Restaurant>();
	
	public Sistema(){
		this.listaUsuarios=new ArrayList<Usuario>();
	}
	
	public Boolean agregarUsuario(Usuario user) throws UsuarioYaExistenteException{
	
		Boolean exito=false;
		
		if(listaUsuarios.isEmpty()){
			listaUsuarios.add(user);
			exito = true;
		}
		else{
		for (Usuario usuario : listaUsuarios) {
			if(usuario.getCorreo().equals(user.getCorreo())){
				exito = false;
				throw new UsuarioYaExistenteException();
				
		}
	
		else{
		
			listaUsuarios.add(user);
			exito = true;
		}
		
	}}
		return exito;
	}
	
	/*public void menu(String opcion, String opcion2){
		
		switch(opcion){
		case "a":
			agregarUsuario(usuario);
			break;
		
		case "b":
			for (Usuario usuario : listaUsuarios) {
				if(listaUsuarios.equals(correo)){
					switch (opcion2) {
					case "a":
						calcularNumeroOrden();
						break;
					case "b":
						eliminarUsuario(usuario);
						break;
					case "c":
						
						break;
					default:
						break;
					}
				}
			}
			break;
		}
	}*/
	
	public int calcularNumeroOrden(){
		return listaUsuarios.size();			
		
	}
	
	public void eliminarUsuario(Usuario usuario) throws UsuarioNoExistenteException{
		Iterator<Usuario> it= listaUsuarios.iterator();
		while(it.hasNext()) {
		Usuario usuarios= it.next();
		if(!listaUsuarios.contains(usuarios)){
			throw new UsuarioNoExistenteException();
		}
		
		
		if (usuarios.equals(usuario)) {	
		it.remove();
		}
		}
		
		
	}
	
	public Restaurant elegirRestaurant(String nombre) throws RestaurantNoExistenteException{
		for (Restaurant restaurant : listaRestaurant) {
			if(restaurant.getNombre().equals(nombre)){
				return restaurant;
			}
		}
		return null;
	}
	
	
	public ArrayList<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
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

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
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

//	public Usuario getUsuario() {
//		return usuario;
//	}
//
//	public void setUsuario(Usuario usuario) {
//		this.usuario = usuario;
//	}

	public ArrayList<Restaurant> getListaRestaurant() {
		return listaRestaurant;
	}

	public void setListaRestaurant(ArrayList<Restaurant> listaRestaurant) {
		this.listaRestaurant = listaRestaurant;
	}

	
	
}
