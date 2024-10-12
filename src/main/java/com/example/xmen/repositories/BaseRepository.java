package com.example.xmen.repositories;

import com.example.xmen.entities.Base;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;


import java.io.Serializable;

@NoRepositoryBean //no crea instancias de este
public interface BaseRepository <E extends Base, ID extends Serializable> extends JpaRepository<E, ID> {


}
