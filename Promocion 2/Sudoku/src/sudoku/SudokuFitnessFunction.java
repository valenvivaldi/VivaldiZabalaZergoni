package sudoku;



import org.jgap.FitnessFunction;
import org.jgap.IChromosome;
import java.util.*;

public class SudokuFitnessFunction extends FitnessFunction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int[][] matriz; 
	
	public SudokuFitnessFunction (int[][] m){
		if(m.length == 9 && (m[1]).length==9){
			matriz=m;
		
		
		
		
		}else{
            throw new IllegalArgumentException("Tamaño de matriz del sudoku erronea" );
        }
		
		
		
	}
	
	public static int getAlelo( IChromosome a_potentialSolution, int a_position ){
		Integer num =(Integer) a_potentialSolution.getGene(a_position).getAllele();

		return num.intValue();
	}
	
	
	
	
	public boolean exito(IChromosome cromosoma){
		int[][] aux = new int[9][9];
		int indicecrom =0;
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				if(matriz[i][j] !=0){
					aux[i][j]=matriz[i][j];
				}else{
					aux[i][j]=getAlelo(cromosoma,indicecrom);
					indicecrom++;
				}
				
			}
		};
		
		int repGlob=cantidadRepeticionesGlobales(aux);
		int repCuad=cantidadRepeticionesCuadrante(aux);
		int repFil=cantidadRepeticionesFilas(aux);
		int repCol=cantidadRepeticionesColumnas(aux);
		
		return(repGlob+repCuad+repFil+repCol==0);
	
	}
	public void imprimirRepeticiones(IChromosome cromosoma){
		int[][] aux = new int[9][9];
		int indicecrom =0;
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				if(matriz[i][j] !=0){
					aux[i][j]=matriz[i][j];
				}else{
					aux[i][j]=getAlelo(cromosoma,indicecrom);
					indicecrom++;
				}
				
			}
		};
		
		int repGlob=cantidadRepeticionesGlobales(aux);
		int repCuad=cantidadRepeticionesCuadrante(aux);
		int repFil=cantidadRepeticionesFilas(aux);
		int repCol=cantidadRepeticionesColumnas(aux);
		System.out.println("repGlob = "+repGlob );
		System.out.println("repCuad = "+repCuad );
		System.out.println("repFil = "+repFil );
		System.out.println("repCol = "+repCol );
		System.out.println("----------------");

	
	
	}
	
	
	public double evaluate(IChromosome cromosoma) {
		double fitness;
		int[][] aux = new int[9][9];
		int indicecrom =0;
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				if(matriz[i][j] !=0){
					aux[i][j]=matriz[i][j];
				}else{
					aux[i][j]=getAlelo(cromosoma,indicecrom);
					indicecrom++;
				}
				
			}
		};
		
		int repGlob=cantidadRepeticionesGlobales(aux);
		int repCuad=cantidadRepeticionesCuadrante(aux);
		int repFil=cantidadRepeticionesFilas(aux);
		int repCol=cantidadRepeticionesColumnas(aux);
		fitness=0;
		fitness+=81000-(1000*repGlob);
		fitness+=50000-(500*(repFil));
		fitness+=50000-(500*(repCol));
		fitness+=20000-(1000*(repCuad));
		
		
		return fitness;		
	}

	
	
	
	
	private int cantidadRepeticionesColumnas(int[][] aux) {
		int[] arreglorep =new int[9];
		Arrays.fill(arreglorep,0);
		int res =0;
		int i;
		int j;
		for( j=0;j<9;j++){
			Arrays.fill(arreglorep,0);
			for(i=0;i<9;i++){
				arreglorep[(aux[i][j])-1]+=1;
			}	
			for(i=0;i<9;i++){
				if(arreglorep[i]>1){res+=arreglorep[i]-1;}
			}
		
		}
		return res;
	}
	
	
	
	
	
	
	
	private int cantidadRepeticionesFilas(int[][] aux) {
		int[] arreglorep =new int[9];
		Arrays.fill(arreglorep,0);
		int res =0;
		int i;
		int j;
		for( i=0;i<9;i++){
			Arrays.fill(arreglorep,0);
			for(j=0;j<9;j++){
				arreglorep[(aux[i][j])-1]+=1;
			}	
			for(j=0;j<9;j++){
				if(arreglorep[j]>1){res+=arreglorep[j]-1;}
			}
		
		}
		return res;
	}

	
	
	
	
	
	
	private int cantidadRepeticionesCuadrante(int[][] aux) {
		int[][] repxcuad=new int[9][9]; 
		// repxcuad[x][y] = repeticiones del valor y en el cuadrante (x+1);
		int i;
		int j;
		for( i=0;i<9;i++){
			for(j=0;j<9;j++){
				if(i<3){ //cuad 1-2-3
					if(j<3){repxcuad[0][aux[i][j]-1]++;}
					if(2<j&&j<6){repxcuad[1][aux[i][j]-1]++;}
					if(j>5){repxcuad[2][aux[i][j]-1]++;}
				}
				if(2<i&&i<6){//cuad 4-5-6
					if(j<3){repxcuad[3][aux[i][j]-1]++;}
					if(2<j&&j<6){repxcuad[4][aux[i][j]-1]++;}
					if(j>5){repxcuad[5][aux[i][j]-1]++;}
				}
				if(i>5){//cuad 7-8-9
					if(j<3){repxcuad[6][aux[i][j]-1]++;}
					if(2<j&&j<6){repxcuad[7][aux[i][j]-1]++;}
					if(j>5){repxcuad[8][aux[i][j]-1]++;}
				}
				
				
			}
		
		}
		int res=0;
		for( i=0;i<9;i++){
			for(j=0;j<9;j++){
				if(repxcuad[i][j]>1){res+=repxcuad[i][j]-1;}
				
			}
		}
		return res;	
	}

	
	
	
	
	
	
	
	
	private int cantidadRepeticionesGlobales(int[][] aux) {
		int[] arreglorep =new int[9];
		Arrays.fill(arreglorep,0);
		int res =0;
		int i;
		int j;
		for( i=0;i<9;i++){
			for(j=0;j<9;j++){
				arreglorep[(aux[i][j])-1]+=1;
			}	
		}
		for(i=0;i<9;i++){
			if(arreglorep[i]>9){
				res+=(arreglorep[i]-9);
			}
		}
		
		return res;
	}

}
