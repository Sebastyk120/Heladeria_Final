package com.HeladeriaSnowy.Service;

import com.HeladeriaSnowy.Interfaces.ICliente;
import com.HeladeriaSnowy.Interfaces.Service.IClienteService;
import com.HeladeriaSnowy.Model.ClienteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ClienteService implements IClienteService {

	@Autowired
	private ICliente clientedb;
	
	@Override
	public List<ClienteModel> listarClientes() {
		return (List<ClienteModel>)clientedb.findAll();
	}

	@Override
	public Optional<ClienteModel> listarIdCliente(String Cedula) {		
		return clientedb.findById(Cedula);
	}

	@Override
	public int saveCliente (ClienteModel c) {
		// TODO
		int res =0;
		ClienteModel cliente = clientedb.save(c);
		if(!cliente.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void deleteCliente (String cedula) {
		clientedb.deleteById(cedula);
		
	}
	
}
