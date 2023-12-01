package br.com.ufpb.phoesbus.ProjetoAyty.services;

import br.com.ufpb.phoesbus.ProjetoAyty.domain.Entrega;
import br.com.ufpb.phoesbus.ProjetoAyty.domain.Ocorrencia;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class OcorrenciaService {
    public EntregaService entregaService;
    @Transactional
    public Ocorrencia registrar(Long id, String descricao){
        Entrega entrega = entregaService.buscar(id);
        return entrega.adicionarOcorrencia(descricao);
    }
}
