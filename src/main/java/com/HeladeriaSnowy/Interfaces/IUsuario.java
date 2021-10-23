package com.HeladeriaSnowy.Interfaces;

import com.HeladeriaSnowy.Model.UsuarioModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuario extends CrudRepository<UsuarioModel, String>{

	@Query(value="select * from tabla_Usuarios where usuario=:usuario and clave_Usuario=:clave", nativeQuery = true)
	UsuarioModel findByUsuarioAndPassword(String usuario, String clave);
}


