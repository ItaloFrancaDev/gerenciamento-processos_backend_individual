package com.example.gerenciamento_processos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gerenciamento_processos.entity.Processo;


public interface ProcessoRepository extends JpaRepository<Processo, Long> {
   
	Optional<Processo> findByNumero(String numero);
}
