public class CuentaMain extends Thread{
  private Cuenta cuenta;
  private String nombre;
  private Semaforo semafor;
  public CuentaMain(Cuenta c,String n,Semaforo semafor){
    this.cuenta = c;
    this.nombre = n;
    this.semafor=semafor;
  }

  public void run(){ //hay que redefinir esta funcion, aca tenemos que poner que queremos que haga cada hilo
    int i;
    for(i=0;i<1000;i++){
      this.semafor.p();
        cuenta.deposita(1);
        System.out.println ("Soy "+nombre+" y deposite 1 Y EL SALDO ES: "+cuenta.getSaldo());
      this.semafor.v();
    }

  }

  public static void main(String[] args){
    Semaforo sem = new Semaforo();
    sem.init(1);
    Cuenta c = new Cuenta(0,sem);
    CuentaMain c1 = new CuentaMain(c,"A",sem);
    CuentaMain c2 = new CuentaMain(c,"B",sem);
    c1.start();
    c2.start();



    //BUSCAR CYCLIC BARRIER!!!!


// HBRIA QUE HACER UN EJEMPLO CON 2 HILOS DISTINTOS UNO DE PRODUCCION Y OTRO DE CONSUMICION



    System.out.println( "El saldo actual de la cuenta es "+c.getSaldo());

  }



}
