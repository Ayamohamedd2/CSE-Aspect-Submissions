package com.example.demo.Controlllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/data")
public class Controller {

    @GetMapping
    public String getData() {
        return "GET response";
    }

    @PostMapping
    public String postData() {
        return "POST response";
    }

    @PutMapping
    public String putData() {
        return "PUT response";
    }

    @DeleteMapping
    public String deleteData() {
        return "DELETE response";
    }


}

