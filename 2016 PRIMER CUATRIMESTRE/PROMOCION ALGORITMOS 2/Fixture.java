//  INTEGRANTES DEL GRUPO: BRUNO ZERGONI, JOAQUIN ZABALA Y VALENTIN VIVALDI
//
//
//

import java.util.* ;



                         
public class Fixture {
	
	
	public static void main (String args[]) {
		Horario[] horariosJugadores = new Horario[6];	//armamos un arreglo de 6 horarios para los 6 jugadores
		int i=0; // declaramos variables que nos van a servir para recibir los datos del usuario por teclado
		int aux1;
		int aux2;
		Scanner en=new Scanner(System.in);  //usamos la clase de java.utils Scanner para obtener datos por teclado
		while(i<6){                                          
			System.out.println("Ingrese los horarios del jugador "+(i+1));   // con un ciclo vamos cargando los horarios de los 6 jugadores
			System.out.println("Cual es la primer hora que puede jugar?");
			aux1=en.nextInt();
			
			System.out.println("Cual es la ultima hora que puede jugar?");
			aux2=en.nextInt();
			horariosJugadores[i] = new Horario((i+1),aux1,aux2);
			
			
			i++;
			}
		
		LinkedList<Partido> partidosPosibles = new LinkedList<Partido>(); // creamos una lista de partidos posibles
		int j=0;
		for( i=0; i<6; i++){                   //hacemos dos for anidados para comparar todos los jugadores entre si y usamos la funcion 
            for(j=i; j<6; j++){				// "agregarPartidosCoincidentes" para cargar a la lista los partidos posibles dados los horarios de cada
				if(i!=j){                  // jugador.
					agregarPartidosCoincidentes(partidosPosibles, horariosJugadores[i],horariosJugadores[j]); 
					
					}
              
              
				}
            
            
              
			}
		
		System.out.println("Se han generado los partidos posibles y cargados en la lista");
/*cuando ya tenemos la lista de todos los partidos posibles, empezamos a generar configuraciones posibles, las realizamos de esta manera:
elegimos un partido posible y lo agregamos a la configuracion, tomando este partido como punto de partida vamos metiendo partidos en la configuracion
 pero no cualquiera, si no solo aquellos que no hagan conflicto con los ya insertados (o sea que no coincidan ambos jugadores o que coincida la hora 
 y alguno de los jugadores).. si cuando ya no quedan partidos por insertar tenemos 15 partidos en la lista entonces tenemos una configuracion correcta,
 sino entonces creamos la lista desde 0 y comenzamos a partir de otro partido.. Esto lo hacemos para asegurar que cada partido este en al menos una
 configuracion.

*/
		Partido partidoNuevo;  												
		LinkedList<Partido> configuracion= new LinkedList<Partido>();
		for(i=0;i<(partidosPosibles.size());i++){       //este for indica con cual partido se toma como punto de partida
 			configuracion = new LinkedList<Partido>();  
			configuracion.add(partidosPosibles.get(i)); // se agrega el partido inicial
			for(j=0;j<(partidosPosibles.size());j++){     //vamos agregando los otros partidos si es que no hacen conflicto con los anteriores
				partidoNuevo = partidosPosibles.get(j);
				if (verificarConflictos(configuracion,partidoNuevo)){  
					configuracion.add(partidoNuevo);
					}
				
				}
			
			if (configuracion.size()==15){   //si se detecta que la configuracion es de tamaño 15 entonces es porque tiene todos los partidos
					break;                  // entre los 6 jugadores y no es necesario que se siga buscando
				}
			
			} // este for finaliza o porque ya miro todas las posibilidades y no encontro configuracinon o con un break porque la encontro!
			
		if(configuracion.size()==15){   //si tiene tamaño 15 entonces la encontro e imprime la lista de partidos
			System.out.println("Configuracion encontrada!!!");
			imprimirListaPartidos(configuracion);
			}else{
				System.out.println("Configuracion NO ENCONTRADA :("); // si no lo encontro lo informa!

			
			}
		
		
		
		
		
		
		
		
		
		}

