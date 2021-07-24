import javax.swing.JOptionPane;
import java.util.Scanner;
/**
 * Clase controlador al ejecutar el main la tarea se pone en curso.
 * 
 * @author (b32927) 
 * @version (final)
 */
public class controlador
{
    Pelicula todas_pelis[];
    Arbol arbol;
    
    public controlador(Pelicula[] p){ //crea el controlador y anade un array de peliculas
        todas_pelis = p;
    }
    
    public void anadirArbol(Arbol tree){ //anade el arbol al controlador
        arbol = tree;
    }
    
    public String[] darActores(){                                                       // retorna un vector con todos los actores de un conjunto de peliculas
        String[] vector_actores = new String[50];                                       // vector temporal de actores
            for(int i = 0; i<todas_pelis.length;i++){                                   // busca los actores en las peliculas
                String[] s = todas_pelis[i].separarActores();
                for(int j = 0; j<s.length; j++){
                    for(int l = 0; l<vector_actores.length;l++){
                        if(vector_actores[l]!=null && s[j].equals(vector_actores[l])){
                            l=vector_actores.length;
                        }
                        if(l<vector_actores.length && vector_actores[l]==null){
                            vector_actores[l]=s[j];
                            l=vector_actores.length;
                        }
                    }
                }
            }
            
        int contador = 0;                                                                 //contador de actores agregadas al temporal
        for(int i = 0; i<vector_actores.length;i++){
            if(vector_actores[i]!=null){
                contador=contador+1;
            }
        }
        
        String[] actores = new String[contador];                                          //vector que se va a retornar con los actores encontrados
        for(int i = 0; i<contador;i++){
            actores[i]=vector_actores[i].toLowerCase();
        }
        // for(int i =0; i<actores.length;i++){
            // for(int j = i; j<actores.length; j++){
                // if(actores[j].compareTo(actores[i])<0){
                    // String tmp = actores[i];
                    // actores[i] = actores[j];
                    // actores[j] = tmp;
                // }
            // }
        // }
        return actores;
    }
    
    public String[] darCategorias(){                                                         // retorna un vector con todas las categorias de un conjunto de peliculas
        String[] vector_categorias = new String[100];                                        // vector temporal de categorias
            for(int i = 0; i<todas_pelis.length;i++){                                        // busca los actores en las peliculas
                String[] s = todas_pelis[i].separarCategorias();
                for(int j = 0; j<s.length; j++){
                    for(int l = 0; l<vector_categorias.length;l++){
                        if(vector_categorias[l]!=null && s[j].equals(vector_categorias[l])){
                            l=vector_categorias.length;
                        }
                        if(l<vector_categorias.length && vector_categorias[l]==null){
                            vector_categorias[l]=s[j];
                            l=vector_categorias.length;
                        }
                    }
                }
            }
            
        int contador = 0;                                                                     //contador de categorias agregadas al temporal
        for(int i = 0; i<vector_categorias.length;i++){
            if(vector_categorias[i]!=null){
                contador=contador+1;
            }
        }
        
        String[] categorias = new String[contador];                                          //vector que se va a retornar con las categorias
        for(int i = 0; i<contador;i++){
            categorias[i]=vector_categorias[i].toLowerCase();
        }
        return categorias;
    }
    
    public void addPeliculas(Arbol ar){                                     //agrega peliculas al arbol del controlador
        if(ar!=null){
            for(int i = 0; i<todas_pelis.length;i++){
                    for(int j = 0;j<todas_pelis[i].categ_vect.length;j++){
                        if(ar.hilera.equals(todas_pelis[i].categ_vect[j])){
                            ar.peliculas.add(todas_pelis[i]);
                            //System.out.println("peliculas agregadas con exito");
                        }
                    }
            }
            addPeliculas(ar.rama_izq);
            addPeliculas(ar.rama_der);
        }

    }
    
    public void addPeliculasActor(Arbol ar){                                          //anade peliculas a un arbol organizado por actores
        if(ar!=null){
            for(int i = 0; i<todas_pelis.length;i++){
                    for(int j = 0;j<todas_pelis[i].actores.length;j++){
                        if(ar.hilera.equals(todas_pelis[i].actores[j])){
                            ar.peliculas.add(todas_pelis[i]);
                            //System.out.println("peliculas agregadas con exito");
                        }
                    }
            }
            addPeliculasActor(ar.rama_izq);
            addPeliculasActor(ar.rama_der);
        }

    }
    
