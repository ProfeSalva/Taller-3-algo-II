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
         this.primero = null;
         this.ultimo = null;
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
            this.primero.anterior = nuevo; // (1)
            // Me importa pensar en el orden, independientemente de la lista, sólo necesito insertar
            // Un elemento adelante del primer elemento, lo que implica que va antes (1), lo que implica que este elemento insertado
            // Será el nuevo primero, de la lista enlazada. (3)

            nuevo.proximo = primero; // (2)

            // Antes de transformar el nuevo elemento en el primero de la lista enlazada (3)
            // Necesito colocar después del nuevo elemento, al que antes era primero (2) 

            primero = nuevo; //(3)
            
            }

         
size = size + 1;

    }

    public void agregarAtras(T elem) {
        Nodo nuevo = new Nodo(elem);
        if(size == 0){
            // Crea un nodo, lo pone como primero y usa el elemento que se pasa por parámetro del constructor.
            this.primero = nuevo;
            this.ultimo = this.primero;
        } 
        else{
            //En esta parte necesito pensar que tengo dos flechas y no sólo una, por eso tengo que crear dos flechas.
            this.ultimo.proximo = nuevo; // (1)
            // Me importa pensar en el orden, independientemente de la lista, sólo necesito insertar
            // Un elemento atrás del último elemento, lo que implica que va después (1), lo que implica que este elemento insertado
            // Será el nuevo último de la lista enlazada. (3)

            nuevo.anterior = ultimo; // (2)

            // Antes de transformar el nuevo elemento en el primero de la lista enlazada (3)
            // Necesito colocar antes del nuevo elemento, al que antes era ultimo (2) 

            ultimo = nuevo; //(3)
            
            }
size = size + 1;
    }

    public T obtener(int i) {
        //Necesito iterar la lista con un for, donde el primer elemento corresponde a i = 0;
        Nodo actual = this.primero;
        int j=0;
        while (actual != null && j<i ) {
            actual = actual.proximo;
            j = j+1;
            
        }
        
        return actual.valor;
    }

    public void eliminar(int i) {
        Nodo actual = this.primero;
        Nodo previo = this.primero;
        int j=0;
        while (actual != null && j<i ) {
            previo = actual;
            actual = actual.proximo;
            j = j+1;
            
            }
            if(i==0){
                primero = actual.proximo;
            }
            else{
                previo.proximo = actual.proximo;
                
            }

        
        size = size -1;


    }

    public void modificarPosicion(int indice, T elem) {
        Nodo actual = this.primero;
        int j=0;
        while (actual != null && j<indice ) {
            actual = actual.proximo;
            j = j+1;
        }
        actual.valor = elem;
    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        ListaEnlazada<T> nuevaLista = new ListaEnlazada<>();
        Nodo actual_lista = lista.primero;
        if(lista.size > 0){
            nuevaLista.agregarAdelante(lista.primero.valor);
            //nuevaLista.primero =  (lista.primero.valor);
            //nuevaLista.ultimo = new Nodo (lista.ultimo.valor);
            //nuevaLista.size = lista.size;
            actual_lista = actual_lista.proximo;
        }
        for(int i=1; i<lista.size;i++){
            
            nuevaLista.agregarAtras(actual_lista.valor);
            actual_lista = actual_lista.proximo;

        }
        this.primero = nuevaLista.primero;
        this.ultimo = nuevaLista.ultimo;
        this.size = nuevaLista.size;
        
    }
    
    @Override
    public String toString() {
        String elementos = "[";
        Nodo actual = this.primero;
        int j=0;
        while (actual != null && j<this.size) {
            if(j != this.size -1){
                elementos = elementos + actual.valor + ", ";
                actual = actual.proximo;
                j = j+1;
            }
            else{
                elementos = elementos + actual.valor + "]";
                j = j+1;
            }
            
            
        }
        return elementos;
        }

     public class ListaIterador{
        private Nodo antes_iterador;
        private Nodo despues_iterador;

        public ListaIterador(){
            this.antes_iterador = null;
            this.despues_iterador = primero;
        }

        public boolean haySiguiente() {
            return despues_iterador != null;
        }
        
        public boolean hayAnterior() {
             return antes_iterador != null;
        }

        public T siguiente() {
            T valor = null;
            if(haySiguiente()){
                antes_iterador = despues_iterador;
                despues_iterador = despues_iterador.proximo;
                valor = antes_iterador.valor;
            }
            return valor;
        }
        

        public T anterior() {
            T valor = null;
             if(hayAnterior()){
                despues_iterador = antes_iterador;
                antes_iterador = antes_iterador.anterior;
                valor = despues_iterador.valor;
            }
            return valor;
        }
    }

    public ListaIterador iterador() {
        ListaIterador nuevoIterador = new ListaIterador();
        nuevoIterador.antes_iterador = null;  
        nuevoIterador.despues_iterador = primero;
        return nuevoIterador;
    }

}
