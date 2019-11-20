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
	String nombreRest;
	String restBorrar;
	String usuarioBorrar;
	
	Date fecha = new Date(2019,12,11);
	Sistema sis=new Sistema();
	Usuario miUsuario=new Usuario("Esteban","Sanchez","esanchez@gmail.com","esan123");
	Administrador admin=new Administrador("ricardo","123456");
	Restaurant restaurant=new Restaurant("Unlam");
	Pedido ped = new Pedido("Milanesas", 200.0, 1, 3, fecha, 1, miUsuario );
	
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
					sis.getCorreo();
					System.out.println("Ingrese el correo: ");
					correo=teclado.next();
					
					System.out.println("Ingrese su contrasenia: ");
					contrasenia=teclado.next();
					
					System.out.println("El usuario fue registrado correctamente");
					sis.agregarUsuario(miUsuario);

					System.out.println("1. Elegir restaurant\n 0. Salir");
					opc2=teclado.nextInt();
					
					switch (opc2) {
					case 1:
						
						System.out.println("Ingrese el nombre del restaurant");
						nombreRest=teclado.next();
						sis.elegirRestaurant(nombreRest);
						
						
						miUsuario.pedir(miUsuario, ped);
						break;

					case 0:
						System.out.println("Gracias,vuelva pronto");
						break;
					}
					
					break;
				
				case 2:
					sis.getCorreo();
					System.out.println("Ingrese el correo: ");
					correo=teclado.next();
					
					System.out.println("Ingrese su contrasenia: ");
					contrasenia=teclado.next();
					
					System.out.println("Se logeo con exito");
					sis.iniciarSesion(miUsuario);
					
					System.out.println("1. Elegir restaurant\n 0. Salir");
					opc2=teclado.nextInt();
					
					
									//ELECCION RESTAURANT USUARIO//
					switch (opc2) {
					case 1:
						
						System.out.println("Ingrese el nombre del restaurant");
						nombreRest=teclado.next();
						sis.elegirRestaurant(nombreRest);
						
						
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
				
				System.out.println("Registrado con exito");
				sis.agregarAdmin(admin);
				
				
				System.out.println("Ingrese: \n 1.Agregar Restaurant \n 2.Eliminar Restaurant \n 3. Eliminar Usuario \n 0. Salir");
				opc5=teclado.nextInt();
				
				
								//	ELECCION DE ACCIONES ADMINISTRADOR//
					switch (opc5) {
				
				case 0:
					System.out.println("Gracias,vuelva pronto");
					break;
			
				case 1:
					admin.agregarRestaurant(restaurant);
					System.out.println("Ingrese nombre de restaurant: ");
					nombreRest=teclado.next();
					
					System.out.println("Restaurant añadido");
					break;

				case 2:
					admin.borrarRestaurant("Unlam");
					System.out.println("Ingrese nombre de restaurant a borrar: ");
					restBorrar = teclado.next();
					
					System.out.println("Restaurant eliminado");
					break;
					
				case 3:
					sis.eliminarUsuario(miUsuario);
					System.out.println("Ingrese el nombre del usuario a borrar: ");
					usuarioBorrar = teclado.next();
					
					System.out.println("Usuario eliminado");
					break;
				}
				
				
				
			case 2:
				System.out.println("Ingrese el correo: ");
				correo=teclado.next();
				
				System.out.println("Ingrese la contrasenia: ");
				contrasenia = teclado.next();
				
				System.out.println("Se logeo con exito");
				sis.iniciarSesionAdmin(admin);
				
				System.out.println("Ingrese: \n 1.Agregar Restaurant \n 2.Eliminar Restaurant \n 3. Eliminar Usuario \n 0. Salir");
				opc=teclado.nextInt();
				
				
								//MENU ADMINISTRADOR INICIO DE SESION//
				
				switch (opc) {
				
				case 0:
					System.out.println("Gracias,vuelva pronto");
					break;
			
				case 1:
					admin.agregarRestaurant(restaurant);
					System.out.println("Ingrese nombre de restaurant: ");
					nombreRest=teclado.next();
					
					System.out.println("Restaurant añadido");
					break;

				case 2:
					admin.borrarRestaurant("Unlam");
					System.out.println("Ingrese nombre de restaurant a borrar: ");
					restBorrar = teclado.next();
					
					System.out.println("Restaurant eliminado");
					break;
					
				case 3:
					sis.eliminarUsuario(miUsuario);
					System.out.println("Ingrese el nombre del usuario a borrar: ");
					usuarioBorrar = teclado.next();
					
					System.out.println("Usuario eliminado");
					break;
				}
			}
			
			break;
		}
		
		
	}while(opc!=0);
	
		
			
}
}
