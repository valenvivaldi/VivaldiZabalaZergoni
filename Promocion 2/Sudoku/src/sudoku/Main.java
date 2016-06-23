package sudoku;
import org.jgap.*;
import org.jgap.impl.DefaultConfiguration;
import org.jgap.impl.IntegerGene;

//import java.util.*;

public class Main {
	
	public static void main(String[] args) throws InvalidConfigurationException {
		  int cantidadEvoluciones=87000;
		  
		  int tamañoPoblacion = 7;
		  int cantEvolCheck=1000;
		  boolean nolimit =true;
		  
		  
		  int[][] nivel1={{7,6,2,3,9,8,5,4,1},
		  		          {9,8,4,0,0,7,2,3,6},
		  		          {1,5,3,2,6,4,9,8,7},
		  		          {4,7,8,5,0,3,1,6,9},
		  		          {5,2,6,0,0,9,8,7,3},
		  		          {3,1,9,8,0,0,4,2,5},
		  		          {8,3,5,0,0,1,6,9,2},
		  		          {2,9,7,6,8,5,3,1,4},
		  		          {6,4,1,9,3,2,7,5,8}};
		  
		  
		  
		  	int[][] nivel3={{0,2,8,0,3,0,0,0,0},
				  		   {0,0,5,8,0,0,6,7,0},
				  		   {4,0,0,2,0,0,0,0,0},
				  		   {0,8,0,5,0,6,0,0,4},
				  		   {0,0,2,3,7,8,0,0,0},
				  		   {0,6,0,9,4,0,5,0,0},
				  		   {0,0,0,4,2,0,8,0,5},
				  		   {8,0,3,0,6,0,0,0,0},
				  		   {0,0,0,7,8,0,0,3,0}};
		  	int[][] nivel31={
					   {5,3,0,6,0,0,0,9,8},
					   {0,7,0,1,9,5,0,0,0},
					   {0,0,0,0,0,0,0,6,0},
					   {8,0,0,4,0,0,7,0,0},
					   {0,6,0,8,0,3,0,2,0},
					   {0,0,3,0,0,1,0,0,6},
					   {0,6,0,0,0,0,0,0,0},
					   {0,0,0,4,1,9,0,8,0},
					{2,8,0,0,0,5,0,7,9}};
		  	
		  	
		  	
		  
		  int[][] niveldios={{0,0,0,0,0,0,0,0,0},
							  {0,0,0,0,0,0,0,0,0},
							  {0,0,0,0,0,0,0,0,0},
							  {0,0,0,0,0,0,0,0,0},
							  {0,0,0,0,0,0,0,0,0},
							  {0,0,0,0,0,0,0,0,0},
							  {0,0,0,0,0,0,0,0,0},
							  {0,0,0,0,0,0,0,0,0},
							  {0,0,0,0,0,0,0,0,0}};

		  int[][]matriz=nivel3;		  
				  
				  
		  Configuration conf = new DefaultConfiguration();	  
				  
		  FitnessFunction myFunc =new SudokuFitnessFunction( matriz );

		  conf.setFitnessFunction( myFunc );

		  int cantidadDeGenes=contabilizarVacios(matriz); 
		  
		  
		  
		  Gene[] arregloGenes = new Gene[ cantidadDeGenes];
		  for(int i=0;i<cantidadDeGenes;i++){
		  	arregloGenes[i] = new IntegerGene(conf, 1, 9 );  
		  }

		  Chromosome CromosomaSudoku = new Chromosome(conf, arregloGenes );

		  conf.setSampleChromosome( CromosomaSudoku);

		  conf.setPopulationSize(tamañoPoblacion);
		  
		  Genotype poblacionSudoku = Genotype.randomInitialGenotype( conf );
		  int i=0;
		  boolean continuar=true;
		  while((nolimit||i<cantidadEvoluciones)&&continuar){
			  poblacionSudoku.evolve();
			  i++;
		  
			  if(i%cantEvolCheck == 0 ){
				  
				  IChromosome posibleSolucion = poblacionSudoku.getFittestChromosome();
				 
				  ((SudokuFitnessFunction) myFunc).imprimirRepeticiones(posibleSolucion);
				
				  if(((SudokuFitnessFunction) myFunc).exito(posibleSolucion)){
					  ((SudokuFitnessFunction) myFunc).imprimirRepeticiones(posibleSolucion);
					  continuar=false;
					  }
				
			
		  }
		  
					  
		  }
		  IChromosome posibleSolucion = poblacionSudoku.getFittestChromosome();  
		  System.out.println("Haciendo "+i+" evoluciones se obtuvo la siguiente solucion! POBLACION DE TAMAÑO "+tamañoPoblacion);
		  imprimirPosibleSolucion(matriz,posibleSolucion);
	      if(((SudokuFitnessFunction) myFunc).exito(posibleSolucion)){
			System.out.println("Esta configuracion es correcta!");
		  
		  }
	      ((SudokuFitnessFunction) myFunc).imprimirRepeticiones(posibleSolucion);
		  
		 // System.out.println("Haciendo "+cantidadEvoluciones+" se obtuvo la siguiente solucion!");
		  //IChromosome posibleSolucion = poblacionSudoku.getFittestChromosome();
		  
		  //imprimirPosibleSolucion(matriz,posibleSolucion);
		
		 // if(((SudokuFitnessFunction) myFunc).exito(posibleSolucion)){System.out.println("Esta configuracion es correcta!");}
		
		
		
		

	}

	private static int contabilizarVacios(int[][] matriz) {
		int res=0;
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				if(matriz[i][j]==0){res++;}
			}
		}
		System.out.println("Se contabilizaron "+res+" espacios vacios");
		return res;
	}

	public static void imprimirPosibleSolucion(int[][] matriz, IChromosome cromosoma){
	
		int indicecrom =0;
		for(int i=0;i<9;i++){
			for(int 
					j=0;j<9;j++){
					if(matriz[i][j]!=0){
						System.out.print(matriz[i][j]+"|");
					}else{
						System.out.print(SudokuFitnessFunction.getAlelo(cromosoma,indicecrom)+"|");
						indicecrom++;
					}
			}
			System.out.println("");
			System.out.println("----------------");
		}
	};
		

}
