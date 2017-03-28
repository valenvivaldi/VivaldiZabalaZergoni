public class Cuenta{
  private int saldo;
  private Semaforo sema;
  public Cuenta (int saldoInicial,Semaforo s){
    saldo=saldoInicial;
    sema=s;
  }
  public  void deposita(int monto){
    //sema.p();
    saldo +=monto;
    //sema.v();
  }
  public  void retira(int monto){
  //  sema.p();
    saldo -=monto;
    // sema.v();
  }
  public  int getSaldo(){

    return saldo;
  }
}
