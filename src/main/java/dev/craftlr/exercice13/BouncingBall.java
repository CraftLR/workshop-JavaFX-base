package dev.craftlr.exercice13;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class BouncingBall extends Application {

    private Button startButton;
    private Button pauseButton;
    private Button resumeButton;
    private Button stopButton;
    private Slider slider;
    private Circle circle;
    private VBox root;
    private HBox commands;
    private Pane pane;
    private TranslateTransition transition;

    @Override
    public void start(Stage stage) {

    }
}