	// esta funcion toma dos horarios y agrega a la lista de partidos los partidos en los cuales los dos jugadores estan disponibles a la misma hora
	public static void agregarPartidosCoincidentes(LinkedList<Partido> q, Horario jugA, Horario jugB){
		
		int minimo = minim(jugA.obtenerPrim(),jugB.obtenerPrim());  //inicia un ciclo desde el minimos de las horas iniciales y 
		int maximo =maxim(jugA.obtenerUlt(),jugB.obtenerUlt());     // hasta el maximo de las ultimas horas 
		Partido aux;                                                // prueba con los valores de hora, si los dos estan disponibles en esa hora
		while(minimo <=maximo){										// crea un partido posible y lo agrega a la lista q se paso por parametros
			if (minimo>=jugA.obtenerPrim() && minimo>=jugB.obtenerPrim() && minimo <= jugA.obtenerUlt() && minimo <=jugB.obtenerUlt()){
				aux= new Partido(jugA.obtenerNroJ(),jugB.obtenerNroJ(),minimo);
				q.add(aux);
				
				}
			minimo++;
			}
		
		
		
		}
	public static int minim (int a,int b){    //esta funcion devuelve el minimo de dos enteros
		if (a<b){
			return a;
			}else{
				return b;
				}
		}
	
	public static int maxim(int a,int b){   //esta funcion devuelve el maximo de dos enteros
		if (a>b){
			return a;
			}else{
				return b;
				}
		}	
		
	public static boolean compatible(Partido a,Partido b){   // esta funcion, dados dos partidos, devuelve true si son compatibles y false si
															// poseen conflictos, o sea que no se pueden dar juntos...
															
		// primero verificamos que no sean dos partidos entre los mismos jugadores													
		if(a.obtenerjugadoruno()==b.obtenerjugadoruno()&&a.obtenerjugadordos()==b.obtenerjugadordos()){return false;} 
		 
		if(a.obtenerjugadoruno()==b.obtenerjugadordos()&&a.obtenerjugadordos()==b.obtenerjugadoruno()){return false;}
		
		if (a.obtenerhorapartido()==b.obtenerhorapartido()){  // y tambien vemos si son partidos a la misma hora 
			
			if (a.obtenerjugadoruno()==b.obtenerjugadoruno()||a.obtenerjugadordos()==b.obtenerjugadordos()||a.obtenerjugadoruno()==b.obtenerjugadordos()||a.obtenerjugadordos()==b.obtenerjugadoruno()){return false;}
			 // si es que llegan a ser a la misma hora, entonces hay que ver si un jugador juega en ambos, si es asi entonces son incompatibles
			
			
			}
		
		
		
		return true; // si no pasa ninguna de esas cosas entonces son compatibles y pueden darse en la misma configuracion
		}
		
	public static boolean verificarConflictos(LinkedList<Partido> q, Partido nuevo){  // esta funcion toma un partido y una lista de partidos y 
		int i =0;													// devuelve true si es compatible con todos los partidos de la lista, sino 
																	// devuelve false
		boolean result=true;
		while(i<q.size() && result){
			result = compatible(q.get(i),nuevo);
			
			
			i++;
			}
		return result;
		
		}
	

	public static void imprimirListaPartidos(LinkedList<Partido> lista){   // esta funcion toma una lista de partidos y los imprime, indicando la hora
		Partido auxiliar;												// y quienes son los participantes
		int i=0;
		while (i<lista.size()){
			auxiliar=lista.get(i);
			System.out.println("A las "+auxiliar.obtenerhorapartido()+"hs. jugara el jugador nro "+auxiliar.obtenerjugadoruno()+" contra el jugador nro "+auxiliar.obtenerjugadordos());
			
			i++;
			}
		
		
		
		
		}





	}
