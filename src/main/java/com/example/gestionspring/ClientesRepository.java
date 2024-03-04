package com.example.gestionspring;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientesRepository extends JpaRepository<Cliente, Long> {

    public Cliente getClienteById(Long id);

    public List<Cliente> getClientesByTotalGreaterThan(Long cantidad);

}
