package br.com.ufpb.phoesbus.ProjetoAyty.controllers;

import br.com.ufpb.phoesbus.ProjetoAyty.domain.Cliente;
import br.com.ufpb.phoesbus.ProjetoAyty.repositories.ClienteRepository;
import br.com.ufpb.phoesbus.ProjetoAyty.services.CRUDClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
public class ClienteController {

    private ClienteRepository clienteRepository;
    private CRUDClienteService crudClienteService;
    @GetMapping("/listarClientes")
    public ResponseEntity<List<Cliente>> findAll(){
        List<Cliente> clientes = crudClienteService.findAll()
                .stream()
                .map(cliente -> new Cliente(
                        cliente.getId(),
                        cliente.getNome(),
                        cliente.getEmail(),
                        cliente.getTelefone()))
                .toList();
        return ResponseEntity.ok(clientes);
    }
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Cliente> buscar(@PathVariable Long id){
        return clienteRepository.findById(id)
                .map(ResponseEntity :: ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping("/cadastrarCliente")
    public ResponseEntity<Cliente> cadastrar(@Valid @RequestBody Cliente cliente){
        Cliente client = cliente.toEntity();
        client = crudClienteService.salvar(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(new Cliente(
                client.getId(),
                client.getNome(),
                client.getEmail(),
                client.getTelefone()));
    }
    @DeleteMapping("/deletarCliente/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id){
        if(!clienteRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        crudClienteService.deletar(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id, @Valid @RequestBody Cliente cliente){
        if(!clienteRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        cliente.setId(id);
        cliente = crudClienteService.salvar(cliente);
        return ResponseEntity.ok(cliente);
    }

}
