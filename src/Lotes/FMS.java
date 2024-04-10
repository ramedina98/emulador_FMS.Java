/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lotes;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO: aqui hay que hacer un algoritmo de cola para cada vez que reciba un nuevo lote lo vaya en colando, 
 * esto para emular la programacion por lote de un FMS...
 * @author ricardomedina
 */
public class FMS {
    private Nodo front;
    private Nodo tail;

    public FMS() {
        front = null;
        tail = null;
    }

    // Método para verificar si la cola está vacía
    public boolean isEmpty() {
        return front == null;
    }
    
    // Método para saber el tamaño de la cola...
    public int size(){
        int count = 0; 
        Nodo current = front; // comenzamos desde el frente de la cola...
        
        while(current != null){
            count++; // incrementamos el contador...
            current = current.next; //avanzamos al siguiente...
        }
        
        return count; //devolvemos el tamaño...
    }

    // Método para agregar un elemento a la cola
    public void queue(String nombre, String fecha, String operacion, double resultado) {
        Nodo newNodo = new Nodo(nombre, fecha, operacion, resultado);
        if (isEmpty()) {
            front = newNodo;
        } else {
            tail.next = newNodo;
        }
        tail = newNodo;
    }

    // Método para eliminar y devolver el elemento del frente de la cola
    public Object pullFromTheQueue() {
        if (isEmpty()) {
            throw new IllegalStateException("La cola está vacía");
        }

        String nombre = front.nombre;
        String fecha = front.fecha;
        String operacion = front.operacion;
        double resultado = front.resultado;

        front = front.next;
        if (front == null) {
            tail = null;
        }

        // Crear un Map para almacenar los datos del nodo
        Map<String, Object> elemento = new HashMap<>();
        elemento.put("nombre", nombre);
        elemento.put("fecha", fecha);
        elemento.put("operacion", operacion);
        elemento.put("resultado", resultado);

        return elemento;
    }

    // Clase interna Nodo
    private static class Nodo {
        String nombre;
        String fecha;
        String operacion;
        double resultado;
        Nodo next;

        // Constructor
        public Nodo(String nombre, String fecha, String operacion, double resultado) {
            this.nombre = nombre;
            this.fecha = fecha;
            this.operacion = operacion;
            this.resultado = resultado;
            this.next = null;
        }
    }
}

