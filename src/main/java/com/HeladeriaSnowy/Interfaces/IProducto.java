package com.HeladeriaSnowy.Interfaces;

import com.HeladeriaSnowy.Model.ProductoModel;
import org.springframework.data.repository.CrudRepository;

public interface IProducto extends CrudRepository<ProductoModel, String> {

}
