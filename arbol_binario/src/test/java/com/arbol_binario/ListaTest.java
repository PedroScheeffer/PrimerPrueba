package com.arbol_binario;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ListaTest {

    @Test
    public void testInsertarOrdenado() {
        Lista<Integer> lista = new Lista<>();
        
        // Test 1: Insertar en lista vacía
        Nodo<Integer> nodo1 = new Nodo<>(3, 3);
        lista.insertarOrdenado(nodo1);
        assertEquals(3, lista.getPrimero().getDato()); // Asumo que tienes un método getPrimero()
        
        // Test 2: Insertar al principio
        Nodo<Integer> nodo2 = new Nodo<>(1, 1);
        lista.insertarOrdenado(nodo2);
        assertEquals(1, lista.getPrimero().getDato());
        
        // Test 3: Insertar al final
        Nodo<Integer> nodo3 = new Nodo<>(4, 4);
        lista.insertarOrdenado(nodo3);
        // Aquí debes verificar que el último nodo tenga el dato 4
        
        // Test 4: Insertar en medio
        Nodo<Integer> nodo4 = new Nodo<>(2, 2);
        lista.insertarOrdenado(nodo4);
        // Aquí debes verificar que el nodo con el dato 2 esté en la posición correcta
    }
    @Test
    public void testEliminarNodo(){
        Lista<Integer> lista = new Lista<>();

        Nodo <
    }
}
