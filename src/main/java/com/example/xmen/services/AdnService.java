package com.example.xmen.services;

import com.example.xmen.entities.Adn;
import java.util.Map;

public interface AdnService extends BaseService<Adn, Long>{
    boolean isMutant(String[] adnSequence);
    public Map<String,Object > getStats = Map.of();

}

