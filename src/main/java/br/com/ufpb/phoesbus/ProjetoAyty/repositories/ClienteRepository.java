package br.com.ufpb.phoesbus.ProjetoAyty.repositories;

import br.com.ufpb.phoesbus.ProjetoAyty.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByEmail(String email);
}