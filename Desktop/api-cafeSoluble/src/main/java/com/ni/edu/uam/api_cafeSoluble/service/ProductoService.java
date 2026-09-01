package com.ni.edu.uam.api_cafeSoluble.service;

import com.ni.edu.uam.api_cafeSoluble.models.Producto;
import com.ni.edu.uam.api_cafeSoluble.repository.IProductoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProductoService implements IProductoService {

    private final IProductoRepository productoRepository;

    public ProductoService(IProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    @Override
    public Producto findById(Long id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado con el id: " + id));
    }

    @Override
    public Producto save(Producto producto) {
        if (producto == null) {
            return null;
        }
        return productoRepository.save(producto);
    }

    @Override
    public Boolean deleteById(Long id) {
        if (productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
            return true;
        }
        return false;
    }


}