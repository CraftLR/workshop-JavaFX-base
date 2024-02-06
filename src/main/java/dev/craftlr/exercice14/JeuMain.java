package dev.craftlr.exercice14;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class JeuMain extends Application {

    private Scene scene;
    private BorderPane root;

    @Override
    public void start(Stage primaryStage) {

        root = new BorderPane();

        // Acteurs du jeu
        Personnage pacman = new Pacman();
        Personnage fantome = new Fantome();
        // on positionne le fantôme 20 positions vers la droite
        fantome.setLayoutX(20 * 10);
        // panneau du jeu
        Pane jeu = new Pane();
        jeu.setPrefSize(640, 480);
        jeu.getChildren().add(pacman);
        jeu.getChildren().add(fantome);
        root.setCenter(jeu);
        // on construit une scene 640 * 480 pixels
        scene = new Scene(root);

        // Gestion du déplacement du personnage
        move(pacman, fantome);

        primaryStage.setTitle("... Pac Man ...");

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * move permet de gérer les événements de type clavier, pression des touches
     * pour le j1(up,down, right, left), pour le j2( z,q,s,d)
     *
     * @param j1
     * @param j2
     */
    private void move(Personnage j1, Personnage j2) {
        scene.setOnKeyPressed((KeyEvent event) -> {
            switch (event.getCode()) {
                case LEFT:
                    j1.directionGauche();
                    break;
                case RIGHT:
                    j1.directionDroite(scene.getWidth());
                    break;
                case Z:
                    // j2...... vers le haut;
                    break;
                default:
                    break;

            }
            if (j1.collision(j2))
                System.out.println("Collision....");
        });
    }

}
