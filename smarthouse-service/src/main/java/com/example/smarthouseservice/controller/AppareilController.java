package com.example.smarthouseservice.controller;

import com.example.smarthouseservice.model.Client;
import com.example.smarthouseservice.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clients/client")
@RequiredArgsConstructor
public class AppareilController {


    private final ClientService clientService;

    @GetMapping
    public List<Client> findAll() {
        return clientService.findAll();
    }

    @PostMapping
    public <S extends Client> S save(@RequestBody S entity) {
        return clientService.save(entity);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        clientService.deleteById(id);
    }

    @GetMapping("/{id}")
    public Optional<Client> findById(@PathVariable Long id) {
        return clientService.findById(id);
    }


    @DeleteMapping
    public void delete(@RequestBody Client entity) {
        clientService.delete(entity);
    }

}
