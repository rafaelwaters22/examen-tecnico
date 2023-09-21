package com.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examen.entity.History;
@Repository
public interface HistoryRepository extends JpaRepository<History, Integer> {

}
