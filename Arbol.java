import javax.swing.JOptionPane;
/**
 * Clase Arbol contiene nodos con las categorias deseadas
 * 
 * @author (b32927) 
 * @version (final)
 */
public class Arbol
{
    Arbol rama_izq;     //rama izquierda
    String hilera;      //categoria
    Lista peliculas;    //lista de peliculas en la categoria
    Arbol rama_der;     //rama derecha

    public Arbol(String s){ //constructor del arbol dado un primer nodo s
        rama_izq=null;
        hilera=s;
        rama_der=null;
        peliculas = new Lista();
    }

    public void add(String s){                                  //agrega categorias al arbol
        if (hilera.compareTo(s) < 0){                           //categoria entrante va a la derecha
            if (rama_der == null){
                rama_der = new Arbol(s);
            }else{
                rama_der.add(s);
            }
        }else{
            if ((hilera.compareTo(s)>0) && (rama_izq == null)){ //categ puede ir a la izquierda
                rama_izq = new Arbol(s);
            }else{
                if (hilera != s)                                //omito los duplicados
                    rama_izq.add(s);
            }
        }
    }

    public String muestre(String t){ //muestra el arbol
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
    
    public String muestrePelisCategoria(String categ){          //retorna una hilera con el nombre de las peliculas que pertenecen a la categoria categ
        String s = categ.toLowerCase();
        String pelis_categ=""; 
        if (hilera.equals(s))                                   //se encontro la categoria buscado
            pelis_categ=peliculas.toString();
        else{
            if (hilera.compareTo(s) < 0){                       //deberia estar en rama derecha
                if (rama_der!=null)
                    return rama_der.muestrePelisCategoria(s);
            }else{
                if (rama_izq!=null)                             //deberia estar en rama izquierda
                    return rama_izq.muestrePelisCategoria(s);
            }
        }
        return pelis_categ;
    }
    
    public String muestrePelisActores(String act){           //retorna una hilera con el nombre de las peliculas que pertenecen a la categoria act
        String s = act.toLowerCase();
        String pelis_acto=""; 
        if (hilera.equals(s))                                //se encontro el actor buscado
            pelis_acto=peliculas.toString();
        else{
            if (hilera.compareTo(s) < 0){                    //deberia estar en rama derecha
                if (rama_der!=null)
                    return rama_der.muestrePelisActores(s);
            }else{
                if (rama_izq!=null)                          //deberia estar en rama izquierda
                    return rama_izq.muestrePelisActores(s);
            }
        }
        return pelis_acto;
    }
    
    //prueba de un metodo para agregar peliculas al arbol
    //por mejorar, en la clase controlador se creo un metodo para agregar que funciona mejor
    public void anadirPelicula(Pelicula p){                                                              //anade peliculas al arbol segun categoria
                Pelicula tmp = p;
                if(tmp.categ_vect!=null && hilera!=null){
                    if(tmp.categ_vect[0].equals(hilera)){
                        System.out.println("son iguales, se agrega ");
                        if(peliculas==null){
                            peliculas = new Lista(p);
                            tmp.quitarCategorias(1);
                            System.out.println("AgregadoA");
                            anadirPelicula(tmp);
                        }else{
                            peliculas.add(p);
                            tmp.quitarCategorias(1);
                            System.out.println("AgregadoB");
                            anadirPelicula(tmp);
                        }
                    }else{
                        System.out.println("No son iguales " + tmp.categ_vect[0] + " - "+ hilera);
                        if(tmp.categ_vect[0].compareTo(hilera)<0 && rama_izq!=null){
                            System.out.println("menor que la hilera");
                            rama_izq.anadirPelicula(tmp);
                            tmp.quitarCategorias(1);
                        }
                        if(tmp.categ_vect[0].compareTo(hilera)>0 && rama_der!=null){
                            System.out.println("mayor que la hilera");
                            rama_der.anadirPelicula(tmp);
                            tmp.quitarCategorias(1);
                        }
                    }
                }
    }
    
    public Lista darPeliculas(){ // devuelve peliculas de un arbol
        return peliculas;
    }
    
    public String darNombresPeliculas(String s){                     //devuelve nombres de las peliculas pertenecientes a una categoria s
        String hilera_peliculas = "";
        if (s.compareTo(hilera)==0){                                 // si se encontro
            hilera_peliculas = peliculas.toString();
        }else{
            if(s.compareTo(hilera)>0){
                hilera_peliculas = rama_der.darNombresPeliculas(s);  
            }else{
                hilera_peliculas = rama_izq.darNombresPeliculas(s);
            }
        }
        return hilera_peliculas;
    }

}
