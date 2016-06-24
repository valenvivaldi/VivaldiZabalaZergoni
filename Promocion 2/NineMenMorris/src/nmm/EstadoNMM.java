package nmm;

import framework.AdversarySearchState;

public class EstadoNMM implements AdversarySearchState {
	private int fichasJ;
	private int fichasCPU;
	
	private boolean max; 	 /*true es max si es false es min*/
	private int turn; 		/* 2 si es la maquina y 1 si es el jugador*/
	
	
	private String movimientoAplicado;
	private int[] tablero;
	
	public EstadoNMM(boolean maxx,int turnn, String mov,int[]tabl,int fichj,int fichcpu){
		max=maxx;
		turn=turnn;
		movimientoAplicado=mov;
		tablero=tabl;
		fichasJ=fichj;
		fichasCPU=fichcpu;
	}
	
	
	
	@Override
	public boolean isMax() {
		
		return max;
	}

	
	public boolean equals(EstadoNMM other) {
		boolean res =true;
		if(this.max!=other.max){res=false;}
		if(this.fichasJ!=other.fichasJ){res=false;}
		if(this.fichasCPU!=other.fichasCPU){res=false;}
		if(this.movimientoAplicado!=other.movimientoAplicado){res=false;}
		if(this.turn!=other.turn){res=false;}
		for(int i=0;i<24;i++){if(this.tablero[i]!=other.tablero[i]){res=false;}}
		
		return res ;
		
	}

	
	@Override
	public Object ruleApplied() {
		
		return movimientoAplicado;
	}



	@Override
	public boolean equals(AdversarySearchState other) {
		
		return false;
	}
	public int[] getTablero(){
		return tablero;
		
		
	}
	public int getTurn(){
		return turn;
	}
	public String getMovAp(){
		return movimientoAplicado;
	}
	public int getFichasJ(){
		return fichasJ;
	}
	public int getFichasCPU(){
		return fichasCPU;
	}
	



}
