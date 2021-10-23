package com.HeladeriaSnowy.Interfaces.Service;

import com.HeladeriaSnowy.Model.ClienteModel;

import java.util.List;
import java.util.Optional;


public interface IClienteService {
	
	public List<ClienteModel> listarClientes();
	public Optional<ClienteModel> listarIdCliente(String Cedula);
	public int saveCliente (ClienteModel c);	
	public void deleteCliente (String cedula);
}
