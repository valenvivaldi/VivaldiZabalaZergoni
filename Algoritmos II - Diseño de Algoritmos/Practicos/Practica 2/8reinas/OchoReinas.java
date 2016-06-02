import java.util.Collection;
import java.util.LinkedList;
/**
 * Esta clase representa el problema de las ocho reinas.
 * 
 * Dado un tablero de ajedrez hay que encontrar todas las formas de ubicar ocho reinas tal que ninguna amenace a otra.
 */ 
public class OchoReinas {
    
    /**
     * Constructor de la clase
     */ 
    public OchoReinas() {
        
        
        
    }
    
    /**
     * Obtiene una solucion al problema de las ocho reinas.
     * 
     * @return un tablero t tal que {@code !t.hayAmenaza()}
     */ 
    public Tablero obtenerSolucionOchoReinas() {
        //implemente una funcion que retorne un tablero con ocho reinas tal que el metodo hayAmenaza retorne false.
     
		//System.out.println("obtener sol iniciado");
       Tablero t= new Tablero();
    //   System.out.println("t creado");
       int a0;
       int a1;
       int a2;
       int a3;
       int a4;
       int a5;
       int a6;
       int a7;
       
       
            
       System.out.println("creo los a0...");
       
       
        for(a0=0;a0<8;a0++){
            System.out.println("primero for, a0="+a0);
            for(a1=0;a1<8;a1++){
            
                for(a2=0;a2<8;a2++){
            
                    for(a3=0;a3<8;a3++){
            
                        for(a4=0;a4<8;a4++){
            
                            for(a5=0;a5<8;a5++){
            
                                for(a6=0;a6<8;a6++){
            
                                    for(a7=0;a7<8;a7++){
                                        t = new Tablero(a0,a1,a2,a3,a4,a5,a6,a7);                       
                                       // System.out.println("combinacion "+a0+""+a1+""+a2+""+a3+""+a4+""+a5+""+a6+""+a7+"");
                                        if(!t.hayAmenaza()){
											
											return t;
                                        }else{}//System.out.println("hay amenaza");}
                                        
                                        
                                    }
                                    
                                }
                                
                            }
                            
                        }
                        
                    }
                    
                }
                
            }
                
            
    }    
    return null;
    
  
}

    public Collection<Tablero> obtenerSolucionesOchoReinas() {
       Tablero t = new Tablero();
       int a0;
       int a1;
       int a2;
       int a3;
       int a4;
       int a5;
       int a6;
       int a7;
       
       Collection<Tablero> c = new LinkedList<Tablero>();
        for(a0=0;a0<8;a0++){
            System.out.println("primero for, a0="+a0);
            for(a1=0;a1<8;a1++){
            
                for(a2=0;a2<8;a2++){
            
                    for(a3=0;a3<8;a3++){
            
                        for(a4=0;a4<8;a4++){
            
                            for(a5=0;a5<8;a5++){
            
                                for(a6=0;a6<8;a6++){
            
                                    for(a7=0;a7<8;a7++){
                                        t = new Tablero(a0,a1,a2,a3,a4,a5,a6,a7);                       
                                       // System.out.println("combinacion "+a0+""+a1+""+a2+""+a3+""+a4+""+a5+""+a6+""+a7+"");
                                        if(!t.hayAmenaza()){
											
											c.add(t);
                                        }else{}//System.out.println("hay amenaza");}
                                        
                                        
                                    }
                                    
                                }
                                
                            }
                            
                        }
                        
                    }
                    
                }
                
            }
                
            
    }    
    return c;
    
  
} 
       
       
        
        
        
    }
    
