package com.arbol_binario;

public class Producto implements IProducto {
    private String nombre;
    private Comparable id;
    private int precio;
    private int stock;
    private String descripcion;
    
    public Producto( Comparable codigo){
        this.id = codigo;
    }
    public Producto( Comparable codigo, String nombre){
        this.id = codigo;
        this.nombre = nombre;
    }
    @Override
    public Comparable getCodProducto() {
        return id;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    @Override
    public Integer getPrecio() {
        return precio;
    }

    @Override
    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    @Override
    public Integer getStock() {
        return stock;
    }

    @Override
    public void agregarCantidadStock(Integer stock) {
        this.stock += stock.intValue();
    }

    @Override
    public void restarCantidadStock(Integer stock) {
        if(stock.intValue() >= this.stock){
            throw new IllegalArgumentException("resta mayor que stock");
        } 
        this.stock -= stock.intValue();
        
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
