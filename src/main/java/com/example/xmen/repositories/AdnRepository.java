package com.example.xmen.repositories;

import com.example.xmen.entities.Adn;
import org.springframework.stereotype.Repository;

@Repository
public interface AdnRepository extends BaseRepository<Adn, Long>{
    public long countBymutanteTrue();
    public long countBymutanteFalse();
}
