package com.ni.edu.uam.api_cafeSoluble.repository;

import com.ni.edu.uam.api_cafeSoluble.models.Producto;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends JpaRepository<Producto,Long> {
}
