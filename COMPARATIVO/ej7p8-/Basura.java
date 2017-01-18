public class Basura{
	int id=0;
	boolean continuar;
	int cantidadbasura;
	public Basura(int ide,boolean	cont,int cantbasura){
		id=ide;
		continuar=cont;
		cantidadbasura=cantbasura;

		System.out.println("Me crearon! Esto se va a descontroaaaalrrrr SOY "+id);
	}

	public void finalize(){
		System.out.println("Me van a recolectar! AIUDA SOY "+id);
		continuar=false;
		cantidadbasura--;

	
	}

}