    //METODO MAIN
    public static void main(String a[]){
        System.out.println("\n \t \t \t * * * * * BIENVENIDO AL MEJOR GESTOR DE PELICULAS * * * * * \n \n");
        
        Pelicula[] pelis = new Pelicula[10]; // Creacion del vector con todas las peliculas
        pelis[0]=new Pelicula("s1","TV Show","3,00%","N.A.","João Miguel, Bianca Comparato, Michel Gomes, Rodolfo Valente, Vaneza Oliveira, Rafael Lozano, Viviane Porto, Mel Fronckowiak, Sergio Mamberti, Zezé Motta, Celso Frateschi","Brazil","August 14, 2020",2020,"TV-MA","4 Seasons","International TV Shows, TV Dramas, TV Sci-Fi & Fantasy","In a future where the elite inhabit an island paradise far from the crowded slums, you get one chance to join the 3% saved from squalor.");
        pelis[1]=new Pelicula("s2","Movie","07:19:00","Jorge Michel Grau","Demián Bichir, Héctor Bonilla, Oscar Serrano, Azalia Ortiz, Octavio Michel, Carmen Beato","Mexico","December 23, 2016",2016,"TV-MA","93 min","Dramas, International Movies","After a devastating earthquake hits Mexico City, trapped survivors from all walks of life wait to be rescued while trying desperately to stay alive.");
        pelis[2]=new Pelicula("s3","Movie","23:59:00","Gilbert Chan","Tedd Chan, Stella Chung, Henley Hii, Lawrence Koh, Tommy Kuan, Josh Lai, Mark Lee, Susan Leong, Benjamin Lim","Singapore","December 20, 2018",2011,"R","78 min","Horror Movies, International Movies","When an army recruit is found dead, his fellow soldiers are forced to confront a terrifying secret that's haunting their jungle island training camp.");
        pelis[3]=new Pelicula("s4","Movie","9","Shane Acker","Elijah Wood, John C. Reilly, Jennifer Connelly, Christopher Plummer, Crispin Glover, Martin Landau, Fred Tatasciore, Alan Oppenheimer, Tom Kane","United States","November 16, 2017",2009,"PG-13","80 min","Action & Adventure, Independent Movies, Sci-Fi & Fantasy","In a postapocalyptic world, rag-doll robots hide in fear from dangerous machines out to exterminate them, until a brave newcomer joins the group.");
        pelis[4]=new Pelicula("s5","Movie","21","Robert Luketic","Jim Sturgess, Kevin Spacey, Kate Bosworth, Aaron Yoo, Liza Lapira, Jacob Pitts, Laurence Fishburne, Jack McGee, Josh Gad, Sam Golzari, Helen Carey, Jack Gilpin","United States","January 1, 2020",2008,"PG-13","123 min","Dramas","A brilliant group of students become card-counting experts with the intent of swindling millions out of Las Vegas casinos by playing blackjack.");
        pelis[5]=new Pelicula("s6","TV Show","46","Serdar Akar","Erdal Beikiolu, Yasemin Allen, Melis Birkan, Saygn Soysal, Berkan al, Metin Belgin, Aya Eren, Selin Uludoan, ozay Fecht, Suna Yldzolu","Turkey","July 1, 2017",2016,"TV-MA","1 Season","International TV Shows, TV Dramas, TV Mysteries","A genetics professor experiments with a treatment for his comatose sister that blends medical and shamanic cures, but unlocks a shocking side effect.");
        pelis[6]=new Pelicula("s7","Movie","122","Yasir Al Yasiri","Amina Khalil, Ahmed Dawood, Tarek Lotfy, Ahmed El Fishawy, Mahmoud Hijazi, Jihane Khalil, Asmaa Galal, Tara Emad","Egypt","June 1, 2020",2019,"TV-MA","95 min","Horror Movies, International Movies","After an awful accident, a couple admitted to a grisly hospital are separated and must find each other to escape — before death finds them.");
        pelis[7]=new Pelicula("s8","Movie","187","Kevin Reynolds","Samuel L. Jackson, John Heard, Vaneza Oliveira, Kelly Rowan, Clifton Collins Jr., Tony Plana","United States","November 1, 2019",1997,"R","119 min","Dramas","After one of his high school students attacks him, dedicated teacher Trevor Garfield grows weary of the gang warfare in the New York City school system and moves to California to teach there, thinking it must be a less hostile environment.");
        pelis[8]=new Pelicula("s9","Movie","706","Shravan Kumar","Divya Dutta, Atul Kulkarni, Mohan Agashe, Anupam Shyam, Raayo S. Bakhirta, Yashvit Sancheti, Greeva Kansara, Archan Trivedi, Rajiv Pathak","India","April 1, 2019",2019,"TV-14","118 min","Horror Movies, International Movies","When a doctor goes missing, his psychiatrist wife treats the bizarre medical condition of a psychic patient, who knows much more than he's leading on.");
        pelis[9]=new Pelicula("s10","Movie","1920","Vikram Bhatt","Rajneesh Duggal, Adah Sharma, Indraneil Sengupta, Anjori Alagh, Rajendranath Zutshi, Vipin Sharma, Amin Hajee, Shri Vallabh Vyas","India","December 15, 2017",2008,"TV-MA","143 min","Horror Movies, International Movies, Thrillers","An architect and his wife move into a castle that is slated to become a luxury hotel. But something inside is determined to stop the renovation.");
        
        controlador c = new controlador(pelis);
        String[] categ = c.darCategorias();    //vector de todas las categorias de peliculas existentes
        Arbol arbol = new Arbol(categ[0]);     // arbol donde se almacenan las categorias de las peliculas
        for(int i = 1; i<categ.length; i++){   // anade categorias al arbol
            arbol.add(categ[i]);
        }
        c.anadirArbol(arbol);
        c.addPeliculas(arbol);
        
        controlador c2 = new controlador(pelis);
        String[] act = c2.darActores();          //vector de todos los actores de peliculas existentes
        Arbol arbol2 = new Arbol(act[0]);        //arbol donde se almecenan los actores
        for(int i = 1; i<act.length; i++){       // anade categorias al arbol
            arbol2.add(act[i]);
        }
        c2.anadirArbol(arbol2);
        c2.addPeliculasActor(arbol2);
        
        //Menu del usuario
        boolean bandera = true;
        while(bandera){
            System.out.println("\t **MENU** \n\t Escriba el numero segun lo que desee:  \n");
            System.out.println("\t * 1. Ver todas las categorias de peliculas existentes en el almacenamiento. \n\t * 2. Ver nombres de las peliculas que pertenecen a cierta categoria. \n\t * 3. Lista de actores. \n\t * 4. Lista de peliculas en las que ha actuado una persona. \n\t * 5. Ver videos en espanol. \n\t * 6. Ver todas las peliculas. \n\t * 7. Ver arbol de categorias. \n\t * 8. Ver todas las categorias y sus peliculas. \n\t * 9. Salir.");
            Scanner sc = new Scanner(System.in);
            String name = sc.nextLine();
            switch(name){
                case "1": //1. Ver todas las categorias de peliculas existentes en el almacenamiento.
                    for(int i = 0; i<categ.length;i++){
                        System.out.println(categ[i]);
                    }
                    System.out.println("\n \n");
                    break;
                case "2": //2. Ver nombres de las peliculas que pertenecen a cierta categoria.
                    System.out.println("Escriba el nombre de la categoria deseada");
                    Scanner sc2 = new Scanner(System.in);
                    String s = sc.nextLine().toLowerCase();
                    if(arbol.muestrePelisCategoria(s).equals("")){
                        System.out.println("No hay videos en esta categoria.");
                    }else{
                        System.out.println(s+": " + arbol.muestrePelisCategoria(s));
                    }
                    System.out.println("\n \n");
                    break;
                case "3": //3. Lista de actores. 
                    for(int i = 0; i<act.length;i++){
                        System.out.println(act[i]);
                    }
                    System.out.println("\n \n");
                    break;
                case "4": //4. Lista de peliculas en las que ha actuado una persona. 
                    System.out.println("Escriba el nombre de la persona");
                    Scanner sc3 = new Scanner(System.in);
                    String s2 = sc3.nextLine().toLowerCase();
                    if(arbol2.muestrePelisActores(s2).equals("")){
                        System.out.println("La persona "+s2+" no actua en ninguna pelicula.");
                    }else{
                        System.out.println("La persona "+s2+" actua en la peliculas: " + arbol2.muestrePelisActores(s2));
                    }
                    System.out.println("\n \n");
                    break;
                case "5": //5. Ver videos en espanol. 
                    if(arbol.muestrePelisCategoria("spanish").equals("")){
                        System.out.println("No hay videos en espanol.");
                    }else{
                        System.out.println("Videos en espanol son: "+ arbol.muestrePelisCategoria("spanish"));
                    }
                    System.out.println("\n \n");
                    break;
                case "6": //6. Ver todas las peliculas. 
                    System.out.println("\t * El gestor contiene las siguientes peliculas: \n");
                    System.out.println("\t Show_ID - TIPO - TITULO - DIRECTOR - CAST - PAIS DE PROCEDENCIA - FECHA DE AGREGACION - ANO DE PRODUCCION - AUDIENCIA - DURACION - CATEGORIA - DESCRIPCION");
                    for(int i = 0; i<pelis.length;i++){
                    System.out.println("\t -> " + pelis[i].show_id +" - "+ pelis[i].tipo +" - "+ pelis[i].titulo +" - "+pelis[i].director +" - "+ pelis[i].cast +" - "+ pelis[i].país_de_procedencia +" - "+ pelis[i].fecha_agregacion +" - "+ pelis[i].ano_produccion +" - "+ pelis[i].audiencia +" - "+ pelis[i].duracion +" - "+ pelis[i].categoria +" - "+ pelis[i].descripcion);
                    }
                    System.out.println("\n \n");
                    break;
                case "7": //7. Ver arbol de categorias.
                    System.out.println("** ARBOL **: ");
                    System.out.println(c.arbol.muestre(""));
                    System.out.println("\n \n");
                    break;
                case "8"://8. Ver todas las categorias y sus peliculas.
                    System.out.println("PELICULAS ORDENADAS POR CATEGORIAS");
                    System.out.println("CATEGORIA: Peliculas");
                    System.out.println("International TV Shows: "+arbol.muestrePelisCategoria("International TV Shows"));
                    System.out.println("tv dramas: "+arbol.muestrePelisCategoria("tv dramas"));
                    System.out.println("tv sci-fi & fantasy: "+arbol.muestrePelisCategoria("tv sci-fi & fantasy"));
                    System.out.println("dramas: "+arbol.muestrePelisCategoria("dramas"));
                    System.out.println("international movies: "+arbol.muestrePelisCategoria("international movies"));
                    System.out.println("horror movies: "+arbol.muestrePelisCategoria("horror movies"));
                    System.out.println("action & adventure: "+arbol.muestrePelisCategoria("action & adventure"));
                    System.out.println("independent movies: "+arbol.muestrePelisCategoria("independent movies"));
                    System.out.println("sci-fi & fantasy: "+arbol.muestrePelisCategoria("sci-fi & fantasy"));
                    System.out.println("tv mysteries: "+arbol.muestrePelisCategoria("tv mysteries"));
                    System.out.println("thrillers: "+arbol.muestrePelisCategoria("thrillers"));
                    System.out.println("\n \n");
                    break;
                case "9": //9. Salir.
                    bandera = false;
                    System.out.println("FIN");
                    break;
            }
        }
        
        // System.out.println("agregando p[0] ");
        // arbol.anadirPelicula(pelis[0]);
        // System.out.println("agregando p[2] ");
        // arbol.anadirPelicula(pelis[2]);
        //arbol.anadirPelicula(pelis[2]);
        // for(int i = 0; i<pelis.length; i++){ // anade peliculas al arbol
            // arbol.anadirPelicula(pelis[i]);
        // }
        
    }
}
