package com.example.gerenciamento_processos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gerenciamento_processos.entity.Processo;
import com.example.gerenciamento_processos.service.ProcessoService;

@RestController
@RequestMapping("/api/processos")
public class ProcessoController {
    @Autowired
    private ProcessoService processoService;

    
    @GetMapping
    public ResponseEntity<List<Processo>> getAllProcessos() {
        List<Processo> processos = processoService.findAll();
        return ResponseEntity.ok(processos);
    }

    @PostMapping
    public ResponseEntity<Processo> createProcesso(@RequestBody Processo processo) {
        Processo savedProcesso = processoService.save(processo);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProcesso);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Processo> updateProcesso(@PathVariable Long id, @RequestBody Processo processo) {
        if (!processoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        processo.setId(id);
        Processo updatedProcesso = processoService.save(processo);
        return ResponseEntity.ok(updatedProcesso);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProcesso(@PathVariable Long id) {
        if (!processoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        processoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Processo> getProcessoById(@PathVariable Long id) {
        return processoService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Novo método para buscar por número
    @GetMapping("/numero/{numero}")
    public ResponseEntity<?> getProcessoByNumero(@PathVariable String numero) {
        Optional<Processo> processo = processoService.findByNumero(numero);
        
        if (processo.isPresent()) {
            return ResponseEntity.ok(processo.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Processo não encontrado para o número: " + numero);
        }
    }

}
