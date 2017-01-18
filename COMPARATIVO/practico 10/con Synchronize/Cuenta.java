public class Cuenta{
  private int saldo;
  public Cuenta (int saldoInicial){
    saldo=saldoInicial;
  }
  public synchronized void deposita(int monto){
    saldo +=monto;
  }
  public synchronized void retira(int monto){
    saldo -=monto;
  }
  public synchronized int getSaldo(){
    return saldo;
  }
}
