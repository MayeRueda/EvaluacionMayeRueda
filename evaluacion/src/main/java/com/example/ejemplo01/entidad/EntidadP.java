package com.example.ejemplo01.entidad;

public class EntidadP {

    public String referencia;
    public String nombre;
    public String categoria;
    public float preciounitario;
    public float cantidad;


    public EntidadP(String referencia, String nombre, String categoria, float preciounitario, float cantidad) {

        this.referencia = referencia;
        this.nombre = nombre;
        this.categoria = categoria;
        this.preciounitario = preciounitario;
        this.cantidad = cantidad;

    }

    public EntidadP(){}

    public EntidadP(String referencia) {
        this.referencia = referencia;
    }

    public static void actualizarproductos(EntidadP entidad) {
    }


    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public float getPreciounitario() {
        return preciounitario;
    }

    public void setPreciounitario(float preciounitario) {
        this.preciounitario = preciounitario;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

}