package nmm;

import framework.AdversarySearchState;

public class EstadoNMM implements AdversarySearchState {
	private boolean max;
	@SuppressWarnings("unused")
	private int turn; //2 si es la maquina y 1 si es el jugador
	private String movimientoAplicado;
	@SuppressWarnings("unused")
	private int[] tablero;
	
	public EstadoNMM(boolean maxx,int turnn, String mov,int[]tabl){
		max=maxx;
		turn=turnn;
		movimientoAplicado=mov;
		tablero=tabl;
		
	}
	
	
	
	@Override
	public boolean isMax() {
		
		return max;
	}

	@Override
	public boolean equals(AdversarySearchState other) {
		
		return (this.toString()==other.toString());
		
	}

	
	@Override
	public Object ruleApplied() {
		
		return movimientoAplicado;
	}

}
