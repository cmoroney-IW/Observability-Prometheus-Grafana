package com.postgresspring.Web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.postgresspring.Service.AppServiceImpl;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class AppController {

    AppServiceImpl appService;

    @GetMapping("/")
    public ResponseEntity<String> welcomeMessage() {
        return new ResponseEntity<>("Hello unnamed user!", HttpStatus.OK);
    }

    @GetMapping("/message/{firstName}")
    public ResponseEntity<String> getMessage(@PathVariable String firstName) {
        return new ResponseEntity<>(appService.message(firstName), HttpStatus.OK);
    }

}
