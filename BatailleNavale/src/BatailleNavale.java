import Joueurs.Humain.Humain;
import Joueurs.IA.IA;
import Joueurs.Joueurs;

public class BatailleNavale {

    public static void main(String[] args) {

        Joueurs joueur1 = new Humain();
        Joueurs joueur2 = new IA();

        joueur1.initTableauxZero();
        joueur2.initTableauxZero();

        for (int i=0; i<joueur1.getTaillePlateau(); i++) {
            for (int j=0; j<joueur1.getTaillePlateau(); j++) {
                    System.out.printf(""+joueur1.getValeurTabJoueur(i,j));
            }
            System.out.println();
        }

        while (joueur1.getVieJoueur() > 0 && joueur2.getVieJoueur() > 0) {
            joueur1.jouerCoup(joueur2);
            joueur2.jouerCoup(joueur1);


        }

    }
}
