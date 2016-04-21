/**
 * Esta clase representa un tablero de Ajedrez especializado para el problema de las reinas.
 * 
*/
import java.util.*;

public class Tablero {
    
    /**
     * Constructor de la clase.
     */
      int[] t;
     
    public Tablero() {
        //TAREA: el constructor debe crear un nuevo tablero
        //la configuracion del tablero debe cumplir con que haya 8 reinas en el tablero (las posiciones de las mismas no estan restringidas)
    
        t= new int[8];
        int i=0;
        while (i<8){ 
			t[i]=0;
			i++;
			}
		System.out.println("termino la construccion del t");
        
    }
    public Tablero(int a,int b, int c,int d, int e, int f, int g,int h) {
        //TAREA: el constructor debe crear un nuevo tablero
        //la configuracion del tablero debe cumplir con que haya 8 reinas en el tablero (las posiciones de las mismas no estan restringidas)
    
        t= new int[8];
        t[0]=a;
        t[1]=b;
        t[2]=c;
        t[3]=d;
        t[4]=e;
        t[5]=f;
        t[6]=g;
        t[7]=h;
        
    }
    
    
    
    /**
     * @return {@code true} sii existe al menos una reina amenazada por otra. 
     */
    public boolean hayAmenaza() {
        //TAREA: implemente esta funcion para que devuelva true si existe al menos una reina en el tablero que amenaza a otra.
      
       for (int i=0;i<8;i++){
         for (int j=0;j<8;j++){
             if (i!=j &&(t[i]==t[j] || Math.abs((j-i))==Math.abs((t[j]-t[i])) ) ){return true;}
         }  
        }
       return false;
       
       
    }
    
    
    
    
    
    
    /**
     * @param columna   :   una de las columnas del tablero :   {@code int}
     * @param fila      :   una de las filas del tablero    :   {@code int}
     * 
     * @return {@code true} sii el tablero esta ocupado en la casilla especificada por los argumentos {@code columna} y {@code fila} 
     * @throws IllegalArgumentException : si columna < 0 || fila < 0 || columna > 7 || fila > 7
     */
    public boolean ocupado(int columna, int fila) throws IllegalArgumentException {
        //TAREA:    implemente esta funcion para que devuelva true si existe una reina en la casilla especificada por los argumentos columna y fila.
        //          Por ejemplo en el siguiente tablero
        //             0   1   2   3   4   5   6   7
        //  0        |   |   |   |   |   |   |   | R |
        //  1        |   |   |   |   |   |   |   |   |
        //  2        | R |   |   | R | R |   |   |   |
        //  3        |   |   |   |   |   | R |   |   |
        //  4        |   |   |   |   |   |   |   |   |
        //  5        |   |   |   |   |   |   |   |   |
        //  6        |   |   | R |   |   |   |   |   |
        //  7        |   |   |   |   |   |   | R |   |
        //          
        //          deberian ser ciertas las siguientes expresiones
        //          ocupado(0,2) == true
        //          ocupado(2,0) == false
        //          ocupado(2,6) == true
        //          ocupado(6,7) == true
        //          ocupado(7,6) == false
        if(columna < 0 || fila < 0 || columna > 7 || fila > 7) {throw new IllegalArgumentException("Coordenadas fuera del tablero!");}
        
        return (t[columna]==fila);    
        }
    
