public class CuentaMain extends Thread{
  private Cuenta cuenta;
  private String nombre;

  public CuentaMain(Cuenta c,String n){
    this.cuenta = c;
    this.nombre = n;

  }

  public void run(){ //hay que redefinir esta funcion, aca tenemos que poner que queremos que haga cada hilo
    int i;
    for(i=0;i<1000;i++){

        cuenta.deposita(1);
        System.out.println ("Soy "+nombre+" y deposite 1 Y EL SALDO ES: "+cuenta.getSaldo());

    }

  }

  public static void main(String[] args){
    Cuenta c = new Cuenta(0);
    CuentaMain c1 = new CuentaMain(c,"A");
    CuentaMain c2 = new CuentaMain(c,"B");
    c1.start();
    c2.start();



    //BUSCAR CYCLIC BARRIER!!!!


// HBRIA QUE HACER UN EJEMPLO CON 2 HILOS DISTINTOS UNO DE PRODUCCION Y OTRO DE CONSUMICION



    System.out.println( "El saldo actual de la cuenta es "+c.getSaldo());

  }



}
