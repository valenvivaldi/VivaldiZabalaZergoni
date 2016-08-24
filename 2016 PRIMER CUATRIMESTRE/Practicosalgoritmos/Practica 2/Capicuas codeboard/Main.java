/**
 * Main class of the Java program. 
 * 
 */
 
import java.util.List;

public class Main {

    public static void main(String[] args) {
        
        System.out.println("Soluciones al problema de los numeros capicuas de 5 digitos");
        for (ParCapicuas s : ProblemaCapicuas5D.obtenerSoluciones()) {
            System.out.println(s.toString() + " diferencia : " + s.primero().diferencia(s.segundo()));
        }
    }
}
