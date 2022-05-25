import java.util.*;
import java.io.*;


public class Bdd implements TestInterface{
    
         private Map<String, TreeSet<Jeu>> videoGame = new LinkedHashMap<>(); //jeuxVideo
         private TreeSet<Jeu> tous; //TreeSet, cest lensemble
    
         public Bdd() {
             videoGame = new LinkedHashMap<>();
    }
// add le jeu passee en  parametre a la banque de donnee - function addJeu TP 
// tous = cest lensemble 
    public void addJeu(Jeu unJeu)
    {
       // TreeSet<Jeu> tousTemp = new TreeSet<Jeu>();
        String fabricant = unJeu.GetFabricant();
        tous = videoGame.get(fabricant);
        String [] aConsole = new String[unJeu.Getconsole().size()]; // uneConsole
        aConsole = unJeu.Getconsole().toArray(aConsole); // uneConsole
         
        if(tous != null){
            boolean GameExistOk = false;
            for(Jeu j : tous){
                // si on trouve le meme jeu, on regarde sa composition de console et on ajoute au besoin
                if (unJeu.equals(j)) {
                    for(int i =0; i<aConsole.length; i++ ) {
                        j.addConsole(aConsole[i]);
                        GameExistOk = true;
                    }
                }
            }
            // si le jeu n'éxiste pas dans le treeSet, on ajoute le jeu en parametre
            if(!GameExistOk) {
                tous.add(unJeu);
            } 
        // Si on ne trouve pas de Treeset, on cree un TreeSet approprié et on ajoute le jeu en parametre dans celle-ci.    
        }else{
            tous = new TreeSet<Jeu>();
            tous.add(unJeu);
            videoGame.put(fabricant, tous);
        }
}
   /*     if (VideoGame.containsKey(unJeu.GetFabricant()))
        {
        // on initie la nouvelle valeur a l aide des valeurs dans la cle correspondante du hashmap
        TousTemp = VideoGame.get(unJeu.GetFabricant());
        // pas besoin de sort le tree set, celui-ci est trie par defaut!
        if(TousTemp.add(unJeu) == false)
        {
         //Ceilling , comparaison different -> add
         //equals
         
        }
        
        // on supprime lentry equivalente a l<endoit ou on a extrait la data
        // pour ensuite replacer le set modifier au meme emplacemment de cle
        
        VideoGame.remove(unJeu.GetFabricant());
        VideoGame.put(unJeu.GetFabricant(),ensembleTemp);
        } else {
        // pas besoin de sort le tree set, celui-ci est trie par defaut!
        ensembleTemp.add(unJeu);
        
        
        VideoGame.put(unJeu.GetFabricant(),ensembleTemp);    
        }
    }
    */

   // Return  the game  that you pass in parametre
    public Jeu getJeu(String titre, String fabricant)
    {
        // on initie un nouveau Jeu
        Jeu aTrouver = new Jeu(fabricant, titre);
        // on trouve le Treeset attitré au fabricant.
        tous = videoGame.get(fabricant);
        
        if (tous != null) {
            Iterator<Jeu> it = tous.iterator();
            while(it.hasNext()) {
                Jeu courant = it.next();            
                if (aTrouver.equals(courant)) {
                    return courant;
                }
            }
        }
        System.out.println("Le jeu " + aTrouver.GetTitre() + " n'est pas trouve");
        return null;
    }


    public void addBdd(String nomFile)
    {
        
        
    }
    
    /**
     * on ouvre le documment texte afin de placer les ï¿½lï¿½ments du documment texte sous des nouveaux objets jeux.
     * Ces nouvelles instances seront par la suite transfï¿½rï¿½s vers la liste Hash de jeux a l'aide de la fonction AddJeu. 
     * 
     * @author (ï¿½quipe)
     * @version (0.1)     
     * @throws IOException
     */      
    public void loadBdd(String nomFile) throws IOException{
    {
        // ce code lis les lignes du fichier texte ligne par ligne
        boolean prob = false;
        FileReader fr = null;
        String uneLigne; //  
        LinkedHashSet<String> consolesL = new LinkedHashSet<String>();
        Jeu game = new Jeu();
        try {
            fr = new FileReader(nomFile);
        }
        catch (java.io.FileNotFoundException erreur) {
            System.out.printf("Probleme d'ouverture du fichier %s/n", 1);
            prob = true;
        }
        if (!prob) {
            //on commence la lecture.
            BufferedReader entree = new BufferedReader(fr);
            boolean finFichier = false;
            // tant et aussi longtemps que le .txt n'est pas fini
            while (!finFichier)
            {
                // on lit le tout ligne par ligne
                uneLigne = entree.readLine();
                if(uneLigne == null){
                    // si la ligne est vide, on assume que le documment texte est terminï¿½
                    finFichier = true;
                } 
                else 
                {
                // on sï¿½pare les informations de la ligne selon la structure du documment texte afin de le placer dans l'objet.
                // ici, on peut splitter la string trouvï¿½e a chaque ligne avec le charactï¿½re ";"
             String[] textespliter = uneLigne.split(";");
                        
            // on place les Strings et les chars qu'on peux  dans des variables a placer plus tard dans l'objet. 
         String fabricant = textespliter[0];
         String Titre = textespliter[1];
         String Cote = String.valueOf(textespliter[2].charAt(0)) ;
            
         // on fait la liste nï¿½cï¿½ssaire afin de placer les consoles jouables dans l'objet jeu.
         String[] Stringsconsole = textespliter[3].split(",");
         
         for (int i=0; i < Stringsconsole.length; i++)
         {
          consolesL.add(Stringsconsole[i]);
         }
          
         game = new Jeu(fabricant,Titre, Cote, consolesL);
         addJeu(game);
         }
           //entree.close();
           }
         }
        }
        }
    

    public ArrayList<Jeu> chercheConsole(String console){
    // ï¿½ complï¿½ter et changer l'instruction du return
        ArrayList<Jeu> ConsoleGame = new ArrayList<Jeu>();
        for(Map.Entry<String, TreeSet<Jeu>> entry : videoGame.entrySet()) {
            Iterator<Jeu> it = entry.getValue().iterator();
            while(it.hasNext()) {
                Jeu jeuCourant = it.next();
                if(jeuCourant.trouveConsole(console)) {
                    ConsoleGame.add(jeuCourant);
                }
            }                
        }
        return ConsoleGame;
        //return null;
    }

    public Collection<Jeu> getJeuxFabricant(String fabricant){
    // ï¿½ complï¿½ter et potentiellement changer l'instruction du return
        return null;
    }

    public void saveBdd(String nomFichier){
    //A complï¿½ter
    }


    @Override
    public void chercheCote(String laCote) {
        // TODO Auto-generated method stub
        
    }

}