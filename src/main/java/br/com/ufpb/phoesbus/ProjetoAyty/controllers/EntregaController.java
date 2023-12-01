package br.com.ufpb.phoesbus.ProjetoAyty.controllers;

import br.com.ufpb.phoesbus.ProjetoAyty.domain.Entrega;
import br.com.ufpb.phoesbus.ProjetoAyty.repositories.EntregaRepository;
import br.com.ufpb.phoesbus.ProjetoAyty.services.EntregaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
public class EntregaController {
    private EntregaRepository entregaRepository;
    private EntregaService entregaService;
    @GetMapping("/listarEntregas")
    public List<Entrega> listar(){
        return entregaRepository.findAll();
    }
    @GetMapping("/buscarEntregas/{id}")
    public ResponseEntity<Entrega> buscar(@PathVariable Long id){
        return entregaRepository.findById(id)
                .map(ResponseEntity :: ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping("/entregas")
    @ResponseStatus(HttpStatus.CREATED)
    public Entrega solicitar(@Valid @RequestBody Entrega entrega){
        return entregaService.solicitar(entrega);
    }

}
