package com.example.blockchain.persistence.repository;

import com.example.blockchain.entity.Block;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BlockRepository extends CrudRepository<Block, Long> {
    Optional<Block> findById(long id);
    Optional<Block> findFirstByOrderByIdDesc();
}
