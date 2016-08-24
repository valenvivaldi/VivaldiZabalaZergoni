//  INTEGRANTES DEL GRUPO: BRUNO ZERGONI, JOAQUIN ZABALA Y VALENTIN VIVALDI
//
//
//

import java.util.Scanner; // usamos esta clase para cargar valores por teclado
import java.util.Arrays;
import java.util.*;
public class Hamming {
//Este programa implementa una solucion para el ejercicio 1 del practico del
	public static void main (String args[]) {
		int k; // creo una variable que va a guardar el valor k con el que se quiere trabajar
		int largocadenas; // creo una variable que almacene el largo de las palabras con las que amos a trabajar
		Scanner en=new Scanner(System.in); // Usamos la clase scanner para obtenr los valores de k y largocadenas por teclado
		System.out.println("Cual sera el numero k ?");
		k=en.nextInt();

		System.out.println("De que largo seran las palabras ??");
		largocadenas=en.nextInt();
		int[] arreglo= new int[largocadenas]; //Creamos un arreglo del mismo largo de las cadenas
		Arrays.fill(arreglo, 0);//lo llenamos de 0's
		System.out.println("Vamos a cargar las palabras");
		LinkedList<String> cadenas= new LinkedList<String>();  //creamos una lista, en ella vamos a guardar las palabras con las que vamos a trabajar 
		int opcion=1;

	// hacemos un ciclo para cargarlas cadena
		while (opcion==1){
			System.out.println("ingrese una palabra de "+largocadenas+" elementos");
			cadenas.add(en.next()); 
			System.out.println("Desea seguir cargando cadenas? 1 = si 2=no");
			opcion=en.nextInt();
			}
		
		
		// mostramos cuales son las palabras ingresadas
		System.out.println("se buscara una palabra que tenga una distancia de hamming menor o igual a "+k+" con c/u de la siguientes palabras");
		int i=0;    
		while(i!=cadenas.size()){
			System.out.println(cadenas.get(i));
			i++;			
			}
			
		String cadenaresultado = busquedaHamming(arreglo, cadenas, k); // la funcion busquedaHamming devuelve la cadena que es resultado al problema
		// Si es que no existe solucion al problema, va a devolver una cadena mas larga que las otras	
		System.out.println("RESULTADO:");
		if (cadenaresultado.length()==largocadenas){	
		System.out.println(cadenaresultado);}else{System.out.println("NO EXISTE UNA CADENA QUE SOLUCIONE EL PROBLEMA");}
			
			
			
		}

	//Esta funcion convierte un arreglo de numeros a un String
	public static String convertirAString(int[] a){
		String result = "";
		int i=0;
		while (i<a.length){
			result = result + Integer.toString(a[i]);
			i++;
			}
		return result;
		}
	
	//Esta funcion calcula la distancia de Hamming entre dos cadenas
	public static int distancia(String a, String b){
		int resultado=0;
		int i=0;
		while (i<a.length()){
			if (a.charAt(i)!=b.charAt(i)){
				resultado++;
				}
			i++;
			
			}
		return resultado;
	}

	//nosotros usamos un arreglo de digitos para representar una cadena, para ir probando las distintas cadenas 
	//necesitamos aumentar el numero que representa, esta funcion incrementa en uno la unidad y si llega a diez, la pone en 0 y le aumenta en 1 
	//a la decena y vuelve a verificar lo mismo.. Esto lo hacemos para que siempre cada indice del arreglo represente un digito nomas
	public static int[] aumentar(int[] arreglo){
		int[] a=arreglo;
		int indice = a.length -1;
		a[indice]++;
		while (indice!=0){
			if(a[indice]==10){  //el ciclo es para verificar que siempre los indices sean digitos
				a[indice]=0;
				a[indice-1]++;
			}
			indice--;
		}
		
		
		
	return a;	//devuelve el arreglo una vez incrementado
	}
		
		
	public static String busquedaHamming (int[] arr, LinkedList<String> list, int k){
		String arrString= convertirAString(arr);    //convierte el arreglo en string, se comienza con el arreglo todon en ceros
		while (arrString.length() == list.get(0).length()){  //Esta condicion es porque en el momento que el arreglo convertido en cadena sea mas 
															//largo que las palabras, entonces es que se probo con todos casos y no se encontro solucion						
			
			if (verificar(arrString,list,k)){      //Se utiliza la funcion verificar, y si devuelve falso se incrementa el arreglo, se vuelve a convertir y 
												// se prueba de nuevo...Si devuelve true, entonces se encontro la solucion
				return arrString;
				}
			arr=aumentar(arr);
			arrString= convertirAString(arr);
		}
		return arrString;	
		
		}
		
		
	public static boolean verificar (String a, LinkedList<String> lista,int k){ // Esta funcion devuelve TRUE si el string que se le pasa tiene una 
		boolean result = true;												//distancia de hamming menor a k, con todos los string de la lista que 
																			// se pasa como parametro.. Sino devuelve true.
		int i=0;
		while (result && i<lista.size() ) {
			if (distancia(a, lista.get(i))>k){
				result = false;
				}
		i++;		
		}
		return result;													// que esta funcion devuelva true significa que se encontron una solucion al
																		//problema
																		
		
		
		
		}




}