    /**
     * @param columnaOrigen   :   una de las columnas del tablero en donde esta la reina a mover    :   {@code int}
     * @param filaOrigen      :   una de las filas del tablero en donde esta la reina a mover       :   {@code int}
     * 
     * @param columnaDestino   :   una de las columnas del tablero en donde estara la reina a mover    :   {@code int}
     * @param filaDestino      :   una de las filas del tablero en donde estara la reina a mover       :   {@code int} 
     * 
     * @throws IllegalArgumentException : si columna < 0 || fila < 0 || columna > 7 || fila > 7 || !ocupado(columnaOrigen, filaOrigen) || ocupado(columnaDestino, filaDestino)
     */
    public void mover(int columnaOrigen, int filaOrigen, int columnaDestino, int filaDestino) throws IllegalArgumentException { 
        //TAREA:    implemente esta funcion para que mueva una reina desde una casilla especificada por los argumentos columnaOrigen y filaOrigen
        //          a una casilla especificada por los argumentos columnaDestino, filaDestino.
        //          Si la casilla origen no esta ocupada o la casilla destino esta ocupada se debe arrojar una IllegalArgumentException.
        //          Por ejemplo en el siguiente tablero
        //
        //             0   1   2   3   4   5   6   7
        //  0        |   |   |   |   |   |   |   | R |
        //  1        |   |   |   |   |   |   |   |   |
        //  2        | R |   |   | R | R |   |   |   |
        //  3        |   |   |   |   |   | R |   |   |
        //  4        |   |   |   |   |   |   |   |   |
        //  5        |   |   |   |   |   |   |   |   |
        //  6        |   |   | R |   |   |   |   |   |
        //  7        |   |   |   |   |   |   | R |   |
        //          
        //          la llamada mover(0,2,2,5) deberia producir el siguiente tablero
        //          
        //             0   1   2   3   4   5   6   7
        //  0        |   |   |   |   |   |   |   | R |
        //  1        |   |   |   |   |   |   |   |   |
        //  2        |   |   |   | R | R |   |   |   |
        //  3        |   |   |   |   |   | R |   |   |
        //  4        |   |   |   |   |   |   |   |   |
        //  5        |   |   | R |   |   |   |   |   |
        //  6        |   |   | R |   |   |   |   |   |
        //  7        |   |   |   |   |   |   | R |   |
        if (columnaOrigen!=columnaDestino && filaOrigen!=filaDestino){
        if (!(ocupado(columnaOrigen,filaOrigen))||ocupado(columnaDestino,filaDestino)) {throw new IllegalArgumentException("La casilla origen esta vacia o la casilla de destino esta ocupada!");}
    
        t[columnaOrigen]=-1;
        t[columnaDestino]=filaDestino;
        }
    }
    
    /**
     * Colocar una reina en una casilla especifica, la cual esta vacia.
     * 
     * @param columna   :   la columna donde colocar la reina   :   {@code int}
     * @param fila      :   la fila donde colocar la reina      :   {@code int}
    */
    public void colocarReina(int columna, int fila) throws IllegalArgumentException {
        //TAREA:    implemente esta funcion para que coloque una reina en la columna y fila especificada.
        //          Si ya existe una reina en esa casilla o si la columna y la fila no estan dentro de los valores (0, 7),
        //          el metodo debe retornar una excepcion (IllegalArgumentException).
        if(columna<0||columna>7||fila<0||fila>7||ocupado(columna,fila)){throw new IllegalArgumentException("las coordenadas estan fuera del tablero o la casilla donde quiere colocar esta ocupada");}
        
        t[columna]=fila;
    }
    
    /**
     * Limpia el tablero, ninguna casilla esta ocupada luego de llamar a este metodo 
    */
    public void limpiarTablero() {
        //TAREA:    implemente esta funcion para que limpie el tablero (ninguna casilla debe quedar ocupada)
         for (int i=0;i<8;i++){
           
               t[i]=-1;
               
          
        }
        
    }
    
    @Override
    public String toString() {
       //TAREA: implemente esta funcion para que retorne una representacion (en forma de String) de este tablero
      String result;
        result=("");
        char aux;
         for (int j=0;j<8;j++){
           for(int i=0;i<8;i++){
               aux = 'x';
               if (t[i]==j){
                 aux='D';  
               }
               result=result+("|"+aux);
               
           }
            result=result+("|\n"); 
         }
    
        return result;
    }
    
    
}
