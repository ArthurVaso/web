package edu.ifsp.lojinha2.persistencia;

import edu.ifsp.lojinha2.modelo.Usuario;

public class UsuarioDAO {

	public Usuario check(String username, String password) {
		
		// TODO consultar BD um dia
		Usuario usuario = new Usuario();
		usuario.setUsername("doug");
		usuario.setNome("Douglas Funnie");
		return usuario;
	}

}
