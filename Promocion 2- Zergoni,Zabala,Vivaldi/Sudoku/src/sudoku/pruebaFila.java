package sudoku;

import java.util.Arrays;

import org.jgap.InvalidConfigurationException;

public class pruebaFila {
	public static void main(String[] args) throws InvalidConfigurationException {
		int[][] matriz=   {{5,3,7,2,7,8,5,3,7},
						  {6,4,1,1,9,5,1,4,2},
						  {2,9,8,3,6,4,9,6,8},
						  {8,1,3,7,5,6,4,2,3},
						  {4,5,6,8,4,3,8,9,1},
						  {7,2,9,9,2,1,7,5,6},
						  {3,6,5,6,3,7,2,8,4},
						  {9,8,4,4,1,9,3,1,5},
						  {1,7,2,5,8,2,6,7,9}};
		cantidadRepeticionesFilas(matriz);
		
		
	}
	
	
	
	public static int cantidadRepeticionesFilas(int[][] aux) {
		int[] arreglorep =new int[9];
		Arrays.fill(arreglorep,0);
		int res =0;
		int i;
		int j;
		for( i=0;i<9;i++){
			Arrays.fill(arreglorep,0);
			for(j=0;j<9;j++){
				arreglorep[(aux[i][j])-1]+=1;
			};
			System.out.println("fila "+i);
			for(j=0;j<9;j++){
				
				System.out.print(arreglorep[j]);
				}
			System.out.println("");
			for(j=0;j<9;j++){
				if(arreglorep[j]>1){res+=arreglorep[j]-1;}
			}
			System.out.println("Hasta la fila "+i+" hay "+res+" repeticiones");
		
		}
		return res;
	}
}
