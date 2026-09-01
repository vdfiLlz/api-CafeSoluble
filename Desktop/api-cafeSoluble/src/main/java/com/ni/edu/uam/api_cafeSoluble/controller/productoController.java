package com.ni.edu.uam.api_cafeSoluble.controller;

import com.ni.edu.uam.api_cafeSoluble.models.Producto;
import com.ni.edu.uam.api_cafeSoluble.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class productoController {

    @Autowired
    private IProductoService productoService;

    @GetMapping("/productos")
    public ResponseEntity<List<Producto>> getAll() {
        return ResponseEntity.ok(productoService.findAll());
    }

    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> findById(@PathVariable("id") Long id) {
        Producto producto = productoService.findById(id);
        if (producto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(producto);
    }

    @PostMapping("/productos")
    public ResponseEntity<Producto> save(@RequestBody Producto producto) {
        Producto nuevo = productoService.save(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }
}