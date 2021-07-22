import javax.swing.JOptionPane;
public class Arbol
{
    Arbol rama_izq;     //rama izquierda
    String hilera;      //valor del nodo
    Arbol rama_der;     //rama derecha

    public Arbol(String s){
        rama_izq=null;
        hilera=s;
        rama_der=null;
    }

    public int demeSuPeso(){
        int r=1;
        if (rama_izq!=null)
            r+=rama_izq.demeSuPeso();
        if (rama_der!=null)
            r+=rama_der.demeSuPeso();
        return r;
    }

    public void add(String s){ //agrega valor
        if (hilera.compareTo(s) < 0){                             // valor entrante va a la derecha
            if (rama_der == null){
                rama_der = new Arbol(s);
            }else{
                rama_der.add(s);
            }
        }else{
            if ((hilera.compareTo(s)>0) && (rama_izq == null)){ //v puede ir a la izquierda
                rama_izq = new Arbol(s);
            }else{
                if (hilera != s)                     //omito los duplicados
                    rama_izq.add(s);
            }
        }
    }

    public String demeIPD(){
        String r="";
        if (rama_izq!=null)
            r+=rama_izq.demeIPD();
        r+=hilera+" ";
        if (rama_der!=null)
            r+=rama_der.demeIPD();
        return r;
    }

    public String demeDPI(){
        String r="";
        if (rama_der!=null)
            r+=rama_der.demeDPI();
        r+=hilera+" ";
        if (rama_izq!=null)
            r+=rama_izq.demeDPI();
        return r;
    }

    public String demeDPI90(String t){
        String r="";
        if (rama_der!=null)
            r+=rama_der.demeDPI90(t+"\t");
        r+=t+hilera+"\n";
        if (rama_izq!=null)
            r+=rama_izq.demeDPI90(t+"\t");
        return r;
    }

    public String muestre(String t){
        String r="";
        if (rama_der!=null){
            r+=rama_der.muestre(t+"\t \t \t");
        }
        r+=t+hilera+"\n";
        if (rama_izq!=null){
            r+=rama_izq.muestre(t+"\t \t \t");
        }
        return r;
    }

}
