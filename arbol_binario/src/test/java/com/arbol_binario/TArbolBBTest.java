package com.arbol_binario;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TArbolBBTest {

    @Test
    public void testInsertar() {
        TArbolBB<Integer> arbol = new TArbolBB<>();
        TElementoAB<Integer> elemento1 = new TElementoAB<>(5, 100);
        TElementoAB<Integer> elemento2 = new TElementoAB<>(3, 50);

        assertTrue(arbol.insertar(elemento1));
        assertTrue(arbol.insertar(elemento2));

        assertEquals(elemento1, arbol.buscar(5));
        assertEquals(elemento2, arbol.buscar(3));
    }

    @Test
    public void testInsertarBalanceado() {
        TArbolBB<Integer> arbol = new TArbolBB<>();
        TElementoAB<Integer> elemento1 = new TElementoAB<>(5, 100);
        TElementoAB<Integer> elemento2 = new TElementoAB<>(3, 50);
        TElementoAB<Integer> elemento3 = new TElementoAB<>(7, 150);

        assertTrue(arbol.insertarBalanceado(elemento1));
        assertTrue(arbol.insertarBalanceado(elemento2));
        assertTrue(arbol.insertarBalanceado(elemento3));

        assertEquals(elemento1, arbol.buscar(5));
        assertEquals(elemento2, arbol.buscar(3));
        assertEquals(elemento3, arbol.buscar(7));
    }

    @Test
    public void testEliminar() {
        TArbolBB<Integer> arbol = new TArbolBB<>();
        TElementoAB<Integer> elemento1 = new TElementoAB<>(5, 100);
        TElementoAB<Integer> elemento2 = new TElementoAB<>(3, 50);
    
        arbol.insertar(elemento1);
        arbol.insertar(elemento2);
    
        // Llama al método de eliminar de TArbolBB
        arbol.eliminar(5);
    
        // Verifica que el elemento se haya eliminado correctamente del árbol
        assertEquals(elemento1,arbol.buscar(5));
        assertEquals(elemento2, arbol.buscar(3));
    }
    

    @Test
    public void testAlturaArbol() {
        TArbolBB<Integer> arbol = new TArbolBB<>();
        TElementoAB<Integer> elemento1 = new TElementoAB<>(5, 100);
        TElementoAB<Integer> elemento2 = new TElementoAB<>(3, 50);
        TElementoAB<Integer> elemento3 = new TElementoAB<>(7, 150);

        arbol.insertarBalanceado(elemento1);
        arbol.insertarBalanceado(elemento2);
        arbol.insertarBalanceado(elemento3);

        assertEquals(1, arbol.alturaArbol());
    }

    @Test
    public void testHojasArbol() {
        TArbolBB<Integer> arbol = new TArbolBB<>();
        TElementoAB<Integer> elemento1 = new TElementoAB<>(5, 100);
        TElementoAB<Integer> elemento2 = new TElementoAB<>(3, 50);
        TElementoAB<Integer> elemento3 = new TElementoAB<>(7, 150);

        arbol.insertarBalanceado(elemento1);
        arbol.insertarBalanceado(elemento2);
        arbol.insertarBalanceado(elemento3);

        assertEquals(2, arbol.hojasArbol());
    }
}
