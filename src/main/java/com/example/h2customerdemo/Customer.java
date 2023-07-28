package com.example.h2customerdemo;

import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;


public record Customer(@Id Integer id, String firstName, String lastName, String address, String phoneNumber, String email) {

}
