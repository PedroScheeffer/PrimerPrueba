package com.arbol_binario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TElementoABTest {

    private TElementoAB<Integer> elemento;
    private TElementoAB<Integer> raiz;

    @BeforeEach
    public void setUp() {
        raiz = new TElementoAB<>(5, 100);
    }

    @Test
    public void testInsertarVacio() {
        elemento = new TElementoAB<>(3, 50);
        assertTrue(raiz.insertar(elemento));
    }

    @Test
    public void testInsertarExistente() {
        elemento = new TElementoAB<>(5, 100);
        assertFalse(raiz.insertar(elemento));
    }

    @Test
    public void testInsertarIzquierda() {
        elemento = new TElementoAB<>(3, 50);
        raiz.insertar(elemento);
        assertEquals(elemento, raiz.getHijoIzq());
    }

    @Test
    public void testInsertarDerecha() {
        elemento = new TElementoAB<>(7, 150);
        raiz.insertar(elemento);
        assertEquals(elemento, raiz.getHijoDer());
    }

    @Test
    public void testBalancearDesbalanceadoIzquierda() {
        TElementoAB<Integer> nodo3 = new TElementoAB<>(3, null);
        TElementoAB<Integer> nodo2 = new TElementoAB<>(2, null);

        raiz.insertar(nodo3);
        nodo3.insertar(nodo2);

        raiz.balancear(raiz);

        // Suponiendo que rotacionLL o rotacionLR ajustan correctamente la estructura
        // Aquí deberías comprobar que el árbol está ahora balanceado.
        // Esto puede depender de cómo hayas implementado las funciones de rotación.
    }

    @Test
    public void testBalancearDesbalanceadoDerecha() {
        TElementoAB<Integer> nodo7 = new TElementoAB<>(7, null);
        TElementoAB<Integer> nodo8 = new TElementoAB<>(8, null);

        raiz.insertar(nodo7);
        nodo7.insertar(nodo8);

        raiz.balancear(raiz);

        // Aquí también deberías comprobar que el árbol está ahora balanceado.
    }

    @Test
    public void testBalancearBalanceado() {
        TElementoAB<Integer> nodo3 = new TElementoAB<>(3, null);
        TElementoAB<Integer> nodo7 = new TElementoAB<>(7, null);

        raiz.insertar(nodo3);
        raiz.insertar(nodo7);

        raiz.balancear(raiz);

        // Aquí podrías comprobar que la estructura del árbol no ha cambiado,
        // ya que estaba balanceado para empezar.
    }
}
