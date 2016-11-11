public class Semaforo{
  private int cant;
  public Semaforo (){
    cant=0;
  }
  public  synchronized void init(int c){
    cant=c;
  }
  public  synchronized void p(){
    while(cant==0){
      try{
        System.out.println("Espero");
        wait();}catch(Exception e){};
    }
    cant--;
  }
  public  synchronized void v(){
    cant++;
    try{notify();}catch(Exception e){};
  }

}
