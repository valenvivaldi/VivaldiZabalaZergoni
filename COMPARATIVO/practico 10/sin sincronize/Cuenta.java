public class Cuenta{
  private int saldo;

  public Cuenta (int saldoInicial){
    saldo=saldoInicial;

  }
  public  void deposita(int monto){

    saldo +=monto;

  }
  public  void retira(int monto){

    saldo -=monto;
  
  }
  public  int getSaldo(){

    return saldo;
  }
}
