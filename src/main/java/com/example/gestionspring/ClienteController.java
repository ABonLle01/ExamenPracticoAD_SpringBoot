package com.example.gestionspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Controller
@RestController
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    private ClientesRepository r;

    @PostMapping("/post")
    public ResponseEntity<Cliente> nuevoCliente(@RequestBody Cliente c){
        return new ResponseEntity<>(r.save(c), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Cliente getCliente(@PathVariable Long id){
        return r.getClienteById(id);
    }

    @GetMapping("/total/{cantidad}")
    public List<Cliente> getMejoresClientes(@PathVariable Long cantidad, @RequestBody String estado){
        if(Objects.equals(estado.toLowerCase(), "activo"))
            return r.getClientesByTotalGreaterThan(cantidad);
        else
            return null;

    }


}
