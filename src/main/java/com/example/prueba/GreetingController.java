package com.example.prueba;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

//Clase para Servicio REST - Se define con @RestController
@RestController
//GET POST PUT DELETE

//Define el PATH de nuestro ENDPOINT y le pasamos la ruta de nuestro path
@RequestMapping(value = "greeting")

public class GreetingController {
    private final AtomicLong counter = new AtomicLong(); //variable incremental - (ID)
    private static final String template = "Hello %s"; //plantilla para enviar saludos

    @GetMapping
    //RequestParam captura la variable enviada por la URL, en caso de no recibir valor la palabra por defecto es WORLD
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World")String name ){ //Metodo que envia saludo
        return new Greeting(counter.incrementAndGet(),String.format(template,name)); //instancia de nuestra clase

    }

}
