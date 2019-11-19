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
	protected ArrayList<Restaurant> listaRestaurant=new ArrayList<Restaurant>();
	private ArrayList<Administrador> listaAdmins;
	
	public Sistema(){
		this.listaUsuarios=new ArrayList<Usuario>();
		this.listaAdmins=new ArrayList<Administrador>();
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
	
	public Boolean agregarAdmin(Administrador admin)throws AdministradorYaExistenteException{
		Boolean exito=false;
		
		if(listaAdmins.isEmpty()){
			listaAdmins.add(admin);
			exito=true;
		}
		else{
			for (Administrador administrador : listaAdmins) {
				if(administrador.getCorreo().equals(admin.getCorreo())){
					exito=false;
					throw new AdministradorYaExistenteException();
				}
			
			else{
				listaAdmins.add(admin);
				exito=true;
			}}
		}
		return exito;
	}
	
	public Boolean iniciarSesionAdmin(Administrador admin){
		Boolean exito=false;
		for (Administrador administrador : listaAdmins) {
			if(administrador.getUser().equals(admin.getUser())){
				exito=true;
			}
		}
		return exito;
	}
	public Boolean iniciarSesion(Usuario user) throws UsuarioNoExistenteException{
		Boolean exito=false;
		for (Usuario usuario : listaUsuarios) {
			if(usuario.getCorreo().equals(user.getCorreo())){
				exito=true;
			}
			
			else{
				throw new UsuarioNoExistenteException();
			}
		}
		return exito;
	}
	
	
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


	public ArrayList<Restaurant> getListaRestaurant() {
		return listaRestaurant;
	}

	public void setListaRestaurant(ArrayList<Restaurant> listaRestaurant) {
		this.listaRestaurant = listaRestaurant;
	}

	
	
}
