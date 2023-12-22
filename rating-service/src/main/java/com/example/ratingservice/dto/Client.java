package com.example.ratingservice.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Client {
        private Long id;
        private String name;
        private float age;


}
