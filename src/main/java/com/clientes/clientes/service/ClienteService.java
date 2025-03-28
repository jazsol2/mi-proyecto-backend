package com.clientes.clientes.service;

import com.clientes.clientes.model.Cliente;
import com.clientes.clientes.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente registrarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente actualizarCliente(Long id, Cliente cliente) {
        Cliente clienteExistente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        clienteExistente.setNombre(cliente.getNombre());
        clienteExistente.setDomicilio(cliente.getDomicilio());
        clienteExistente.setTelefono(cliente.getTelefono());
        clienteExistente.setCorreo(cliente.getCorreo());
        clienteExistente.setFechaNacimiento(cliente.getFechaNacimiento());
        return clienteRepository.save(clienteExistente);
    }

    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Cliente buscarPorCi(String ci) {
        return clienteRepository.findByCi(ci);
    }
}
