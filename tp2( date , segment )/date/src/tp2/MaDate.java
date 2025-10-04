package tp2;
import java.util.Scanner;
public class MaDate {
	private int jour;
    private int mois;
    private int annee;
    
    public String toString() {
        return jour + "/" + mois + "/" + annee;
    }
    
    public int getJour() { return jour; }
    public void setJour(int jour) { this.jour = jour; }

    public int getMois() { return mois; }
    public void setMois(int mois) { this.mois = mois; }

    public int getAnnee() { return annee; }
    public void setAnnee(int annee) { this.annee = annee; }
    
    public MaDate(int jour, int mois, int annee) {
        this.jour = jour;
        this.mois = mois;
        this.annee = annee;
    }
    
    public MaDate(int annee) {
        this.jour = 1;
        this.mois = 1;
        this.annee = annee;
    }
    private boolean Bissextile(int annee) {
        return (annee % 4 == 0 && annee % 100 != 0) || (annee % 400 == 0);
    }
    
    private int getJoursDansMois(int mois, int annee) {
    	switch (mois) {
    		case 1: case 3: case 5: case 7: case 8: case 10: case 12:
    			return 31;
    		case 4: case 6: case 9: case 11:
    			return 30;
    		case 2: 
    			return Bissextile(annee) ? 29 : 28;
    		default:
    			return 0;
    		
    	}
    	
    }
    public void ajouterUnJour() {
        jour++;
        if (jour > getJoursDansMois(mois, annee)) {
            jour = 1;
            mois++;
            if (mois > 12) {
                mois = 1;
                annee++;
            }
        }
    }
    public void ajouterPlusieursJours(int n) {
        for (int i = 0; i < n; i++) {
            ajouterUnJour();

        }

    }
    
    public void ajouterUnMois() {
        mois++;
        if (mois > 12) {
            mois = 1;
            annee++;
        }
        if (jour > getJoursDansMois(mois, annee)) {
            jour = getJoursDansMois(mois, annee);
        }

    }

    public void ajouterUnAn() {
        annee++;
        if (jour == 29 && mois == 2 && !Bissextile(annee)) {
            jour = 28;
        }
    }
    
 
    class TestDate {
    	public static void main(String[] args) {
            Scanner s = new Scanner(System.in);

            MaDate d1 = new MaDate(31, 12, 2024);
            MaDate d2 = new MaDate(30, 7, 2005);
            MaDate d3 = new MaDate(2025);

            d1.setJour(31);
            d1.setMois(12);
            d1.setAnnee(2024);


            d2.setJour(30);
            d2.setMois(7);
            d2.setAnnee(2005);

            d3.setAnnee(2025);
            
            System.out.println("Les 3 dates initiales : ");
            System.out.println("Date 1 : " + d1);
            System.out.println("Date 2 : " + d2);
            System.out.println("Date 3 : " + d3);


            System.out.println("\nMenu");
            System.out.println("1- Ajouter un jour");
            System.out.println("2- Ajouter plusieurs jours");
            System.out.println("3- Ajouter un mois");
            System.out.println("4- Ajouter une année");
            System.out.print("Choix : ");
            int choix = s.nextInt();

            switch (choix) {
                case 1 : d1.ajouterUnJour();
                case 2 : {
                    System.out.print("Combien de jours ?");
                    int n = s.nextInt();
                    d1.ajouterPlusieursJours(n);
                }
                case 3 : d1.ajouterUnMois();
                case 4 : d1.ajouterUnAn();
                default : System.out.println("Choix invalide.");

            }

            System.out.println("Nouvelle valeur de Date 1 : " + d1);



            s.close();

        }

    }

}