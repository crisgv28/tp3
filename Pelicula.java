import javax.swing.JOptionPane;
/**
 * Write a description of class Pelicula here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pelicula
{
    String show_id;
    String tipo;
    String titulo;
    String director;
    String cast;
    String[] actores;
    String país_de_procedencia;
    String fecha_agregacion;
    int ano_produccion;
    String audiencia;
    String duracion;
    String categoria;
    String[] categ_vect;
    String descripcion;
    
    public Pelicula(String s1,String s2,String s3,String s4,String s5,String s6,String s7,int s8,String s9,String s10,String s11,String s12){
        show_id = s1;
        tipo = s2;
        titulo = s3;
        director = s4;
        cast = s5;
        cast = cast.toLowerCase();
        actores = cast.split(", ");
        //lo siguiente ordena el vector de actores
        // for(int i =0; i<actores.length;i++){
            // for(int j = i; j<actores.length; j++){
                // if(actores[j].compareTo(actores[i])<0){
                    // String tmp = actores[i];
                    // actores[i] = actores[j];
                    // actores[j] = tmp;
                // }
            // }
        // }
        país_de_procedencia = s6;
        fecha_agregacion = s7;
        ano_produccion = s8;
        audiencia = s9;
        duracion = s10;
        categoria = s11;
        categoria = categoria.toLowerCase();
        categ_vect = categoria.split(", ");
        descripcion = s12;
    }
    
    public String[] separarActores(){ // toma una pelicula y retorna un vector con sus actores
        String[] vectorActores = cast.split(", ");
        return vectorActores;
    }
    
    public String[] separarCategorias(){ // toma una pelicula y retorna un vector con sus categorias
        String[] vectorCategorias = categoria.split(", ");
        return vectorCategorias;
    }
    
    public void quitarCategorias(int k){ //del vector de categorias quita las categoria i y las anteriores
        String[] vector_nuevo;
        if(categ_vect!=null){
            if(categ_vect.length!=1){
                vector_nuevo = new String[categ_vect.length-k];
                for(int i = 0; i<vector_nuevo.length;i++){
                    vector_nuevo[i]=categ_vect[i+k];
                }
            }else{
                vector_nuevo=null;
            }
            categ_vect=vector_nuevo;
        }
    }
    
    public void quitarActores(int k){ //del vector de categorias quita las categoria i y las anteriores
        String[] vector_nuevo;
        if(categ_vect!=null){
            if(categ_vect.length!=1){
                vector_nuevo = new String[categ_vect.length-k];
                for(int i = 0; i<vector_nuevo.length;i++){
                    vector_nuevo[i]=categ_vect[i+k];
                }
            }else{
                vector_nuevo=null;
            }
            categ_vect=vector_nuevo;
        }
    }
    

}
