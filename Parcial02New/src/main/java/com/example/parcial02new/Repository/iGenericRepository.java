package com.example.parcial02new.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface iGenericRepository <T, ID> extends JpaRepository<T,ID> {

    default  public T findByIdOrThrow(ID id) throws Exception {
        return findById(id).orElseThrow(() -> new Exception("Entity not found with id: " + id));
    }

}
