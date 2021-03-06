package nmm;

import java.util.Scanner;

import framework.AdversarySearchEngine;

public class appNMM {
	
	
	
	public static void main(String[] args){
		ProblemaNMM problema = new ProblemaNMM();
		EstadoNMM estadoActual = problema.initialState();
		int prof=4;
		MinMaxNMM engine= new MinMaxNMM(problema,prof);
		while(!(problema.end(estadoActual))){
			mostrarJuego(estadoActual);
			estadoActual=jugar(problema,estadoActual,engine);
			
			
			
			
		}
		mostrarJuego(estadoActual);
		if(problema.value(estadoActual)<0){
			System.out.println("GANO EL JUGADOR!!!");
		}else{
			System.out.println("GANO LA MAQUINA!!!");
		}
		
	}
	
	/*Esta funcion hace que, si es turno del jugador, le avise que puede hacer (si mover, insertar o eliminar) y
	 * le pide la coordenada de la ficha a insertar, mover o eliminar...Si el turno es de la CPU, hace 
	 * MinMax y juega el mov que mas le conviene*/
	private static EstadoNMM jugar(ProblemaNMM problema,EstadoNMM estadoActual, MinMaxNMM engine) {
		EstadoNMM res=null;
		Scanner sc = new Scanner(System.in);
		if(estadoActual.getTurn()==1){
			if(estadoActual.getMovAp()=="Molino!"){
				System.out.println("ESTAS EN UN MOLINO! TENES QUE ELIMINAR UNA FICHA ");
				res =ejecutarComando(problema,estadoActual,3);
			}else{
				if(estadoActual.getFichasJ()>0){
					System.out.println("TENES QUE INSERTAR UNA FICHA ");
					res =ejecutarComando(problema,estadoActual,1);
				}else{
					System.out.println("TENES QUE MOVER UNA FICHA ");
					res =ejecutarComando(problema,estadoActual,2);
				}
				
			}
			
					
			
		}else{
			res=engine.computeSuccessor(estadoActual);
			
		};
		return res;
	}
	/*Esta funcion ejecuta la accion del jugador*/
	
	private static EstadoNMM ejecutarComando(ProblemaNMM prob,EstadoNMM estadoActual,int comando) {
		Scanner sc = new Scanner(System.in);
		int coo ;
		EstadoNMM res=null;
		if(comando==1){
			System.out.println("Ingrese la coordenada donde quiere insertar una ficha");
			coo = sc.nextInt();
			res= prob.insertarFicha(estadoActual,coo);
		}
		if(comando==2){
			System.out.println("Ingrese la coordenada donde quiere mover una ficha,primero el origen y luego el destino");
			coo = sc.nextInt();
			int coo2 = sc.nextInt();
			res= prob.moverFicha(estadoActual,coo,coo2);
		}
		if(comando==3){
			System.out.println("Ingrese la coordenada donde quiere eliminar una ficha");
			coo = sc.nextInt();
			res= prob.eliminarFicha(estadoActual,coo);
		}
		return res;
	}

	/*Esta funcion muestra de quien es el turno, y el tablero*/
	private static void mostrarJuego(EstadoNMM estadoActual) {
		System.out.println("TURNO DE:"+estadoActual.getTurn());
		estadoActual.imprimir();
		
	}
	
	
	
	
	
	
	
}