package Joueurs;

public abstract class Joueurs {

    // 10 * 10 -> http://fr.wikipedia.org/wiki/Bataille_navale_%28jeu%29#Grille_de_jeu
    private static final int taillePlateau = 10;

    // Vie total = nombre de cases de tous les bâteaux cumulés
    private static int vieJoueur = 17;

    // Obtient la vie du joueur
    public int getVieJoueur() {
        return vieJoueur;
    }

    // définit la vie du joueur
    public int setVieJoueur(int valeur) {
        vieJoueur = valeur;
        return vieJoueur ;
    }

    // Obtient la taille du plateau
    public int getTaillePlateau() {
        return taillePlateau;
    }

    // Nombres de coups max par joueurs par tours
    protected int nombreCoups = 1;

    protected static final int PAS_DE_BATEAU = 0;
    protected static final int BATEAU = 1;
    protected static final int TOUCHE = 2;

    /*
    Tableau de jeu des joueurs
    0 = pas de bateau
    1 = bateau
    2 = touché
    */
    protected static int tabJoueur[][] = new int[taillePlateau][taillePlateau];

    // Obtient le tableau du joueur
    public int[][] getTabJoueur() {
        return this.tabJoueur;
    }

    // Obtient la valeur d'une case de tableau
    public int getValeurTabJoueur(int x, int y) {
        return this.tabJoueur[x][y];
    }

    // Définit la valeur d'une case de tableau
    public void setValeurTabJoueur(int x, int y, int valeur) {
        this.tabJoueur[x][y] = valeur;
    }

    // Initialise le tableau à false
    public void initTableauxZero() {
        for (int i=0; i<taillePlateau; i++) {
            for (int j=0; j<taillePlateau; j++) {
                this.tabJoueur[i][j] = 0;
            }
        }
    }

    // Fonction abstraite pour placer les bateaux dans les tableaux selon le joueur (IA ou Humain)
    public abstract void mettreLesBateaux();

    // Return true si un bâteau est touché par le tir
    public boolean estTouche(int x, int y) {
        switch (this.getValeurTabJoueur(x,y)) {
            case BATEAU:
                return true;
            case PAS_DE_BATEAU:
            case TOUCHE:
            default:
                return false;
        }
    }

    // Met à jour le tableau si le joueur est touché
    public void updateTabJoueurTouche(int x, int y) {
        this.setVieJoueur(this.getVieJoueur() - 1);
        this.setValeurTabJoueur(x, y, TOUCHE);
    }

    // Tour du joueur
    public abstract void jouerCoup(Joueurs joueurAdverse);
}
