import javax.swing.JOptionPane;
/**
 * Write a description of class controlador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class controlador
{
    Pelicula pelis[];
    Arbol arbol;
    
    public controlador(Pelicula[] p){
        pelis = p;
    }
    
    public String[] darCategorias(){ // retorna un vector con todas las categorias de un conjunto de peliculas
        String[] vector_categorias = new String[50]; // vector temporal de categorias
            for(int i = 0; i<pelis.length;i++){
                String[] s = pelis[i].separarCategorias();
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
            
        int contador = 0; // contador de categorias agregadas al temporal
        for(int i = 0; i<vector_categorias.length;i++){
            if(vector_categorias[i]!=null){
                contador=contador+1;
            }
        }
        
        String[] categorias = new String[contador]; // vector que se va a retornar con las categorias
        for(int i = 0; i<contador;i++){
            categorias[i]=vector_categorias[i].toLowerCase();
        }
        return categorias;
    }
    
    public static void main(String a[]){
        JOptionPane.showMessageDialog(null,"Bienvenido al juego memoria, pulsa OK para comenzar");
        // Pelicula[] pelis = new Pelicula[10]; // vector con todas las peliculas
        // pelis[0]=new Pelicula("s1","TV Show","3,00%","N.A.","João Miguel, Bianca Comparato, Michel Gomes, Rodolfo Valente, Vaneza Oliveira, Rafael Lozano, Viviane Porto, Mel Fronckowiak, Sergio Mamberti, Zezé Motta, Celso Frateschi","Brazil","August 14, 2020",2020,"TV-MA","4 Seasons","International TV Shows, TV Dramas, TV Sci-Fi & Fantasy","In a future where the elite inhabit an island paradise far from the crowded slums, you get one chance to join the 3% saved from squalor.");
        // pelis[1]=new Pelicula("s2","Movie","07:19:00","Jorge Michel Grau","Demián Bichir, Héctor Bonilla, Oscar Serrano, Azalia Ortiz, Octavio Michel, Carmen Beato","Mexico","December 23, 2016",2016,"TV-MA","93 min","Dramas, International Movies","After a devastating earthquake hits Mexico City, trapped survivors from all walks of life wait to be rescued while trying desperately to stay alive.");
        // pelis[2]=new Pelicula("s3","Movie","23:59:00","Gilbert Chan","Tedd Chan, Stella Chung, Henley Hii, Lawrence Koh, Tommy Kuan, Josh Lai, Mark Lee, Susan Leong, Benjamin Lim","Singapore","December 20, 2018",2011,"R","78 min","Horror Movies, International Movies","When an army recruit is found dead, his fellow soldiers are forced to confront a terrifying secret that's haunting their jungle island training camp.");
        // pelis[3]=new Pelicula("s4","Movie","9","Shane Acker","Elijah Wood, John C. Reilly, Jennifer Connelly, Christopher Plummer, Crispin Glover, Martin Landau, Fred Tatasciore, Alan Oppenheimer, Tom Kane","United States","November 16, 2017",2009,"PG-13","80 min","Action & Adventure, Independent Movies, Sci-Fi & Fantasy","In a postapocalyptic world, rag-doll robots hide in fear from dangerous machines out to exterminate them, until a brave newcomer joins the group.");
        // pelis[4]=new Pelicula("s5","Movie","21","Robert Luketic","Jim Sturgess, Kevin Spacey, Kate Bosworth, Aaron Yoo, Liza Lapira, Jacob Pitts, Laurence Fishburne, Jack McGee, Josh Gad, Sam Golzari, Helen Carey, Jack Gilpin","United States","January 1, 2020",2008,"PG-13","123 min","Dramas","A brilliant group of students become card-counting experts with the intent of swindling millions out of Las Vegas casinos by playing blackjack.");
        // pelis[5]=new Pelicula("s6","TV Show","46","Serdar Akar","Erdal Be?ikçio?lu, Yasemin Allen, Melis Birkan, Sayg?n Soysal, Berkan ?al, Metin Belgin, Ayça Eren, Selin Uludo?an, Özay Fecht, Suna Y?ld?zo?lu","Turkey","July 1, 2017",2016,"TV-MA","1 Season","International TV Shows, TV Dramas, TV Mysteries","A genetics professor experiments with a treatment for his comatose sister that blends medical and shamanic cures, but unlocks a shocking side effect.");
        // pelis[6]=new Pelicula("s7","Movie","122","Yasir Al Yasiri","Amina Khalil, Ahmed Dawood, Tarek Lotfy, Ahmed El Fishawy, Mahmoud Hijazi, Jihane Khalil, Asmaa Galal, Tara Emad","Egypt","June 1, 2020",2019,"TV-MA","95 min","Horror Movies, International Movies","After an awful accident, a couple admitted to a grisly hospital are separated and must find each other to escape — before death finds them.");
        // pelis[7]=new Pelicula("s8","Movie","187","Kevin Reynolds","Samuel L. Jackson, John Heard, Kelly Rowan, Clifton Collins Jr., Tony Plana","United States","November 1, 2019",1997,"R","119 min","Dramas","After one of his high school students attacks him, dedicated teacher Trevor Garfield grows weary of the gang warfare in the New York City school system and moves to California to teach there, thinking it must be a less hostile environment.");
        // pelis[8]=new Pelicula("s9","Movie","706","Shravan Kumar","Divya Dutta, Atul Kulkarni, Mohan Agashe, Anupam Shyam, Raayo S. Bakhirta, Yashvit Sancheti, Greeva Kansara, Archan Trivedi, Rajiv Pathak","India","April 1, 2019",2019,"TV-14","118 min","Horror Movies, International Movies","When a doctor goes missing, his psychiatrist wife treats the bizarre medical condition of a psychic patient, who knows much more than he's leading on.");
        // pelis[9]=new Pelicula("s10","Movie","1920","Vikram Bhatt","Rajneesh Duggal, Adah Sharma, Indraneil Sengupta, Anjori Alagh, Rajendranath Zutshi, Vipin Sharma, Amin Hajee, Shri Vallabh Vyas","India","December 15, 2017",2008,"TV-MA","143 min","Horror Movies, International Movies, Thrillers","An architect and his wife move into a castle that is slated to become a luxury hotel. But something inside is determined to stop the renovation.");
        // controlador c = new controlador(pelis);
        // String[] categ = c.darCategorias();
        // for(int i = 0; i<categ.length;i++){
            // System.out.println(categ[i]);
        // }
        // Arbol arbol = new Arbol(categ[0]);
        // for(int i = 1; i<categ.length; i++){
            // arbol.add(categ[i]);
        // }
        // System.out.println(arbol.muestre(""));
        

        
        
    }
}
