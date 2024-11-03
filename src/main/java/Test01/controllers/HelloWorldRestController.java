package Test01.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldRestController {

//    @GetMapping("/hello")
//    public String helloWorld(){
//        return "Hello world";
//    }

    @GetMapping({"/hello", "/hw", "/hola"})
    public String helloWorld(){
        return "Hello world";
    }

}
