package com.HeladeriaSnowy.Interfaces;

import com.HeladeriaSnowy.Model.ProveedorModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IProveedor extends CrudRepository<ProveedorModel, String> {

}
