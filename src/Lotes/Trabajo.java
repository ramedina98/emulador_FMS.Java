package Lotes;
import java.time.LocalDateTime; 

/**
 *  Start Friday, 22 March...
 * @author ricardomedina
 */
public class Trabajo {
    private String programador; 
    private char simbolo; 
    private double a, b; 
    private String dateHour; 
    
    public Trabajo(String programador, char simbolo, double a, double b){
        this.programador = programador; 
        this.simbolo = simbolo; /* + - * / */
        this.a = a; 
        this.b = b; 
        this.dateHour = LocalDateTime.now().toString(); 
    }
    
    /*TODO: creo que este no es necesario...
    public Trabajo(String programador, char simbolo){
        this.programador = programador; 
        this.simbolo = simbolo; 
    }*/

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public String getProgramador() {
        return programador;
    }

    public char getSimbolo() {
        return simbolo;
    }

    public double getA() {
        return a;
    }
    
    public double getB() {
        return b;
    }
    
    public double Procesar() {
        // checamos que tipo de operación es...     
        switch(this.simbolo){
            case '+': 
                return this.a + this.b;
            
            case '-': 
                return this.a - this.b;
             
            case '*': 
                return this.a * this.b;
                
            case '/': 
                if(this.b != 0){
                    return this.a / this.b; 
                } else{
                    System.out.println("Division por cero no permitida.");
                    return Double.NaN; // devolvemos nan osea: Not a Nutmber...
                }
                
            default: 
                return -404; // devolver un valor predeterminado para indicar que hubo un error, que no existe ese simbolo...
                
        } 
    }
    
}
