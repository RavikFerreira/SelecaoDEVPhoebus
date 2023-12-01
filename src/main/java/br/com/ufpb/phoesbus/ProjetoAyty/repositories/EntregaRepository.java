package br.com.ufpb.phoesbus.ProjetoAyty.repositories;

import br.com.ufpb.phoesbus.ProjetoAyty.domain.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long> {
}
