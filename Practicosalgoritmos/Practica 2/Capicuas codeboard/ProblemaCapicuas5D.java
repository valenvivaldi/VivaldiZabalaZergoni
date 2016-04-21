import java.util.List;
import java.util.LinkedList;
/**
 * Clase que resuelve el problema de los numeros capicuas.
 * <p>
 * Una solucion a este problema consiste en un par (a,b) tal que a y b son numeros capicuas de 5 digitos tal que no exista
 * otro par (c,d) de numeros capicuas de 5 digitos tal que |c - d| < |a - b|.
 * 
*/
public class ProblemaCapicuas5D {
    
    /**
     * @return todas las soluciones posibles al problema que plantea esta clase
     */ 
    public static List<ParCapicuas> obtenerSoluciones() {
        List<ParCapicuas>listapar = new LinkedList<ParCapicuas>();
        Capicua5D a=new Capicua5D(10001);
        Capicua5D b=a.siguiente();
                     //a tiene el primer capicua de 5 digitos y b tiene el siguiente
        while(b!=null){
            ParCapicuas aux = new ParCapicuas(a,b);
            listapar.add(aux);
            a=b;
            b=a.siguiente();
            
        }
        return listapar;
    
        
        
    }
    
    /**
    * @return una solucion al problema que plantea esta clase
    */ 
    public static ParCapicuas obtenerSolucion() {
        Capicua5D a=new Capicua5D(10001);
        Capicua5D b=a.siguiente();
                     //a tiene el primer capicua de 5 digitos y b tiene el siguiente
        Capicua5D c,d; // estos van a guardar los pares resultado
        int dist =a.diferencia(b);
        c=a;
        d=b;
        while(b!=null){
         if (a.diferencia(b)<dist){
             c=a;
             d=b;
             dist =a.diferencia(b);
         }
            
            a=b;
            b=a.siguiente();
            
        }
        ParCapicuas aux = new ParCapicuas(c,d);
        return aux;
        
        
        
    }
    
    
}
