package com.postgresspring.Service;

import org.springframework.stereotype.Service;

import com.postgresspring.Repository.AppRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AppServiceImpl implements AppService {

    AppRepository appRepository;

    public String message(String firstName) {
        return appRepository.message(firstName);
    }
}
