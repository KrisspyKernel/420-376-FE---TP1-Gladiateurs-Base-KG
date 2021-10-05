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
public class Mirmillon extends Personnage{
    
    
    
    public Mirmillon(String nom, int valeurMaxAttaque, int defense, int pvs, int ini) 
    {
        super(nom, valeurMaxAttaque, defense, pvs, ini);
        
    }
    
    @Override
     public void setNewInitiativeRandom() {
        // TODO : Modifier de façon aléatoire la valeur INI du personnage.
        int initRandom = (int)(Math.random() * 30);
        ini = initRandom;
    }
     
    @Override
    public void frapperPersonnage(Personnage personnageCible) {
        for(int i = 0; i < 2; i++)
        {
            int forceDeFrappe = attaqueCalcul();
            int valeurDefense = personnageCible.defense;
            int dommages = forceDeFrappe - valeurDefense;
            
            if(dommages < 0){dommages = 0;}
            
            personnageCible.pvs = personnageCible.pvs - dommages;
            
            if(personnageCible.pvs < 0){personnageCible.pvs = 0;}
            if(personnageCible.pvs <= 0)
            {
                System.out.println(nom + " a décapité " + personnageCible.getNom());
                break;
            }
            else
            {
                System.out.println();
                System.out.println(nom + " attaque avec une puissance de : " + forceDeFrappe);
                System.out.println(personnageCible.nom + " a une défense de : " + valeurDefense);
                System.out.println("Les dommages sont de : " + dommages);
            
            }
        }
    }
    
}
