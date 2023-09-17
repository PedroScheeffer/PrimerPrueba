package com.arbol_binario;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AlmacenTest {
    @Test
    public void testImprimirOrdenado(){
        // Arrange
        Almacen almacen =  new Almacen("pepitos");
        Producto producto1 = new Producto(1,"1");
        Producto producto2 = new Producto(2,"2");
        Producto producto3 = new Producto(3,"3");
        almacen.insertarProducto(producto2);
        almacen.insertarProducto(producto3);
        almacen.insertarProducto(producto1);
        // Act 
        String actual = almacen.listarOrdenadoPorNombre();
        String expected = "1\n2\n3";
        // Asert
        assertEquals(expected, actual);
    }
}
