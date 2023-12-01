package br.com.ufpb.phoesbus.ProjetoAyty.services;

import br.com.ufpb.phoesbus.ProjetoAyty.domain.Cliente;
import br.com.ufpb.phoesbus.ProjetoAyty.domain.Entrega;
import br.com.ufpb.phoesbus.ProjetoAyty.domain.StatusEntrega;
import br.com.ufpb.phoesbus.ProjetoAyty.domain.exception.EntidadeNaoEncontradaException;
import br.com.ufpb.phoesbus.ProjetoAyty.repositories.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;

@Service
@AllArgsConstructor
public class EntregaService {

    private EntregaRepository entregaRepository;
    private CRUDClienteService crudClienteService;
    @Transactional
    public Entrega solicitar(Entrega entrega){
        Cliente cliente = crudClienteService.buscar(entrega.getCliente(), entrega.getId());
        entrega.setCliente(cliente);
        entrega.setStatusEntrega(StatusEntrega.PENDENTE);
        entrega.setDataPedido(OffsetDateTime.now());
        return entregaRepository.save(entrega);
    }
    @Transactional
    public Entrega buscar (Long id){
        return entregaRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não encontrada!"));
    }
}
