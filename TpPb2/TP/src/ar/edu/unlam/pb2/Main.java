package ar.edu.unlam.pb2;

import java.sql.Date;
import java.util.Scanner;

public class Main {

	public static void main(String args[]) throws UsuarioYaExistenteException, UsuarioNoExistenteException, RestaurantNoExistenteException, AdministradorYaExistenteException, ClienteNoExistenteException{
		
	Scanner teclado=new Scanner(System.in);
	
	Integer opc=0;
	Integer opc1 = 0;
	Integer opc2=0;
	Integer opc3=0;
	Integer opc4 =0;
	Integer opc5 = 0;
	String correo;
	String contrasenia;
	String nombreRest=null;
	String restBorrar = null;
	String usuarioBorrar=null;
	
	Date fecha  = new Date(2019,12,11);
	Sistema sis= new Sistema();
	Usuario miUsuario = null;
	Administrador admin = null;
	Restaurant restaurant = null;
	//admin.agregarRestaurant(restaurant);
	Pedido ped = null;
	
	do {
		//MENU PRINCIPAL//
		System.out.println("Ingrese\n 1. Usuario\n 2. Administrador\n 0. Salir");
		opc=teclado.nextInt();
		
		switch (opc) {
			case 0:
				System.out.println("Gracias,vuelva pronto");
				break;
			case 1:
				System.out.println("Ingrese:\n 1. Registrarse\n 2. Iniciar Sesión\n 0. Salir");
				opc=teclado.nextInt();

		//ENTRADA MENU REGISTRO USUARIO//
				switch(opc){
				case 0:
					System.out.println("Gracias,vuelva pronto");
					break;
				case 1:
//					sis.getCorreo();
					System.out.println("Ingrese el correo: ");
					correo = teclado.next();
					
					System.out.println("Ingrese su contrasenia: ");
					contrasenia = teclado.next();
					
					miUsuario = new Usuario("-","-",correo,contrasenia);
					
					sis.agregarUsuario(miUsuario);
					System.out.println("El usuario fue registrado correctamente");
					
//					System.out.println("1. Elegir restaurant\n 0. Salir");
//					opc2 = teclado.nextInt();
				
//					switch (opc2) {
//					case 1:
//						System.out.println("Ingrese el nombre del restaurant");
//						nombreRest=teclado.next();
//						sis.elegirRestaurant(nombreRest);
//						if(nombreRest.equals(restaurant)){
//							System.out.println("Existe!!!!!");
//						}
//						ped = new Pedido("Milanesas", 200.0, 1, 3, fecha, 1, miUsuario);
//						miUsuario.pedir(miUsuario, ped);
//						break;
//
//					case 0:
//						System.out.println("Gracias, vuelva pronto");
//						break;
//					}
//					
//					break;
				
				case 2:
//					System.out.println(miUsuario.getCorreo());
//					sis.getCorreo();
					if(sis.getListaUsuarios().size()==0){
						System.out.println("No hay usuarios registrados");
						opc2 = 0;
						break;
					}
					
					System.out.println("\n***INICIAR SESION***");
					
					System.out.println("Ingrese el correo: ");
					correo = teclado.next();
					
					System.out.println("Ingrese su contrasenia: ");
					contrasenia = teclado.next();
					
					if(correo.equals( miUsuario.getCorreo()) && contrasenia.equals(miUsuario.getPassword()) ){
						sis.iniciarSesion(miUsuario);
						System.out.println("Se logeo con exito");
						
						System.out.println("1. Elegir restaurant\n 0. Salir");
						opc2 = teclado.nextInt();
					}
					else{
						System.out.println("Datos incorrectos");
						break;
					}
					
					
					//ELECCION RESTAURANT USUARIO//
					switch (opc2) {
					case 1:
						
						System.out.println("Ingrese el nombre del restaurant");
						nombreRest = teclado.next();
						
						restaurant=new Restaurant(nombreRest);
						
						if(sis.getListaRestaurant().contains(nombreRest)){
							System.out.println("Existe!");
							admin.elegirRestaurant(nombreRest);
						}
						else{
							System.out.println("No existe");
						}
						
						
						ped = new Pedido("Milanesas", 200.0, 1, 3, fecha, 1, miUsuario);
						miUsuario.pedir(miUsuario, ped);
						break;

					case 0:
						System.out.println("Gracias,vuelva pronto");
						break;
					}
					
					
					//USUARIO ULTIMO MENU//
					System.out.println("1. Calcular numero de orden\n 0. Salir ");
					opc3=teclado.nextInt();
						
						switch (opc3) {
							case 1:
								sis.calcularNumeroOrden();
								System.out.println("Tu numero de orden es:" + sis.getListaUsuarios().size());
								break;
						
							case 0:
								System.out.println("Gracias,vuelva pronto");
								break;
						
							}
			}
			break;

		case 2:
			System.out.println("Ingrese:\n 1. Registrarse\n 2. Iniciar Sesión\n 0. Salir");
			opc3=teclado.nextInt();
			
								//	MENU ADMINISTRADOR REGISTRO //
			switch(opc3){
			case 1:
				System.out.println("Ingrese el correo: ");
				correo=teclado.next();
				
				System.out.println("Ingrese la contrasenia: ");
				contrasenia=teclado.next();
				
				admin=new Administrador(correo,contrasenia);
				
				sis.agregarAdmin(admin);
				System.out.println("Registrado con exito");
				
			case 2:
				
				if(sis.getListaAdmins().size()==0){
					System.out.println("No hay admins registrados");
					opc5 = 0;
					break;
				}
				
				System.out.println("\n***INICIAR SESION***");
				
				System.out.println("Ingrese el correo: ");
				correo=teclado.next();
				
				System.out.println("Ingrese la contrasenia: ");
				contrasenia = teclado.next();
				
				if(correo.equals(admin.getUser())&&contrasenia.equals(admin.getPassword())){
					
					sis.iniciarSesionAdmin(admin);
					
					System.out.println("Se logeo con exito");
					
					System.out.println("Ingrese: \n 1.Agregar Restaurant \n 2.Eliminar Restaurant \n 3. Eliminar Usuario \n 0. Salir");
					opc=teclado.nextInt();
					
				}
				else{
					System.out.println("Datos incorrectos");
					break;
				}
				
								//MENU ADMINISTRADOR INICIO DE SESION//
				
				switch (opc) {
				
				case 0:
					System.out.println("Gracias,vuelva pronto");
					break;
			
				case 1:
					
					System.out.println("Ingrese nombre de restaurant: ");
					nombreRest=teclado.next();
					
					restaurant=new Restaurant(nombreRest);
					
					if(nombreRest.equals(restaurant.getNombre())){
						admin.agregarRestaurant(restaurant);
						
						
						System.out.println("Restaurant añadido");	
					}
				
					break;

				case 2:
					
					System.out.println("Ingrese nombre de restaurant a borrar: ");
					restBorrar = teclado.next();
					
					if(restBorrar.equals(restaurant.getNombre())){
						admin.borrarRestaurant(restBorrar);
						System.out.println("Restaurant eliminado");
					
					}
					else{
						System.out.println("Restaurant no encontrado");
					}
					
					break;
					
				case 3:
			
					System.out.println("Ingrese el correo del usuario a borrar: ");
					usuarioBorrar = teclado.next();
					
					if(usuarioBorrar.equals(miUsuario.getCorreo())){
						sis.eliminarUsuario(miUsuario);
						System.out.println("Usuario eliminado");
					}
					else{
						System.out.println("No existe un usuario con este correo");
					}
					
					break;
				}
			}
			
			break;
		}
		
		
	}while(opc!=0);
	
		
			
}
}
