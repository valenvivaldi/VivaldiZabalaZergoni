public class Main {
	public static int numerados =10;
	ublic static Integer denominador =0;
	public statc float division;

	public static void main(String[] args){
		System.out.println("antes de hacer la division");
		try{
			division=numerador/denominador;
		}catch(ArithmeticException ex){
			division =0;
			System.out.println("Error"+ex.getMessage());
		}finally{
			System.out.println("Division:"+division);
			System.out.println("DESPUES DE HACER LA DIVISION");
		}



	}




}