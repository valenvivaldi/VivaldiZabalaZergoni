/**
 * Una clase auxiliar para guardar dos capicuas de 5 digitos que resuelven el problema.
*/
public class ParCapicuas {
    private Capicua5D a;
    private Capicua5D b;
    
    public ParCapicuas(Capicua5D a, Capicua5D b) {
        this.a = a;
        this.b = b;
    }
    
    public Capicua5D primero() {
        return this.a;
    }
    
    public Capicua5D segundo() {
        return this.b;
    }
    
    @Override
    public String toString() {
        return "(" + this.a.toString() + ", " + this.b.toString() + ")";
    }
    
}
