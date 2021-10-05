/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personnages;

/**
 *
 * @author ETI
 */
public class Retiaire extends Personnage {

    
    public Retiaire(String nom, int valeurMaxAttaque, int defense, int pvs, int ini) 
    {
        super(nom, valeurMaxAttaque, defense, pvs, ini);
    }
    
    public void lancerFilet()
    {
        System.out.println("Igor l'empaleur lance son filet");
        int chanceFilet = (int)(Math.random()* 10);
    }
    
    @Override
    public void frapperPersonnage(Personnage personnageCible) {
        
        int forceDeFrappe = attaqueCalcul();
        int valeurDefense = personnageCible.defense;
        int dommages = forceDeFrappe - valeurDefense;
        if(dommages < 0){dommages = 0;}
        
        System.out.println();
        System.out.println(nom + " lance son filet");
        int chanceFilet = (int)(Math.random()* 10);
        
        if(chanceFilet == 1)
        {
            dommages = personnageCible.pvs;
            personnageCible.pvs = personnageCible.pvs - dommages;
            System.out.println("Son filet attrape " + personnageCible.getNom() + " et il l'empale sauvagement avec sa lance.");
        }
        else
        {
            System.out.println("Le filet n'atteint pas sa cible");
            System.out.println(nom + " ramasse son filet et en profite pour attaquer");
            
            personnageCible.pvs = personnageCible.pvs - dommages;
        
            if(personnageCible.pvs < 0){personnageCible.pvs = 0;}
            System.out.println();
            System.out.println(nom + " attaque avec une puissance de : " + forceDeFrappe);
            System.out.println(personnageCible.nom + " a une défense de : " + valeurDefense);
            System.out.println("Les dommages sont de : " + dommages);
        }
    }
}
