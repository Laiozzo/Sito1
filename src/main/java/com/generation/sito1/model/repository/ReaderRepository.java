package com.generation.sito1.model.repository;

import com.generation.sito1.model.entities.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReaderRepository extends JpaRepository<Reader, Integer> {
}
