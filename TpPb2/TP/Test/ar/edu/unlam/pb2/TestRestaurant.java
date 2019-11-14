package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;

public class TestRestaurant {

	

	@Test
	public void testQueVerifiqueQueAgregaUsuario() throws UsuarioYaExistenteException{
		
		Usuario miUsuario=new Usuario("Esteban","Sanchez","esanchez@gmail.com","esan123");
		Usuario miUsuario2=new Usuario("Ricardo","Sanchez","sanchez@gmail.com","ricard123");
		Sistema sis=new Sistema();		
		
			sis.agregarUsuario(miUsuario);

		assertTrue(sis.getListaUsuarios().contains(miUsuario));
	}
	
	@Test
	public void testQueVerifiqueNumeroDeOrden() throws UsuarioYaExistenteException{
		Usuario miUsuario=new Usuario("Esteban","Sanchez","esanchez@gmail.com","esan123");
		Usuario miUsuario2=new Usuario("Ricardo","Sanchez","sanchez@gmail.com","ricard123");
		Sistema sis=new Sistema();		
		
		sis.agregarUsuario(miUsuario);
		sis.agregarUsuario(miUsuario2);
		
		assertEquals(1, sis.calcularNumeroOrden());

	}
	
	@Test
	public void testQueVerifiqueQueElimineUsuario() throws UsuarioYaExistenteException, UsuarioNoExistenteException{
		Usuario miUsuario=new Usuario("Esteban","Sanchez","esanchez@gmail.com","esan123");
		Usuario miUsuario2=new Usuario("Ricardo","Sanchez","sanchez@gmail.com","ricard123");
		Sistema sis=new Sistema();		
		
		sis.agregarUsuario(miUsuario2);
		
		sis.eliminarUsuario(miUsuario2);
		
		assertFalse(sis.getListaUsuarios().contains(miUsuario2));
	}
	
	@Test
	public void testQueVerifiqueQueElijaRestaurant() throws UsuarioYaExistenteException{
		Sistema sis=new Sistema();		
		Administrador admin=new Administrador();
		Restaurant rest=new Restaurant("Unlam");
		
		admin.agregarRestaurant(rest);
		
		assertTrue(admin.getListaRestaurant().contains(rest));
		
	}
	
	@Test
	public void testQueVerificaQueSeBorroUnRestaurant() throws UsuarioYaExistenteException, RestaurantNoExistenteException{
		Sistema sis=new Sistema();		
		Administrador admin=new Administrador();
		Restaurant rest=new Restaurant("Unlam");
		
		
		admin.agregarRestaurant(rest);
		admin.borrarRestaurant("Unlam");
		
		assertFalse(admin.getListaRestaurant().contains(rest));
	}
	
	
	@Test
	public void testQueVerificaQueSeHaceUnPedido() throws ClienteNoExistenteException{
		Date fecha = new Date(2019,12,11);
		Usuario miUsuario=new Usuario("Esteban","Sanchez","esanchez@gmail.com","esan123");
		Cliente cli1 = new Cliente();
		Sistema sis=new Sistema();
		Pedido ped = new Pedido("Milanesas", 200.0, 1, 3, fecha, 1, miUsuario );
		Pedido ped2 = new Pedido("Pollo", 200.0, 1, 3, fecha, 1, miUsuario );
		
		cli1.pedir(cli1, ped);
	
		assertTrue(cli1.getListaHistorialPedido().contains(ped));
		
	}
	
	
	@Test
	public void testQueVerificaQueSeCancelenPedidos() throws ClienteNoExistenteException, PedidoNoExistenteException{
		Date fecha = new Date(2019,12,11);
		Usuario miUsuario=new Usuario("Esteban","Sanchez","esanchez@gmail.com","esan123");
		Cliente cli1 = new Cliente();
		Sistema sis=new Sistema();
		Pedido ped = new Pedido("Milanesas", 200.0, 1, 3, fecha, 1, miUsuario );
		Pedido ped2 = new Pedido("Pollo", 200.0, 1, 3, fecha, 1, miUsuario );
		
		cli1.pedir(cli1, ped2);
		
		cli1.cancelar(cli1, ped2);
		
		assertFalse(cli1.getListaHistorialPedido().contains(ped2));
		
	}
	}
	

