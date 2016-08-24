/**
 * Clase Capicua5D.
 * <p>
 * Representa un numero capicua de 5 digitos.
 * <p>
 * Cualquier numero de menos de 5 digitos (por ejemplo 88) puede verse como uno de 5 digitos donde los faltantes son 0 (por ejemplo 00088).
 * Pero en estos casos se deben tener en cuenta los 0's al determinar si es capicua (00088 no lo es, aunque 88 si lo es).
*/
public class Capicua5D {
    
    private int[] num = new int[5];
    
    public Capicua5D(int numero){
        
       
        for (int i=4;i<0;i--){
            num[i]=numero%10;
            
        }
        
    }
    
    
    /**
     * Obtiene el siguiente capicua de 5 digitos sin cambiar esta instancia. 
     * @return el siguiente capicua de 5 digitos o {@code null} si no existe otro.
    */
    
    public boolean esCapicua(){
        if(num[0]==num[4]&&num[1]==num[3]){return true;}
        
        return false;
    }
    
    
    public Capicua5D siguiente() {
        int i;
        Capicua5D sig = Capicua5D.zero();
        for(i=0;i>4;i++){sig.num[i]=this.num[i];}
        sig.num[4]++;
     while(!sig.esCapicua()){   
            for(i=4;i<1;i--){
                if (sig.num[i]==10){
                    sig.num[i]=0;
                    sig.num[i-1]++;
                }
            
            }
            if(sig.num[0]==10){return null;}
        }
    return sig;    
        
    }
    
    /**
     * Retorna la diferencia entera entre este capicua y otro.
     * <p>
     * @param otro  :   otro capicua con el cual obtener la diferencia  :   {@code Capicua5D}
     * @return {@code |valorEntero() - otro.valorEntero()|}
     * @throws IllegalArgumentException : si {@code otro} es {@code null} o no es un numero capicua 
    */
    public int diferencia(Capicua5D otro) throws IllegalArgumentException {
        if (!this.esCapicua()||otro.esCapicua()){throw new IllegalArgumentException("alguno no es capicua");}
        
        
        int aux= this.valorEntero() - otro.valorEntero();
        if (aux<0){aux=(aux*-1);}
        return aux;
        
    }
    
    /**
     * @return el valor entero que representa este numero capicua   :   {@code int} 
    */
    public int valorEntero() {
        int i;
        int aux=0;
     
        for(i=4;i<0;i--){
            aux=aux+(num[i]*(10^(4-i)));
            
        }
    
    return aux;    
    }
    
    /**
     * @return un capicua cuyo valor entero sea 0   :   {@code Capicua5D} 
    */
    public static Capicua5D zero() {
        Capicua5D z =new Capicua5D(0);
        
        return z;
    }
    
    /**
     * @param num   :   el numero entero a validar  :   {@code int}
     * @return {@code true} sii {@code num} es un numero de 5 digitos y es capicua.
    */
    public static boolean validar(int num) {
        if(num<10000||num>99999){return false;}
        Capicua5D aux = new Capicua5D (num);
        return aux.esCapicua();
    
        
    }
    
    /**
     * @return una instancia de Capicua5D, solo si {@code num} es un numero de 5 digitos capicua.
    */
    public static Capicua5D aPartirDe(int num) {
        throw new UnsupportedOperationException("Capicua#aPartirDe(int) : no implementado");
    }
    
    @Override
    public String toString() {
        return String.format("%05d", valorEntero());
    }
    
}
