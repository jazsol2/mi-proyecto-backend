package com.clientes.clientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.clientes.clientes.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findByCi(String ci);
}
