package personnages;

public class Personnage {
    // <editor-fold defaultstate="collapsed" desc="Attributs">
    // TODO : Mettre vos attributs ici
    String nom;
    int pvs;
    int valeurMaxAttaque;
    int defense;
    int ini;
    // </editor-fold>
    // **************************************************************************
    // **************************************************************************
    // **************************************************************************
    // <editor-fold defaultstate="collapsed" desc="Constructeurs et initialisation">
    public Personnage(String nom, int valeurMaxAttaque, int defense, int pvs, int ini) {
        // TODO : Constructeur AVEC paramètres
        this.nom = nom;
        this.valeurMaxAttaque = valeurMaxAttaque;
        this.defense = defense;
        this.pvs = pvs;
        this.ini = ini;
    }

    public Personnage() {
        // TODO : Constructeur SANS paramètres qui initialise à ZÉRO ou à ""
        this.nom = "";
        this.valeurMaxAttaque = 0;
        this.defense = 0;
        this.pvs = 0;
        this.ini = 0;
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Getters et setters">
    // TODO : Les getters
    public String getNom() {
        return nom;
    }

    public int getPvs() {
        return pvs;
    }

    public int getAttaqueMax() {
        return valeurMaxAttaque;
    }

    public int getDefense() {
        return defense;
    }

    public int getIni() {
        return ini;
    }

    // TODO : Les setters
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public void setPvs(int pvs) {
        this.pvs = pvs;
    }
    
    public void setAttaqueMax(int valeurMaxAttaque) {
        this.valeurMaxAttaque = valeurMaxAttaque;
    }
    
    public void setDefense(int defense) {
        this.defense = defense;
    }
    
    public void setIni(int ini) {
        this.ini = ini;
    }
    // </editor-fold>

    // **************************************************************************
    // **************************************************************************
    // **************************************************************************
    // <editor-fold defaultstate="collapsed" desc="Mécanique de jeu">
    public void afficherInfosPersonnage() {
        // TODO : Afficher les infos du personnage, tel que montré dans l'énoncé
        System.out.println("\n" + nom);
        System.out.println("    Attaque : " + valeurMaxAttaque);
        System.out.println("    Défense : " + defense);
        System.out.println("    Points de vie : " + pvs);
        System.out.println("    Initiative : " + ini);
        if(pvs <= 0)
        {
            System.out.println("    Statut : Mort");
        }
        else
        {
            System.out.println("    Statut : Vivant");
        }
    }

    private int attaqueCalcul() {
        // TODO : Retourner la valeur de l'attaque du personnage.
        // Cette valeur est trouvée aléatoirement et doit se situer entre ZÉRO et valeurMaxAttaque.
        int AttaqueMaxRand = (int)(Math.random()*valeurMaxAttaque);
        return AttaqueMaxRand;
    }

    public void frapperPersonnage(Personnage personnageCible) {
        // TODO : Récupérer la valeur d'attaque pour ce tour, calculer les dégats,
        //modifier les points de vie du personnage cible, afficher les détails
        // sur l'attaque, tel que montré dans l'énoncé.
        int forceDeFrappe = attaqueCalcul();
        int valeurDefense = personnageCible.defense;
        int dommages = forceDeFrappe - valeurDefense;
        if(dommages < 0){dommages = 0;}
        
        personnageCible.pvs = personnageCible.pvs - dommages;
        
        if(personnageCible.pvs < 0){personnageCible.pvs = 0;}
        System.out.println();
        System.out.println(nom + " attaque avec une puissance de : " + forceDeFrappe);
        System.out.println(personnageCible.nom + " a une défense de : " + valeurDefense);
        System.out.println("Les dommages sont de : " + dommages);
    }

    public void setNewInitiativeRandom() {
        // TODO : Modifier de façon aléatoire la valeur INI du personnage.
        int initRandom = (int)(Math.random() * 100);
        ini = initRandom;
    }
    // </editor-fold>
}
