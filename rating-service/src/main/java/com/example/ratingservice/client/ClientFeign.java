package com.example.ratingservice.client;

import com.example.ratingservice.dto.Client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "client-service", url = "${application.config.client-url}/clients/client")
public interface ClientFeign {
    @GetMapping("/{client-id}")
    Client findById(@PathVariable("client-id") Long clientId) ;
}
