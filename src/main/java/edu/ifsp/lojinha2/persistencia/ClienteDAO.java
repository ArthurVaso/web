package edu.ifsp.lojinha2.persistencia;

import java.util.ArrayList;
import java.util.List;

import edu.ifsp.lojinha2.modelo.Cliente;

public class ClienteDAO {

	public void save(Cliente cliente) {
		System.out.printf(
				"Nome: %s\n Email: %s", 
				cliente.getNome(), 
				cliente.getEmail());
	}

	public List<Cliente> listAll() {
		List<Cliente> clientes = new ArrayList<>();
		
		Cliente c1 = new Cliente();
		c1.setNome("Doug Funnie");
		c1.setEmail("doug@jumb.com");

		Cliente c2 = new Cliente();
		c2.setNome("Roger Klotz");
		c2.setEmail("roger@jumb.com");

		Cliente c3 = new Cliente();
		c3.setNome("Bud Dink");		
		c3.setEmail("mr.dink@jumb.com");

		clientes.add(c1);
		clientes.add(c2);
		clientes.add(c3);
		
		return clientes;
	}
}







