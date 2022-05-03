package fr.univ_amu.iut.exercice14;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class Pacman extends Personnage {

    private final Circle corps;
    private final Line bouche;


    public Pacman() {
        corps = new Circle(10, 10, LARGEUR_MOITIE_PERSONNAGE, Color.BLACK);
        corps.setFill(Paint.valueOf("yellow"));
        bouche = new Line(LARGEUR_MOITIE_PERSONNAGE, LARGEUR_MOITIE_PERSONNAGE, LARGEUR_MOITIE_PERSONNAGE * 2, LARGEUR_MOITIE_PERSONNAGE);
        bouche.setFill(Paint.valueOf("black"));
        direction = "droite";

        this.getChildren().add(corps);
        this.getChildren().add(bouche);
    }

    @Override
    public void directionGauche() {
        super.directionGauche();
        //sens de la bouche
        bouche.setEndX(bouche.getStartX() - LARGEUR_MOITIE_PERSONNAGE);
        bouche.setEndY(bouche.getStartY());
    }

    @Override
    public void directionDroite(double largeurJeu) {
        super.directionDroite(largeurJeu);
        //sens de la bouche
        bouche.setEndX(bouche.getStartX() + LARGEUR_MOITIE_PERSONNAGE);
        bouche.setEndY(bouche.getStartY());
    }

    @Override
    public void directionBas(double hauteurJeu) {
        // à compléter
    }

    @Override
    public void directionHaut() {
        // à compléter
    }

}
