package dev.craftlr.exercice14;

import javafx.scene.Group;

class Personnage extends Group {
    protected final static double LARGEUR_MOITIE_PERSONNAGE = 10;
    protected final static double LARGEUR_PERSONNAGE = LARGEUR_MOITIE_PERSONNAGE * 2;
    protected String direction;

    public void directionGauche() {
        // ****
        // * *
        // *--- *
        // * *
        // ****

        // déplacement <----
        if (getLayoutX() >= LARGEUR_PERSONNAGE) {
            setLayoutX(getLayoutX() - LARGEUR_PERSONNAGE);
        }
        if (!direction.equals("gauche")) {
            direction = "gauche";
        }
    }

    public void directionDroite(double largeurJeu) {
        // ****
        // * *
        // * ---*
        // * *
        // ****
        // déplacement ---->
        if (getLayoutX() < largeurJeu - LARGEUR_PERSONNAGE) {
            setLayoutX(getLayoutX() + LARGEUR_PERSONNAGE);
        }
        if (!direction.equals("droite")) {
            direction = "droite";
        }
    }

    public void directionBas(double hauteurJeu) {
        // *****
        // * *
        // * | *
        // * | *
        // *****

    }

    public void directionHaut() {
        // *****
        // * | *
        // * | *
        // * *
        // *****

    }

    boolean collision(Personnage autrePersonnage) {
        return getBoundsInParent().contains(autrePersonnage.getBoundsInParent())
                || autrePersonnage.getBoundsInParent().contains(getBoundsInParent());
    }

}
