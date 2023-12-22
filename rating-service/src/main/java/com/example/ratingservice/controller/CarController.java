package com.example.ratingservice.controller;

import com.example.ratingservice.model.Car;
import com.example.ratingservice.response.FullCarResponse;
import com.example.ratingservice.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cars/car")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @PostMapping
    public Car save(@RequestBody Car rating) {
        return carService.save(rating);
    }

    @GetMapping(path ="/{id}")
    public ResponseEntity<FullCarResponse> findById(@PathVariable("id") Long id) {

        return ResponseEntity.of(carService.findById(id));
    }

    @DeleteMapping
    public void delete(@RequestBody Car entity) {
        carService.delete(entity);
    }

    @GetMapping
    public ResponseEntity<List<FullCarResponse>> findAll() {

        return ResponseEntity.ok(carService.findAll());
    }

}
