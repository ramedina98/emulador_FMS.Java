/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lotes;
import java.util.Scanner;
import java.time.LocalDateTime; 
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.regex.Matcher; 
import java.util.regex.Pattern;

/*
    este es un ejemplo de uso de las clases...
*/

/**
 * Start Friday, 22 Macrh
 * @author ricardomedina
 */
public class Lote {
    
    public Lote(){
        //constructor vacio...
    }
    
    //Metodos...
    //1. Primero necesitamos un metodo para separar los elementos necesarios de operation...
    public char simbolo(String operation){
        //definimos el patron de busqueda para encontrar el símbolo...
        Pattern patron = Pattern.compile("[+\\-*/]");
        
        //creamos un objeto matcher y lo usamos para encopntrar el símbolo en la cadena...
        Matcher matcher = patron.matcher(operation);
        
        // verificar si se encontro el algun simbolo valido...
        if(matcher.find()){
            String simbolo = matcher.group().trim();
            return simbolo.charAt(0);
        } else{ // si no hay ninguno valido regresamos un digito 0 para indicar que no es valido...
            return '0';
        }
    }
    
    //2. ahora buscamos 
    public double[] numeros(String operation, char simbolo){
        double[] numeros = new double[2];
        
        //extraemos el simbolo...
        char symbol = simbolo; 
        
        // hay que extraer los numeros...
        String[] partes = operation.split("\\s*\\Q" + symbol + "\\E\\s*");
        
        // acomodamos cada numero en su indice correspondiente...
        numeros[0] = Double.parseDouble(partes[0]);
        numeros[1] = Double.parseDouble(partes[1]);
        
        //retornamos el array double...
        return numeros; 
    }
    
    //3. esta funcion nos ayuda a eliminar los espacios en blanco en la cadena...
    public String quitarEspacios(String cadena) {
        return cadena.replaceAll("\\s+", "");
    }
    
    //4. Obtenemos la hora (hh:mm:ss)...
    public String hora(){
        // creamos una instancia para obtener la fecha y hora...
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        
        // Definir el formato deseado
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        
        
        // Formatear la fecha y hora utilizando el formato definido
        String fechaHoraFormateada = fechaHoraActual.format(formatter);
        
        // Devolver la fecha y hora formateada
        return fechaHoraFormateada;
    }
    
    //5. Obtenemos la fecha (dd/mm/YY)...
    public String fecha(){
        // creamos una instancia para obtener la fecha y hora...
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        
        // Definir el formato deseado
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        
        
        // Formatear la fecha y hora utilizando el formato definido
        String fechaHoraFormateada = fechaHoraActual.format(formatter);
        
        // Devolver la fecha y hora formateada
        return fechaHoraFormateada;
    }

    
    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // creamos una instancia FMS
        FMS fms = new FMS();
       
        //Ingresamos el nombre del programador que correra el o los lotes...
        System.out.println("Nombre del programador: ");
        String programador = scanner.nextLine();
       
        int n = 1; 
        int i = 0; 
        
        ingresamos varios datos...
        la condicion es que si el usuario marca 0 es que ya no quiere ingresar más datos,
        o si la cuent llega a 10 pare ya que solo se puede un maximo de 10 lotes...
        do{
            System.out.println("Ingrese operación 000" + (i + 1) + ";");
            String operacion = scanner.nextLine();
            
            obtenemos la fecha actual...
            String date = "Fecha y hora: " + fechaHora();
            
            operacion...
            String operacionSinEspacios = quitarEspacios(operacion);
            
            
                Ahora sigue el separar los elementos de la operacion (simbolo, a, b) y luego instanciar
                la clase Trabajo para usar el metodo procesar para obtener el resultado de la operacion...
            
            
            obtenemos el simbolo...
            char symbol = simbolo(operacionSinEspacios);
            
            inicializamos un array de doubles...
            double[] numeros = new double [2];
            obtenemos los numeros...
            numeros = numeros(operacionSinEspacios, symbol);
            
            
            Instanciamos una clase Trabajo...
            Trabajo nuevoTrabajo = new Trabajo(programador, symbol, numeros[0], numeros[1]);
            
            obtenemos el resultado del proceso...
            double resultado = nuevoTrabajo.Procesar();
            
            fms.queue(programador, date, operacionSinEspacios, resultado);
            
            preguntamos si quiere continuar...
            System.out.println("¿Desea agregar más? (SI = 1 / NO = 0)");
            n = scanner.nextInt(); 
            scanner.nextLine();
            
            incrementamos...
            i++;
            
            verificamos si ya llegamos al limite de (10)...
            if(i == 9){
                n = 0; 
            }
 
        }while(n != 0);
        
        Pausa la ejecución durante un segundo (1500 milisegundos)
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            Manejo de excepciones si es necesario
            e.printStackTrace();
        }
        
        imprimimos todos los datos de la queue...
        while(!fms.isEmpty()){
            Map<String, Object> elemento = (Map<String, Object>) fms.pullFromTheQueue();

            System.out.println(elemento.get("nombre"));

            Pausa la ejecución durante un segundo (1000 milisegundos)
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                Manejo de excepciones si es necesario
                e.printStackTrace();
            }
        }
    }*/
    
}
