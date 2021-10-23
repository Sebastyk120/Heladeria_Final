package com.HeladeriaSnowy.Interfaces;

import com.HeladeriaSnowy.Model.FacturaModel;
import org.springframework.data.repository.CrudRepository;

public interface IFactura extends CrudRepository <FacturaModel, String> {

}

