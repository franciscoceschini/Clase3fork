package edu.uca;

import java.lang.reflect.AnnotatedParameterizedType;

public class Producto {
    private int id;
    private String nombre;
    private double precio;
    private String size;
    private String material;
    private String ropa;
    private double warranty;
    private String electrodomestico;

    public Producto(int id, String nombre, double precio, String size, String material, String ropa, double warranty, String electrodomestico) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.size = size;
        this.material = material;
        this.ropa = ropa;
        this.warranty = warranty;
        this.electrodomestico = electrodomestico;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }

    public double getPrecioFinal() {
        return precio;
    }

    @Override
    public String toString() {
        return "Producto{id=" + id + ", nombre='" + nombre + "', precio=" + precio + ", tamaño='" + size + "', material='" + material + "', garantía=" + warranty + "}";
    }


}
