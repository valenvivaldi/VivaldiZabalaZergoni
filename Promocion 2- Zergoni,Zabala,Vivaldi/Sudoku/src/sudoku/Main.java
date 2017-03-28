package sudoku;
import org.jgap.*;
import org.jgap.impl.DefaultConfiguration;
import org.jgap.impl.IntegerGene;

//import java.util.*;

public class Main {
	/* ALGUNOS DETALLES ACERCA DEL MAIN
	 * Al Comienzo del main se setean variables que modifican el comportamiento del programa
	 * - la variable cantidadEvoluciones dice el limite de evoluciones que va a hacer el programa antes de
	 * cortar, la variable nolimit indica si itera sin limite hasta encontrar la solucion correcta o si utiliza
	 * el limite de evoluciones anterior.
	 * -cantEvolCheck indica cada cuantas evoluciones se hace un chequeo sobre el mejor de la poblacion e imprime
	 * la cantidad de errores que posee, ademas si detecta que es una solucion correcta hace que el ciclo corte,
	 * 
	 * - abajo definimos varias matricez que usamos de ejemplo, el main trabaja con la variable "matriz" que se 
	 * encuentra abajo de los ejemplos
	 * */
	
	public static void main(String[] args) throws InvalidConfigurationException {
		  int cantidadEvoluciones=87000;
		  int tamañoPoblacion = 10000;
		  int cantEvolCheck=1;
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
		  	
		  	
		  	
	  int[][] nivel2={{5,3,0,0,7,0,0,0,0},
					  {6,0,0,1,0,5,0,0,0},
					  {0,9,8,0,0,0,0,6,0},
					  {8,0,0,0,0,0,0,0,3},
					  {4,0,0,8,0,3,0,0,1},
					  {7,0,0,0,2,0,0,0,6},
					  {0,6,0,0,0,0,2,8,0},
					  {0,0,0,4,1,9,0,0,5},
					  {0,0,0,0,8,0,0,7,9}};


		  int[][] niveldios={{0,0,0,0,0,0,0,0,0},
							  {0,0,0,0,0,0,0,0,0},
							  {0,0,0,0,0,0,0,0,0},
							  {0,0,0,0,0,0,0,0,0},
							  {0,0,0,0,0,0,0,0,0},
							  {0,0,0,0,0,0,0,0,0},
							  {0,0,0,0,0,0,0,0,0},
							  {0,0,0,0,0,0,0,0,0},
							  {0,0,0,0,0,0,0,0,0}};

		  int[][] nivelraul2 = {
			        {0, 0, 0, 4, 2, 8, 0, 0, 0},
			        {4, 5, 0, 1, 7, 6, 0, 3, 2},
			        {0, 8, 0, 3, 9, 5, 0, 4, 1},
			        {0, 9, 0, 5, 8, 0, 7, 0, 0},
			        {0, 0, 0, 2, 0, 7, 0, 9, 3},
			        {7, 2, 0, 9, 0, 0, 5, 6, 0},
			        {5, 6, 8, 0, 3, 4, 2, 0, 9},
			        {0, 1, 0, 8, 0, 0, 3, 7, 6},
			        {0, 0, 0, 0, 1, 0, 4, 8, 0}
			};
		  
		  int[][] nivelraul = {
			        {0, 0, 6, 4, 2, 8, 0, 0, 0},
			        {4, 5, 0, 1, 7, 6, 0, 3, 2},
			        {0, 8, 7, 3, 9, 5, 0, 4, 1},
			        {0, 9, 3, 5, 8, 0, 7, 0, 0},
			        {0, 4, 0, 2, 0, 7, 0, 9, 3},
			        {7, 2, 0, 9, 0, 0, 5, 6, 0},
			        {5, 6, 8, 0, 3, 4, 2, 0, 9},
			        {0, 1, 0, 8, 0, 0, 3, 7, 6},
			        {0, 7, 0, 6, 1, 0, 4, 8, 0}
			};
		  
		  
		  
		  //MATRIZ CON LA QUE SE TRABAJA!!
		  int[][]matriz=nivel1;		  
				  
				  
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

	
	/*Esta funcion cuenta la cantidad de espacios vacios del sudoku, lo que nos permite saber cuantos genes 
	 * vamos a usar
	 * */
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

	
	
/*
 * imprime el sudoku rellenando los espacios vacios con los datos del cromosoma
 * */
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
