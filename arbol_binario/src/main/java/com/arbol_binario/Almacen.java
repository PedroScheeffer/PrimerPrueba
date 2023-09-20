package com.arbol_binario;

import java.io.Console;



public class Almacen implements IAlmacen{

    private String nombre;
    private Lista<IProducto> listaProductos;
    private long stock;
    private String dirrecion;
    private String telefono;

    public Almacen(String nombre){
        this.nombre = nombre;
        this.listaProductos = new Lista<IProducto>();
        this.stock = 0;
    }
    @Override
    public String getDireccion() {
        return dirrecion;
    }

    @Override
    public void setDireccion(String direccion) {
        this.dirrecion = direccion;
    }

    @Override
    public String getTelefono() {
        return telefono;
    }

    @Override
    public void setTelefono(String _telefono) {
        this.telefono = _telefono;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public Lista<IProducto> getListaProductos() {
        return listaProductos;
    }

    @Override
    public long obtenerValorStock() {
        return stock;
    }

    @Override
    public void insertarProducto(IProducto unProducto) {
        listaProductos.insertar(
            new Nodo<IProducto>(unProducto.getCodProducto(), unProducto)
        );
    }

    @Override
    public boolean eliminarProducto(Comparable codProducto) {
        return listaProductos.eliminar(codProducto);
    }

    @Override
    public String imprimirProductos() {
        return listaProductos.imprimir();
    }

    @Override
    public String imprimirSeparador(String separador) {
        return listaProductos.imprimir(separador);
    }

    @Override
    public Boolean agregarStock(Comparable codProducto, Integer cantidad) {
        IProducto producto = buscarPorCodigo(codProducto);
        if(producto == null){
            return false;
        }
        producto.agregarCantidadStock(cantidad);
        return true;
    }

    @Override
    public Integer restarStock(Comparable codProducto, Integer cantidad) {
        IProducto producto = buscarPorCodigo(codProducto);
        if(producto == null){
            return 0;
        }
        producto.restarCantidadStock(cantidad);
        return producto.getStock();
    }

    @Override
    public IProducto buscarPorCodigo(Comparable codProducto) {
        return listaProductos.buscar(codProducto).getDato();
    }

    @Override
    public String listarOrdenadoPorNombre() {
            // armar la lista denuevo pero ordenada por nombre e imprimir
            Lista<IProducto> listaOrdenada = new Lista<>();
            Nodo<IProducto> actual = listaProductos.getPrimero();
            while (actual != null) {
                IProducto producto = actual.getDato();
                if(producto.getNombre() == null){
                    System.out.println(
                        producto.getCodProducto() +  " no tiene nombre"
                        );
                    break;
                }
                Nodo<IProducto> nuevoNodo = new Nodo<>(producto.getNombre(), producto);
                listaOrdenada.insertarOrdenado(nuevoNodo);
                actual = actual.getSiguiente();
            }
            return listaOrdenada.imprimir("\n");

    }


    @Override
    public IProducto buscarPorDescripcion(String descripcion) {
        if(listaProductos.getPrimero() == null){
            return null;
        }
        Nodo<IProducto> actual = listaProductos.getPrimero(); 
        while (actual != null) {
            if(actual.getDato().getDescripcion().compareTo(descripcion) == 0){
                return actual.getDato();
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    @Override
    public int cantidadProductos() {
        return listaProductos.cantElementos();
    }
    
}
