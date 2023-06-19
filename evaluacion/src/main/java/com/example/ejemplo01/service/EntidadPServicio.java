package com.example.ejemplo01.service;


import com.example.ejemplo01.entidad.EntidadP;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")

@Service
public class EntidadPServicio {


    private static List<EntidadP> p = new ArrayList<>();
    public EntidadPServicio() {
        p.add(new EntidadP("S127181", "Zapato", "utileria", 22000, 3));
        p.add(new EntidadP("A1829g", "manzana", "frutas", 2000, 1));
        p.add(new EntidadP("R16281", "arroz", "despenza", 3000, 2));
        p.add(new EntidadP("P82910", "pera", "frutas", 1200, 6));
        p.add(new EntidadP("c02818", "camisa", "utileria", 12000, 8));

    }

    public static List<EntidadP> listarproductos() {

        return p;
    }
    public static EntidadP buscarproducto(String referencia) {
        for (EntidadP ent : listarproductos()) {
            if (ent.getReferencia().equals(referencia)) {
                return ent;
            }
        }
        return null;
    }
    public static boolean  buscarcategoria(String categoria) {
        boolean existe = false;
        for (EntidadP ent : listarproductos()) {
            if (ent.getCategoria().equals(categoria)) {
                existe=true;
                break;

            }
        }
return existe;
    }


        public static void eliminarproducto(String categoria) {
            List<EntidadP> copia = new ArrayList<>(p);
            for (EntidadP e : copia) {
                if (e.getCategoria().equals(categoria)) {
                    p.remove(e);
                }
            }
        }
    public static void actualizarproductos(String referencia, EntidadP entidadP) {
        for (EntidadP p : listarproductos()) {
            if (p.getReferencia().equals(referencia)) {
                p.setNombre(entidadP.getNombre());
                p.setCategoria(entidadP.getCategoria());
                p.setPreciounitario(entidadP.getPreciounitario());
                p.setCantidad(entidadP.getCantidad());

                return;
            }
        }
    }

    public static void actualizarproductos(EntidadP productoExistente) {
    }
}


