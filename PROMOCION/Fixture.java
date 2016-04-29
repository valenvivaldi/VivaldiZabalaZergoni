import java.util.* ;

public class Fixture {
	
	
	public static void main (String args[]) {
		Horario[] horariosJugadores = new Horario[6];	
		int i=0;
		int aux1;
		int aux2;
		Scanner en=new Scanner(System.in);
		while(i<6){
			System.out.println("Ingrese los horarios del jugador "+(i+1));
			System.out.println("Cual es la primer hora que puede jugar?");
			aux1=en.nextInt();
			
			System.out.println("Cual es la ultima hora que puede jugar?");
			aux2=en.nextInt();
			horariosJugadores[i] = new Horario((i+1),aux1,aux2);
			
			
			i++;
			}
		
		LinkedList<Partido> partidosPosibles = new LinkedList<Partido>();
		int j=0;
		for( i=0; i<6; i++){
            for(j=i; j<6; j++){
				if(i!=j){
					agregarPartidosCoincidentes(partidosPosibles, horariosJugadores[i],horariosJugadores[j]);
					
					}
              
              
				}
            
            
              
			}
		
		System.out.println("Se han generado los partidos posibles y cargados en la lista");
		Partido partidoNuevo;
		
		LinkedList<Partido> configuracion= new LinkedList<Partido>();
		for(i=0;i<(partidosPosibles.size());i++){
			configuracion = new LinkedList<Partido>();
			configuracion.add(partidosPosibles.get(i));
			System.out.println("Probamos comenzando con el posiblepartido "+i);
			for(j=0;j<(partidosPosibles.size());j++){
				partidoNuevo = partidosPosibles.get(j);
				System.out.println("Probamos el posible partido  "+j);
				if (verificarConflictos(configuracion,partidoNuevo)){
					configuracion.add(partidoNuevo);
					}
				
				}
			
			if (configuracion.size()==15){
					break; 
				}
			
			}
			
		if(configuracion.size()==15){
			System.out.println("Configuracion encontrada!!!");
			imprimirListaPartidos(configuracion);
			}else{
				System.out.println("Configuracion NO ENCONTRADA :(");

			
			}
		
		
		
		
		
		
		
		
		
		}

	
	public static void agregarPartidosCoincidentes(LinkedList<Partido> q, Horario jugA, Horario jugB){
		
		int minimo = minim(jugA.obtenerPrim(),jugB.obtenerPrim()); 
		int maximo =maxim(jugA.obtenerUlt(),jugB.obtenerUlt());
		Partido aux;
		while(minimo <=maximo){
			if (minimo>=jugA.obtenerPrim() && minimo>=jugB.obtenerPrim() && minimo <= jugA.obtenerUlt() && minimo <=jugB.obtenerUlt()){
				aux= new Partido(jugA.obtenerNroJ(),jugB.obtenerNroJ(),minimo);
				q.add(aux);
				
				}
			
			
			
			minimo++;
			}
		
		
		
		}
	public static int minim (int a,int b){
		if (a<b){
			return a;
			}else{
				return b;
				}
		}
	
	public static int maxim(int a,int b){
		if (a>b){
			return a;
			}else{
				return b;
				}
		}	
		
	public static boolean compatible(Partido a,Partido b){
		if(a.obtenerjugadoruno()==b.obtenerjugadoruno()&&a.obtenerjugadordos()==b.obtenerjugadordos()){return false;}
		if(a.obtenerjugadoruno()==b.obtenerjugadordos()&&a.obtenerjugadordos()==b.obtenerjugadoruno()){return false;}
		
		if (a.obtenerhorapartido()==b.obtenerhorapartido()){
			
			if (a.obtenerjugadoruno()==b.obtenerjugadoruno()||a.obtenerjugadordos()==b.obtenerjugadordos()||a.obtenerjugadoruno()==b.obtenerjugadordos()||a.obtenerjugadordos()==b.obtenerjugadoruno()){return false;}
			
			
			
			}
		
		
		
		return true;
		}
		
	public static boolean verificarConflictos(LinkedList<Partido> q, Partido nuevo){
		int i =0;
		boolean result=true;
		while(i<q.size() && result){
			result = compatible(q.get(i),nuevo);
			
			
			i++;
			}
		return result;
		
		}
	

	public static void imprimirListaPartidos(LinkedList<Partido> lista){
		Partido auxiliar;
		int i=0;
		while (i<lista.size()){
			auxiliar=lista.get(i);
			System.out.println("A las "+auxiliar.obtenerhorapartido()+" jugara el jugador nro"+auxiliar.obtenerjugadoruno()+" contra el jugador nro "+auxiliar.obtenerjugadordos());
			
			i++;
			}
		
		
		
		
		}





	}
