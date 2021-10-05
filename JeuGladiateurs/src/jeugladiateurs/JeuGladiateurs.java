package jeugladiateurs;

import personnages.Personnage;
import combat.CompteurDeTour;
import combat.AffichageEcran;
import personnages.Mirmillon;
import personnages.Retiaire;

public class JeuGladiateurs {

    public static void main(String[] args) {

    // **************************************************************************
    // **************************************************************************
    // **************************************************************************
    // <editor-fold defaultstate="collapsed" desc="Instanciation des objets">
    CompteurDeTour tour = new CompteurDeTour();
    AffichageEcran affichage = new AffichageEcran();
    Personnage personnage1 = new Mirmillon("Bob le malchanceux", 15, 15, 70, 15);
    Personnage personnage2 = new Retiaire("Igor l'empaleur", 25, 5, 100, 30);
    
    // </editor-fold>

    // **************************************************************************
    // **************************************************************************
    // **************************************************************************
    // <editor-fold defaultstate="collapsed" desc="Affichage pré-combat">
    // TODO : Afficher les infos de chaque personnage
    personnage1.afficherInfosPersonnage();
    personnage2.afficherInfosPersonnage();
    // TODO : Afficher le message du début du combat
    affichage.afficherDebutCombat();
    // </editor-fold>
    // **************************************************************************
    // **************************************************************************
    // **************************************************************************
    // <editor-fold defaultstate="collapsed" desc="Mécanique de combat">
    // TODO : La boucle contenant les étapes du combat
    while(personnage1.getPvs() > 0 && personnage2.getPvs() > 0)
    {
        tour.afficheTour();
    
        for(int i = 0; i < 100; i++)
        {
            if(personnage1.getIni() == i)
            {
                personnage1.frapperPersonnage(personnage2);
            }
            if(personnage2.getIni() == i)
            {
                personnage2.frapperPersonnage(personnage1);
            }
        }
        // TODO : Après la boucle, afficher le résultat du combat
        affichage.afficherSeparateurInfosPerso();

        personnage1.afficherInfosPersonnage();
        personnage2.afficherInfosPersonnage();

        personnage1.setNewInitiativeRandom();
        personnage2.setNewInitiativeRandom();

        tour.augmenteTour();
        affichage.afficherSeparateurDeTour();
    }
    affichage.afficheVictoire(personnage1, personnage2);
    // </editor-fold>
    }

}
