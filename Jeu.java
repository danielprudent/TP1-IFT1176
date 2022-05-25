import java.util.*;

/* Puisque les jeux devront ?tre accessibles en ordre tri?s,
 * il est n?cessaire d'impl?menter l'interface Comparable */
// constructeur pour UN jeu 
public class Jeu implements Comparable<Jeu> //? compl?ter
{
    private String fabricant;
    private String titre;
    private String cote;
    private static LinkedHashSet<String> console;
    
public Jeu()
{
 // on construit l'objet a partir de rien au cas ou on en a de besoin.
fabricant = "";
titre = "";
cote = "";
console = new LinkedHashSet<String>();
}

public Jeu(String fabricant, String titre)
{
    // ici on contruit toujours l'objet mais cettre fois ci on prend des parametres exterenes.
this.fabricant = fabricant;
this.titre = titre;
cote = "";
console = new LinkedHashSet<String>();
}

public Jeu(String fabricant, String titre, String cote, LinkedHashSet<String> ConsoleListe)
{
    // ici on contruit toujours l'objet mais cettre fois ci on prend des parametres exterenes.
this.fabricant = fabricant;
this.titre = titre;
this.cote = cote;
console = ConsoleListe;
}

public String GetFabricant()
{
    // ici on retourne le fabricant
return fabricant;
}

public String GetTitre()
{
    // ici on retourne le titre
return titre;
}

public String GetCote()
{
    // ici on retourne la cate ESRB
return cote;
}

public LinkedHashSet<String> Getconsole()
{
    // ici on contruit toujours l'objet mais cettre fois ci on prend des parametres exterenes.
return console;
}

public void  addConsole(String aConsole)
{
// doit ajouter les nouveaux jeux dans le jeu present en fesant une union  de treeset

}

@Override
public int compareTo(Jeu jeu)
{
    // doit comparer le Titre et le Fabricant!!!
int temp = 1;
return temp;
}

    /**
     * On "Overide" la m?thode equals afin de pouvoir comparer cette instance avec une autre et valider si elles sont identiques.
     *
     */
    @Override
    public boolean equals(Object autre)
    {
        // si l'autre objet est null, l'?galit? est n?c?ssairemment fausse.
        if (autre == null) {
            return false;
        }
        // si les deux objets n'appartiennent pas a la meme classe, la comparaison s'arrete ici et on retourne faux.
        if (autre.getClass() != this.getClass()) {
            return false;
        }
        // si c'est vrai, on transtype pour le type de la classe en question :
        Jeu autreJ = (Jeu) autre;
        // si toutes les conditions sont respect?es, on avance, sinon on retourne faux
        if(this.GetFabricant().equals(autreJ.GetFabricant()) && this.GetTitre().equals(autreJ.GetTitre())){
        return true;
        } else {
        return false;
        }
        }

    public boolean trouveConsole(String console2) {
        return false;
    }

}