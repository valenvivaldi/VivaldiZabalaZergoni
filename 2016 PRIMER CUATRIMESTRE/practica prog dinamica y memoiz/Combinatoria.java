import java.util.*;
public class Combinatoria {
	private static Map<Par,Integer> cache = new HashMap<Par,Integer>();
	
	public static void main(String[] args){
		Scanner en= new Scanner(System.in);
		System.out.println("Ingrese los numeros sobre el cual quiere calcular su combinatoria, primero el de arriba y despues el de abajo");
		int n = en.nextInt();
		int m = en.nextInt();
		Par a = new Par(n,m);
		System.out.println("La combinatoria de "+n+" y "+m+" es "+combinat(a));
					
		}
	
	public static int combinat(Par a){
		int n=a.obtenerN();
		int m = a.obtenerM();
		if(n==m||m==0){return 1;};
		
		Par b =new Par(n-1,m);
		Par c = new Par(n-1,m-1);
		return memocombinat(b)+memocombinat(c);
		
		}
		
	public static int memocombinat (Par a){
		if (!cache.containsKey(a)){
			
			cache.put(a,combinat(a));
			}
		return cache.get(a);
		
		}
	
	
	
	
	
	
	
	
	
	
	
	}
