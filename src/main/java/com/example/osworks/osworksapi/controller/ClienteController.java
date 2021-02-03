package com.example.osworks.osworksapi.controller;

import com.example.osworks.osworksapi.model.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ClienteController {

    @GetMapping("/clientes")
    public List<Cliente> listar() {
        var cliente1 = new Cliente();
        var cliente2 = new Cliente();

        cliente1.setId(1L);
        cliente1.setNome("Pedro");
        cliente1.setEmail("pedrolf30@gmail.com");
        cliente1.setTelefone("997958007");

        cliente2.setId(2L);
        cliente2.setNome("Samuel");
        cliente2.setEmail("samuka.cezar@hotmail.com");
        cliente2.setTelefone("998884743");

        return Arrays.asList(cliente1,cliente2);
    }
}
