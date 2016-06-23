package nmm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import framework.AdversarySearchProblem;

public class ProblemaNMM implements AdversarySearchProblem<EstadoNMM> {

	@Override
	public EstadoNMM initialState() {
		int[] tab=new int[24];
		Arrays.fill(tab, 0);
		
		EstadoNMM ini = new EstadoNMM(false,1 , null, tab, 9, 9);
		
		
		return ini;
	}

	@Override
	public List<EstadoNMM> getSuccessors(EstadoNMM state) {
		List<EstadoNMM> sucesores = new LinkedList<EstadoNMM>();
		int turno =state.getTurn();
		int[] tabaux= state.getTablero();
		int cantFichas=contarFichas(turno,tabaux);
		EstadoNMM auxiliar;
		//si viene de un molino eliminas nomas
		if(state.getMovAp()=="Molino!"){
			for(int i=0;i<24;i++){
				if(tabaux[i]!=turno&&tabaux[i]!=0){
					auxiliar=eliminarFicha(state,i);
					sucesores.add(auxiliar);
				}
			}
			
			return sucesores;
		}
		//si tenes fichas en mano, solo podes insertar
		if(((turno==1 && state.getFichasJ()>0)||(turno==2&&state.getFichasCPU()>0))){
			for(int i=0;i<24;i++){
				if(tabaux[i]==0){
					auxiliar=insertarFicha(state,i);
					sucesores.add(auxiliar);
				}
			}
			return sucesores;
		}
		if(cantFichas>=3){
			for(int i=0;i<24;i++){
				for(int j=0;j<24;j++){
					if(tabaux[i]==turno &&tabaux[j]==0&&adyacentes(i,j)){
						auxiliar=moverFicha(state,i,j);
						sucesores.add(auxiliar);
						
					}
				}
			}	
			return sucesores;
		}
		
		return sucesores;
	}

	private boolean adyacentes(int i, int j) {
		

		return false;
	}

	@Override
	public boolean end(EstadoNMM state) {
		int[] aux=state.getTablero();
		int cantFichasJ=0;
		int cantFichasCPU=0;
		for(int i=0;i<24;i++){
			if(aux[i]==1){cantFichasJ++;}
			if(aux[i]==2){cantFichasCPU++;}
		}
		if(cantFichasJ<3||cantFichasCPU<3||(getSuccessors(state)).size()==0){return true;};
		return false;
	}

	@Override
	public int value(EstadoNMM state) {
		int[] tabaux= state.getTablero();
		int cantJ=contarFichas(1,tabaux);
		int cantCPU=contarFichas(2,tabaux);
		if(end(state)){
			if(cantCPU<cantJ){return maxValue();}
			if(cantCPU>cantJ){return minValue();}
		}
		int res = 100 - (cantJ-cantCPU);
		
		return res;
	}

	@Override
	public int minValue() {
		
		return 0;
	}

	@Override
	public int maxValue() {
		
		return 1000;
	}
	
	private int contarFichas(int j,int[] tab){
		int res=0;
		for(int i=0;i<tab.length;i++){
			if(j==tab[i]){res++;}
		}
		return res;
	}
	
	public EstadoNMM insertarFicha(EstadoNMM state,int i){
		int[] tabaux=new int[24];
		for(int j=0;j<24;j++){tabaux[j]=state.getTablero()[j];}
		int turno=state.getTurn();
		tabaux[i]=turno;
		EstadoNMM res;
		if(verificarMolino(i,tabaux,turno)){
			if(turno==1){
				res = new EstadoNMM(state.isMax(),turno,"Molino!",tabaux,state.getFichasJ()-1,state.getFichasCPU());
			}else{
				res = new EstadoNMM(state.isMax(),turno,"Molino!",tabaux,state.getFichasJ(),state.getFichasCPU()-1);
			}
			
		}else{
			if(turno==1){
				res = new EstadoNMM(!state.isMax(),2,"se inserto!",tabaux,state.getFichasJ()-1,state.getFichasCPU());
			}else{
				res = new EstadoNMM(!state.isMax(),1,"se inserto!",tabaux,state.getFichasJ(),state.getFichasCPU()-1);
			}
			
		}
		
		
		return res;
	}
	
	public EstadoNMM moverFicha(EstadoNMM state, int origen ,int destino){
		int[] tabaux=new int[24];
		for(int j=0;j<24;j++){tabaux[j]=state.getTablero()[j];}
		int turno=state.getTurn();
		tabaux[origen]=0;
		EstadoNMM res;
		if(verificarMolino(destino,tabaux,turno)){
			if(turno==1){
				res = new EstadoNMM(state.isMax(),turno,"Molino!",tabaux,state.getFichasJ(),state.getFichasCPU());
			}else{
				res = new EstadoNMM(state.isMax(),turno,"Molino!",tabaux,state.getFichasJ(),state.getFichasCPU());
			}
			
		}else{
			if(turno==1){
				res = new EstadoNMM(!state.isMax(),2,"se movio!",tabaux,state.getFichasJ(),state.getFichasCPU());
			}else{
				res = new EstadoNMM(!state.isMax(),1,"se movio!",tabaux,state.getFichasJ(),state.getFichasCPU());
			}
			
		}
		
		
		return res;
	}
	
	
	public EstadoNMM eliminarFicha(EstadoNMM state, int i){
		int[] tabaux=new int[24];
		for(int j=0;j<24;j++){tabaux[j]=state.getTablero()[j];}
		int turno=state.getTurn();
		tabaux[i]=0;
		EstadoNMM res;
		if(turno==1){
			res = new EstadoNMM(!state.isMax(),2,"se elimino!",tabaux,state.getFichasJ(),state.getFichasCPU());
		}else{
			res = new EstadoNMM(!state.isMax(),1,"se elimino!",tabaux,state.getFichasJ(),state.getFichasCPU());
		}
		return res;
	}
	
	
	
	private boolean verificarMolino(int i, int[] tabaux, int turno) {
	
		return false;
	}
	
	
	
}
