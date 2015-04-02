package Joueurs.Humain;

import Joueurs.Joueurs;

public class Humain extends Joueurs {

    public void mettreLesBateaux() {

    }

    public void jouerCoup(Joueurs joueurAdverse) {

        this.nombreCoups = 1;

        while (this.nombreCoups > 0) {

            int x = 5;
            int y = 9;

            if (joueurAdverse.estTouche(x, y)) {
                joueurAdverse.updateTabJoueurTouche(x, y);
                System.out.println("Coup réussi");
            } else {
                this.nombreCoups--;
                System.out.println("Coup raté");
            }

        }
    }

}
