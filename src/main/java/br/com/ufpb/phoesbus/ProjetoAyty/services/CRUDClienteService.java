package br.com.ufpb.phoesbus.ProjetoAyty.services;
import br.com.ufpb.phoesbus.ProjetoAyty.domain.Cliente;
import br.com.ufpb.phoesbus.ProjetoAyty.domain.exception.NegocioException;
import br.com.ufpb.phoesbus.ProjetoAyty.repositories.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@Service
public class CRUDClienteService {
    private ClienteRepository clienteRepository;
    @Transactional
    public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }
    @Transactional
    public Cliente salvar(Cliente cliente){
        boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
                .stream()
                .anyMatch(clienteExiste -> !clienteExiste.equals(cliente));
        if(emailEmUso){
            throw new NegocioException("Email já esta em uso!");
        }
        if(cliente.getNome() == null){
            throw new RuntimeException("Não aceita nome nulo!");
        }
        return clienteRepository.save(cliente);
    }
    @Transactional
    public Cliente buscar(@Valid @NotNull Cliente cliente, Long id){
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado!"));
    }
    @Transactional
    public void deletar(Long id){
        clienteRepository.deleteById(id);
    }
}
