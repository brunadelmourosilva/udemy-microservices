package br.com.brunadelmouro.msclientes.service;

import br.com.brunadelmouro.msclientes.infra.repository.ClienteRepository;
import br.com.brunadelmouro.msclientes.model.Cliente;
import lombok.RequiredArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Transactional
    public Cliente saveCustomer(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente findByCpf(String cpf) {
        Optional<Cliente> cliente = clienteRepository.findByCpf(cpf);

        return cliente.orElseThrow(() ->  new ObjectNotFoundException(1, "Not Found"));
    }

}
