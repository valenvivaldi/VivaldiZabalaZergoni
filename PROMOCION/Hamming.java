import java.util.Scanner;
import java.util.Arrays;
import java.util.*;
public class Hamming {
	
	public static void main (String args[]) {
		int k;
		int largocadenas;
		Scanner en=new Scanner(System.in);
		System.out.println("Cual sera el numero k ?");
		k=en.nextInt();

		System.out.println("De que largo seran las palabras ??");
		largocadenas=en.nextInt();
		int[] arreglo= new int[largocadenas];
		Arrays.fill(arreglo, 0);
		System.out.println("Vamos a cargar las palabras");
		LinkedList<String> cadenas= new LinkedList<String>(); 
		int opcion=1;

		while (opcion==1){
			System.out.println("ingrese una palabra de "+largocadenas+" elementos");
			cadenas.add(en.next());
			System.out.println("Desea seguir cargando cadenas? 1 = si 2=no");
			opcion=en.nextInt();
			}
		
		System.out.println("se buscara una palabra que tenga una distancia de hamming menor o igual a "+k+" con c/u de la siguientes palabras");
		int i=0;
		while(i!=cadenas.size()){
			System.out.println(cadenas.get(i));
			i++;			
			}
			
		String cadenaresultado = busquedaHamming(arreglo, cadenas, k); 	
		System.out.println("RESULTADO:");
		if (cadenaresultado.length()==largocadenas){	
		System.out.println(cadenaresultado);}else{System.out.println("NO EXISTE UNA CADENA QUE SOLUCIONE EL PROBLEMA");}
			
			
			
		}

	public static String convertirAString(int[] a){
		String result = "";
		int i=0;
		while (i<a.length){
			result = result + Integer.toString(a[i]);
			i++;
			}
		return result;
		}
	
	
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

	public static int[] aumentar(int[] arreglo){
		int[] a=arreglo;
		int indice = a.length -1;
		a[indice]++;
		while (indice!=0){
			if(a[indice]==10){
				a[indice]=0;
				a[indice-1]++;
			}
			indice--;
		}
		
		
		
	return a;	
	}
		
		
	public static String busquedaHamming (int[] arr, LinkedList<String> list, int k){
		String arrString= convertirAString(arr);
		while (arrString.length() == list.get(0).length()){
			if (verificar(arrString,list,k)){
				return arrString;
				}
			arr=aumentar(arr);
			arrString= convertirAString(arr);
		}
		return arrString;	
		
		}
	public static boolean verificar (String a, LinkedList<String> lista,int k){
		boolean result = true;
		int i=0;
		while (result && i<lista.size() ) {
			if (distancia(a, lista.get(i))>k){
				result = false;
				}
		i++;		
		}
		return result;
		
		
		
		}




}

