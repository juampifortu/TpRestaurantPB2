package ar.edu.unlam.pb2;

import java.sql.Date;
import java.util.Scanner;

public class Main {

	public static void main(String args[]) throws UsuarioYaExistenteException, UsuarioNoExistenteException, RestaurantNoExistenteException, AdministradorYaExistenteException, ClienteNoExistenteException{
		
	Scanner teclado=new Scanner(System.in);
	
	Integer opc=0;
	Integer opc2=0;
	Integer opc3=0;
	String correo;
	String nombreRest;
	
	Date fecha = new Date(2019,12,11);
	Sistema sis=new Sistema();
	Usuario miUsuario=new Usuario("Esteban","Sanchez","esanchez@gmail.com","esan123");
	Administrador admin=new Administrador("ricardo","123456");
	Restaurant restaurant=new Restaurant("Unlam");
	Pedido ped = new Pedido("Milanesas", 200.0, 1, 3, fecha, 1, miUsuario );
	
	do {
		
		System.out.println("Ingrese\n 1. Usuario\n 2. Administrador");
		opc=teclado.nextInt();
		switch (opc) {
		case 1:
			System.out.println("Ingrese:\n 1. Registrarse\n 2. Iniciar Sesión\n 0. Salir");
			opc=teclado.nextInt();
				switch(opc){
				case 0:
					System.out.println("Gracias,vuelva pronto");
					break;
					
				
				case 1:
					sis.getCorreo();
					/*System.out.println("Ingrese el correo");
					correo=teclado.next();*/
					sis.agregarUsuario(miUsuario);
					break;
				
				case 2:
					sis.getCorreo();
					/*System.out.println("Ingrese el correo");
					correo=teclado.next();*/
					sis.iniciarSesion(miUsuario);
					
					System.out.println("1. Elegir restaurant\n 0. Salir");
					opc2=teclado.nextInt();
					
					switch (opc2) {
					case 1:
						
						System.out.println("Ingrese el nombre del restaurant");
						nombreRest=teclado.next();
						sis.elegirRestaurant(nombreRest);
						System.out.println(sis.elegirRestaurant(nombreRest));
						
						miUsuario.pedir(miUsuario, ped);
						break;

					case 0:
						System.out.println("Gracias,vuelva pronto");
						break;
					}
					
					System.out.println("1. Calcular numero de orden\n 2. Eliminar usuario\n 0. Salir ");
					opc3=teclado.nextInt();
						
						switch (opc3) {
							case 1:
								sis.calcularNumeroOrden();
								System.out.println("Tu numero de orden es:" + sis.getListaUsuarios().size());
								break;
							case 2:
								sis.eliminarUsuario(miUsuario);
								break;
							case 0:
								System.out.println("Gracias,vuelva pronto");
								break;
						
							}
			}
			break;

		case 2:
			System.out.println("Ingrese:\n 1. Registrarse\n 2. Iniciar Sesión\n 0. Salir");
			opc=teclado.nextInt();
			switch(opc){
			case 1:
				System.out.println("Ingrese el correo");
				correo=teclado.next();
				sis.agregarAdmin(admin);
				break;
			case 2:
				System.out.println("Ingrese el correo");
				correo=teclado.next();
				sis.iniciarSesionAdmin(admin);
				
				System.out.println("Ingrese: \n 1.Agregar Restaurant \n 2.Eliminar Restaurant \n 3. Eliminar Usuario \n 0. Salir");
				opc=teclado.nextInt();
				
				switch (opc) {
				
				case 0:
					System.out.println("Gracias,vuelva pronto");
					break;
			
				case 1:
					admin.agregarRestaurant(restaurant);
					break;

				case 2:
					admin.borrarRestaurant("Unlam");
					break;
					
				case 3:
					sis.eliminarUsuario(miUsuario);
					break;
				}
			}
			break;
		}
		
		
	}while(opc!=0);
	
		
			
}
}
