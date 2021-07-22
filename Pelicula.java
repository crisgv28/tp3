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
    String título;
    String director;
    String cast;
    String país_de_procedencia;
    String fecha_agregacion;
    int ano_produccion;
    String audiencia;
    String duracion;
    String categoria;
    String descripción;
    
    public Pelicula(String s1,String s2,String s3,String s4,String s5,String s6,String s7,int s8,String s9,String s10,String s11,String s12){
        show_id = s1;
        tipo = s2;
        título = s3;
        director = s4;
        cast = s5;
        país_de_procedencia = s6;
        fecha_agregacion = s7;
        ano_produccion = s8;
        audiencia = s9;
        duracion = s10;
        categoria = s11;
        descripción = s12;
    }
    
    public String[] separarCategorias(){ // toma una pelicula y retorna un vector con sus categorias
        String[] vectorCategorias = categoria.split(", ");
        return vectorCategorias;
    }
    

}
