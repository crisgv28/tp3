
/**
 * Clase lista de peliculas
 * 
 * @author (b32927) 
 * @version (final)
 */
public class Lista
{
    Pelicula pelicula; //valor del nodo
    boolean usado;     // bandera de uso
    Lista next;        // dir del sgte nodo
    
    public Lista(){ //crea una lista nula
        usado=false;
        next=null;
    }
    
    public Lista(Pelicula p){ //crea la lista y anade la pelicula p
        pelicula = p;
        usado = true;
    }
    
    public Lista(Pelicula p, Lista n){ //crea una lista, anade p y lista n al next
        pelicula=p;
        usado=true;
        next = n;
    }
    
    public String toString(){ // devuelve una hilera con los titulos de las peliculas pertenecientes a una lista
        if (!usado)
            return " ";
        else
        if (next==null){
            return " -> "+pelicula.titulo;
        }
        else {
            return " -> "+ pelicula.titulo+next.toString();
        }
    }
    
    public void add(Pelicula p){ //anade al final
        if (!usado){  //caso lista vacia
            usado=true;
            pelicula=p;
        }else{
            //recursivo
            if (next==null){ //caso de solo 1 valor en la lista
                next = new Lista(p);
            }else{
                next.add(p); //cualquier otro caso
            }
        }
    }
    
}
