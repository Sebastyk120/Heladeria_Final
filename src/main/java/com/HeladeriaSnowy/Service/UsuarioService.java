package com.HeladeriaSnowy.Service;

import com.HeladeriaSnowy.Interfaces.IUsuario;
import com.HeladeriaSnowy.Interfaces.Service.IUsuarioService;
import com.HeladeriaSnowy.Model.UsuarioModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements IUsuarioService {

	@Autowired
	private IUsuario usuariodb;
	
	@Override
	public boolean validarUsuario(String Usuario, String Clave) {
		UsuarioModel usuario= usuariodb.findByUsuarioAndPassword(Usuario, Clave);
		return usuario!=null;
	}

	@Override
	public List<UsuarioModel> listarUsuarios() {
		return (List<UsuarioModel>)usuariodb.findAll();
	}

	@Override
	public Optional<UsuarioModel> listarIdUsuario(String Cedula) {		
		return usuariodb.findById(Cedula);
	}

	@Override
	public int saveUsuario (UsuarioModel u) {
		// TODO Auto-generated method stub
		int res =0;
		UsuarioModel usuario = usuariodb.save(u);
		if(!usuario.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void deleteUsuario (String cedula) {
		usuariodb.deleteById(cedula);
		
	}

		
}
