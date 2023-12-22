package com.example.ratingservice.response;

import com.example.ratingservice.dto.Client;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FullCarResponse {
    private Long id;
    private String brand;
    private String model;
    private String matricule;
    private Client client;

}
