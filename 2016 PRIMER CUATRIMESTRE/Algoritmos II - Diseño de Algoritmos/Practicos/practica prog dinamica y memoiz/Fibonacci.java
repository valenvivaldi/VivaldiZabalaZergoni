import java.util.*;

public class Fibonacci {
	
	
	public static void main(String[] args){
		Scanner en= new Scanner(System.in);
		System.out.println("Ingrese el numero sobre el cual quiere calcular su fibonacci");
		int n = en.nextInt();
		
		
		
		if (n==1||n==0){ 
			System.out.println("El fibonacci de "+n+" es 1");
			
			}else{
		
				int[] arreglo = new int[n+1];
			arreglo[0]=1;
			arreglo[1]=1;
			for (int i = 2; i<n+1;i++){
				arreglo[i]=arreglo[i-1]+arreglo[i-2];
				}
					System.out.println("El fibonacci de "+n+" es "+arreglo[n-1]);

			
			}
					
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
