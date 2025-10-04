package tp2s;

class point{
	private int abs;
    private int ord;
    private String nom;
    
    public point() {
        this.abs = 0;
        this.ord = 0;
        this.nom = "point";
    }

 
    public point(String nom, int abs, int ord) {
        this.abs = abs;
        this.ord = ord;
        this.nom = nom;
    }
    public void affiche() {
        System.out.println(nom + " (" + abs + ", " + ord + ")");
    }
    public double distance(point p) {
        return Math.sqrt(Math.pow(this.abs - p.abs, 2) + Math.pow(this.ord - p.ord, 2));
    }
    public int getAbs() { return abs; }
    public int getOrd() { return ord; }
    public String getNom() { return nom; }

    public void setAbs(int abs) { this.abs = abs; }
    public void setOrd(int ord) { this.ord = ord; }
    public void setNom(String nom) { this.nom = nom; }
}
public class segment {
    private point extr1;
    private point extr2;

  
    public segment() {
        this.extr1 = new point("A", 0, 0);
        this.extr2 = new point("B", 1, 1);
    }

    
    public segment(point extr1, point extr2) {
        this.extr1 = extr1;
        this.extr2 = extr2;
    }

   
    public String toString() {
        return "[" + extr1.getNom() + " (" + extr1.getAbs() + ", " + extr1.getOrd() + ") "
                   + extr2.getNom() + " (" + extr2.getAbs() + ", " + extr2.getOrd() + ")]";
    }

    public double longueur() {
        return extr1.distance(extr2);
    }

    
    public boolean appartient(point p) {
        double dAB = extr1.distance(extr2);
        double dAP = extr1.distance(p);
        double dPB = p.distance(extr2);

        return Math.abs(dAB - (dAP + dPB)) < 0.0001;
    }

    
    public void translaterSeg(int a, int b) {
        extr1.setAbs(extr1.getAbs() + a);
        extr1.setOrd(extr1.getOrd() + b);
        extr2.setAbs(extr2.getAbs() + a);
        extr2.setOrd(extr2.getOrd() + b);
    }
}
 class TestSegment {
    public static void main(String[] args) {
        point p1 = new point("A", 0, 0);
        point p2 = new point("B", 5, 2);
        segment s1 = new segment(p1, p2);

        System.out.println("Segment s1 : " + s1);
        System.out.println("Longueur du segment : " + s1.longueur());

        point p3 = new point("C", 2, 1);
        System.out.println("Le point C appartient au segment ? " + s1.appartient(p3));

        s1.translaterSeg(2, 2);
        System.out.println("Après translation : " + s1);
    }
}

