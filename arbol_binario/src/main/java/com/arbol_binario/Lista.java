package com.arbol_binario;

public class Lista<T> implements ILista<T> {

    private Nodo<T> primero;

    public Lista() {
        primero = null;
    }

    @Override
    public void insertar(Nodo<T> nodo) {
        if (nodo == null || nodo.getSiguiente() != null) {
            throw new IllegalArgumentException("El nodo ya esta en otra lista");
        }
        if (primero == null) {
            primero = nodo;
        } else {
            nodo.setSiguiente(primero);
            primero = nodo;
        }
    }

    // insercion ordenada tengo que usar el metodo de insertar, donde tomo el
    // elemento y lo
    // pongo en la posicion correcta de la lista
    // para esto recorro la lista nueva comparando etiqueta
    // al encontrar la pos, lo inserto atras del mayor
    public void insertarOrdenado(Nodo<T> nodoaInsertar) {
        if (nodoaInsertar == null || nodoaInsertar.getSiguiente() != null) {
            throw new IllegalArgumentException("El nodo ya esta en otra lista");
        }
        if (primero == null) {
            primero = nodoaInsertar;
            return;
        }
        Nodo<T> actual = primero;
        Nodo<T> anterior = null;
        while (actual != null) {
            if (nodoaInsertar.getEtiqueta().compareTo(actual.getEtiqueta()) <= 0) {
                if (anterior == null) {
                    nodoaInsertar.setSiguiente(actual);
                    primero = nodoaInsertar;
                    return;
                } else {
                    nodoaInsertar.setSiguiente(actual);
                    anterior.setSiguiente(nodoaInsertar);
                    return;
                }
            }
            anterior = actual;
            actual = actual.getSiguiente();
        }
        anterior.setSiguiente(nodoaInsertar);
    }

    @Override
    public Nodo<T> buscar(Comparable clave) {
        Nodo<T> nodoActual = primero;
        while (nodoActual != null) {
            if (nodoActual.getEtiqueta().equals(clave)) {
                return nodoActual;
            }
            nodoActual = nodoActual.getSiguiente();
        }
        return null;
    }

    public Nodo<T> getPrimero() {
        return primero;
    }

    /* Recorro la lista y cuando encuentro el nodo tomo la referencia a el y le doy al siguiente */
    @Override
    public boolean eliminar(Comparable clave) {
        if(getPrimero() == null){
            return false;
        }
        Nodo<T> nodoActual = getPrimero();
        Nodo<T> nodoAnterior = null;
        while (nodoActual != null) {
            if(nodoActual.getEtiqueta().compareTo(clave) == 0){
                nodoAnterior.setSiguiente(nodoActual.getSiguiente());
                return true;
            }
            nodoAnterior = nodoActual;
            nodoActual = nodoActual.getSiguiente();
        }
        return true;
    }

    @Override
    public String imprimir() {
        StringBuilder result = new StringBuilder();
        if(primero == null){
            return "";
        }
        Nodo <T> actual = getPrimero();
        while (actual != null) {
            result.append(actual.getEtiqueta().toString());
            actual = actual.getSiguiente();
        }
        return result.toString();
    }

    @Override
    public String imprimir(String separador) {
        StringBuilder result = new StringBuilder();
        if(primero == null){
            return "";
        }
        Nodo <T> actual = getPrimero();
        while (actual != null) {
            result.append(actual.getEtiqueta().toString());
            actual = actual.getSiguiente();
            if(actual != null){
                result.append(separador);
            }
        }
        return result.toString();
    }

    @Override
    public int cantElementos() {
        if(primero == null){
            return 0;
        }
        int contador = 0;
        Nodo<T> actual = getPrimero();
        while(actual != null){
            contador++;
            actual = actual.getSiguiente();
        }
        return contador;
    }

    @Override
    public boolean esVacia() {
        return primero == null;
    }

    @Override
    public void setPrimero(Nodo<T> unNodo) {
        primero = unNodo;
    }

    // implementar los metodos indicados en la interfaz
}
