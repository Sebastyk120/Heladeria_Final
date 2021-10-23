package com.HeladeriaSnowy.Interfaces;

import com.HeladeriaSnowy.Model.ClienteModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ICliente extends CrudRepository<ClienteModel, String> {

}
