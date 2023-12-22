package com.example.smarthouseservice.service;


import com.example.smarthouseservice.model.Client;
import com.example.smarthouseservice.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository appareilDao;
    public List<Client> findAll() {
        return appareilDao.findAll();
    }

    public <S extends Client> S save(S entity) {
        return appareilDao.save(entity);
    }

    public Optional<Client> findById(Long aLong) {
        return appareilDao.findById(aLong);
    }

    public void delete(Client entity) {
        appareilDao.delete(entity);
    }

    public void deleteById(Long id) {
        appareilDao.deleteById(id);
    }

}
