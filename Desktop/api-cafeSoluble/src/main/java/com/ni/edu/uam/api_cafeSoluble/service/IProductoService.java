package com.ni.edu.uam.api_cafeSoluble.service;

import com.ni.edu.uam.api_cafeSoluble.models.Producto;

import java.util.List;

public interface IProductoService  {


    List<Producto> findAll();

    Producto findById(Long id);

    Producto save(Producto producto);

    Boolean deleteById(Long id);

    Producto update(Long codProducto,Producto producto);

}
