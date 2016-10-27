public class Main {

    public static void main(String[] args){
	int i =0;
	int cantidadBasura=0;
	boolean continuar =true;
	Basura cochinada;
	while(continuar){
		cochinada=new Basura(i,continuar,cantidadBasura);
		cantidadBasura++;
		i++;

	}
	System.out.println("quedan "+cantidadBasura+" basuras");
}
}











