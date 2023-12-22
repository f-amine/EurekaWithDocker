package com.example.ratingservice.service;


import com.example.ratingservice.client.ClientFeign;
import com.example.ratingservice.dto.Client;
import com.example.ratingservice.model.Car;
import com.example.ratingservice.repository.CarRepository;
import com.example.ratingservice.response.FullCarResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;
    private final ClientFeign clientFeign;
    public Car save(Car rating) {
        return carRepository.save(rating);
    }

    public Optional<FullCarResponse> findById(Long id) {
        Optional<Car> carOptional = carRepository.findById(id);
        if (carOptional.isPresent()) {
            Car car = carOptional.get();
            Client client = clientFeign.findById(car.getClientId());
            FullCarResponse fullCarResponse = FullCarResponse.builder()
                    .id(car.getId())
                    .brand(car.getBrand())
                    .model(car.getModel())
                    .matricule(car.getMatricule())
                    .client(client)
                    .build();
            return Optional.of(fullCarResponse);
        }
        return Optional.empty();
    }
    public void delete(Car entity) {
        carRepository.delete(entity);
    }

    public List<FullCarResponse> findAll() {
        List<Car> cars= carRepository.findAll();
        List<FullCarResponse> fullCarResponses = new ArrayList<>();
        for (Car car : cars) {
            Client client = clientFeign.findById(car.getClientId());
            FullCarResponse fullCarResponse = FullCarResponse.builder()
                    .id(car.getId())
                    .brand(car.getBrand())
                    .model(car.getModel())
                    .matricule(car.getMatricule())
                    .client(client)
                    .build();
            fullCarResponses.add(fullCarResponse);
        }
        return fullCarResponses;
    }

}
