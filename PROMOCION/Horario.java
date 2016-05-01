//  INTEGRANTES DEL GRUPO: BRUNO ZERGONI, JOAQUIN ZABALA Y VALENTIN VIVALDI
//
//
//



public class Horario {  // creamos esta clase para represntar los horarios de cada jugador
	private int nroJug;	 // este atributo guarda el numero que identifica el jugador
	private int primHora; // Este atributo guarda la primer hora en la que puede jugar el jugador
	private int ultHora; // este atributo guarda la ultima hora en la que puede jugar el jugador  
	
	public Horario(int j, int prim, int ult){   // esta es el la funcion creadora de la clase
		nroJug=j;
		primHora=prim;
		ultHora=ult;
		}
	
	
	public int obtenerPrim () { // devuelve la primer hora
		
		return primHora;
		}
	
	
	public int obtenerUlt () { // devuelve a ultima hora
		
		return ultHora;
		}
	
	
	public int obtenerNroJ () { // devuelve el nro de jugador
		
		return nroJug;
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
