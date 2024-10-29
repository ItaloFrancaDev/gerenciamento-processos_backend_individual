package com.example.gerenciamento_processos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gerenciamento_processos.entity.Acao;

public interface AcaoRepository extends JpaRepository<Acao, Long> {

}
