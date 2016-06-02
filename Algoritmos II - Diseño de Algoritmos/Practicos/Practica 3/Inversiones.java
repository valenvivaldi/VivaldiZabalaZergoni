public class Inversiones {
		
		
/*		int a[];
		int pri_indice;
		int ult_indice;
		int pivote;
		
		int aux;
		
		public int inversiones (int[] a, int pri_indice, int ult_indice){
			
			if(ult_indice<=pri_indice){return 0;}
			int aux=0;
			int pivote = particion(pri_indice,ult_indice);
			aux += contarinversos(a,pri_indice,ult_indice,pivote);
			aux += inversiones(a,pri_indice,pivote-1);
			aux += inversiones(a,pivote,ult_indice);
			
			return aux;
			
			
			}
	
		public int particion (int p, int u){
			
			
			}
	
	
*/
	int[] a = {1,2,5,3,4};



	public int inversiones(int[] a){
		if (a.length ==0 ||a.length ==1){return 0;}
		int aux =0;
		int medio = (a.length / 2);
		int[] b;
		System.arraycopy(a,0,medio,b,0,medio+1);
		int[] c;
		System.arraycopy(a,(medio+1),(a.length-1),b,0,((a.length-1)-(medio+1)));
		aux += inversiones (b);
		aux += inversiones (c);
		aux += mergeinv (b,c);
		
		return aux;
			
		} 
	
	public int mergeinv(int[] b, int[] c){
		int i =0;
		int j=0;
		int aux =0;
		while (i<b.length &&j<c.length){
			if(c[j]<b[i]){
				aux++;
				j++;
				
				}else{i++;}
			
			}
		

		
		
		}
	
	
	}

