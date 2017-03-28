//  INTEGRANTES DEL GRUPO: BRUNO ZERGONI, JOAQUIN ZABALA Y VALENTIN VIVALDI
//
//
//


public class Partido {   // esta clase representa un partido posible
	private int jug1;  // este atributo guarda el numero de uno de los dos jugadores
	private int jug2; // este guarda el numero del otro jugador
	private int hora; // y este atributo guarda la hora en la que se disputa el partido
	
	public Partido(int j1,int j2,int h){  //  esta es la funcion creadora
		
		jug1 =j1;
		jug2=j2;
		hora=h;
		}
	public int obtenerjugadoruno(){ //esta funcion devuelve el nro del primer jugador
		return jug1;
		}
	
	public int obtenerjugadordos(){ // esta devuelve el nro del otro jugador
		return jug2;
		}
	
	public int obtenerhorapartido(){ // y esta devuelve la hora del partido
		return hora;
		}
	
	
	
	
	
	
	
	
	
	}
