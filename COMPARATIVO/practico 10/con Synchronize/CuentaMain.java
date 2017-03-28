public class CuentaMain extends Thread{
  private Cuenta cuenta;
  private String nombre;
  public CuentaMain(Cuenta c,String n){
    this.cuenta = c;
    this.nombre = n;
  }

  public void run(){ //hay que redefinir esta funcion, aca tenemos que poner que queremos que haga cada hilo
    int i=0;
    for(i=0;i<100;i++){
      c.deposita(1);
      System.out.println ("Soy "+nombre+" y deposite 1");
    }

  }

  public void main(){
    Cuenta c = new Cuenta(10);
    CuentaMain c1 = new CuentaMain(c,"A");
    CuentaMain c2 = new CuentaMain(c,"B");
    c1.start();
    c2.start();
    System.out.println( "El saldo actual de la cuenta es "+c.getSaldo())

  }



}
