package api.adocao.repository;

import api.adocao.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdocaoRepository extends JpaRepository<Adocao, Integer> {
}
