package aed;

public class ListaEnlazada<T> {
    private int size;
    private Nodo primero;
    private Nodo ultimo;  
    
    private class Nodo {
        T valor;
        Nodo proximo;
        Nodo anterior;

        public Nodo (T value) {
            this.valor = value;

        }
    }

    public ListaEnlazada() {
         this.size = 0;
    }

    public int longitud() {
        return this.size;
    }

    public void agregarAdelante(T elem) {
        Nodo nuevo = new Nodo(elem);
        if(size == 0){
            // Crea un nodo, lo pone como primero y usa el elemento que se pasa por parámetro del constructor.
            this.primero = nuevo;
            this.ultimo = this.primero;
        } 
        else{
            //En esta parte necesito pensar que tengo dos flechas y no sólo una, por eso tengo que crear dos flechas.
            this.primero.anterior = nuevo;
            nuevo.proximo = primero;
            primero = nuevo;
            
            }

         
size = size + 1;

    }

    public void agregarAtras(T elem) {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public T obtener(int i) {
        //Necesito iterar la lista con un for, donde el primer elemento corresponde a i = 0;
        throw new UnsupportedOperationException("No implementada aun");
    }

    public void eliminar(int i) {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public void modificarPosicion(int indice, T elem) {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        throw new UnsupportedOperationException("No implementada aun");
    }
    
    @Override
    public String toString() {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public class ListaIterador{
        // Completar atributos privados

        public boolean haySiguiente() {
            throw new UnsupportedOperationException("No implementada aun");
        }
        
        public boolean hayAnterior() {
            throw new UnsupportedOperationException("No implementada aun");
        }

        public T siguiente() {
            throw new UnsupportedOperationException("No implementada aun");
        }
        

        public T anterior() {
            throw new UnsupportedOperationException("No implementada aun");
        }
    }

    public ListaIterador iterador() {
        throw new UnsupportedOperationException("No implementada aun");
    }

}

