package com.example.gerenciamento_processos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gerenciamento_processos.entity.Processo;
import com.example.gerenciamento_processos.repository.ProcessoRepository;

@Service
public class ProcessoService {
    @Autowired
    private ProcessoRepository processoRepository;

    public List<Processo> findAll() {
        return processoRepository.findAll();
    }

    public Optional<Processo> findByNumero(String numero) {
        return processoRepository.findByNumero(numero);
    }
    
    public Processo save(Processo processo) {
        return processoRepository.save(processo);
    }

    public Optional<Processo> findById(Long id) {
        return processoRepository.findById(id);
    }

    public void delete(Long id) {
        processoRepository.deleteById(id);
    }
    
}
