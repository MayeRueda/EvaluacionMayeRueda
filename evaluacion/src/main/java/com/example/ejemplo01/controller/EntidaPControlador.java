package com.example.ejemplo01.controller;
import com.example.ejemplo01.entidad.EntidadP;
import com.example.ejemplo01.service.EntidadPServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@CrossOrigin(origins = "http://127.0.0.1:5500")

public class EntidaPControlador {

    private final EntidadPServicio productoServicio;

    public EntidaPControlador(EntidadPServicio productoServicio) {
        this.productoServicio = productoServicio;
    }

    @GetMapping("/listarproductos")
    public ResponseEntity<List<EntidadP>> listar() {
        List<EntidadP> listar = productoServicio.listarproductos();
        return new ResponseEntity<>(listar, HttpStatus.OK);
    }

    @GetMapping("/buscarproducto/{referencia}")
    public ResponseEntity<EntidadP> buscarproducto(@PathVariable String referencia) {
        EntidadP ent = EntidadPServicio.buscarproducto(referencia);
        if (ent != null) {
            return new ResponseEntity<>(ent, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/eliminarproducto/{categoria}")
    public ResponseEntity<String> eliminarproducto(@PathVariable String categoria) {
        if (EntidadPServicio.buscarcategoria(categoria)) {
            EntidadPServicio.eliminarproducto(categoria);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("se elimino el producto");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Se elimino");
        }
    }

    @PutMapping("/actualizarproductos/{referencia}")
    public ResponseEntity<Void> actualizarproductos(@PathVariable String referencia, @RequestBody EntidadP entidadP) {
        EntidadP productoExistente = EntidadPServicio.buscarproducto(referencia);
        if (productoExistente != null) {
            // Actualizar los datos del producto existente con los valores proporcionados
            productoExistente.setNombre(entidadP.getNombre());
            productoExistente.setCategoria(entidadP.getCategoria());
            productoExistente.setPreciounitario(entidadP.getPreciounitario());
            productoExistente.setCantidad(entidadP.getCantidad());


            EntidadPServicio.actualizarproductos(productoExistente);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    }