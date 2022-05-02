package fr.univ_amu.iut.exercice5;

import javafx.application.Platform;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import java.util.concurrent.TimeoutException;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(ApplicationExtension.class)
public class TestMyUndecoratedJavaFXWindow {

    Stage stage;

    @Start
    void start(Stage stage) throws Exception {
        Platform.runLater(() -> {
            TestMyUndecoratedJavaFXWindow.this.stage = new Stage();
            try {
                FxToolkit.setupStage((sta) -> {
                    try {
                        new MyUndecoratedJavaFXWindow().start(TestMyUndecoratedJavaFXWindow.this.stage);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
        });
    }

    @AfterEach
    void afterEachTest(FxRobot robot) throws TimeoutException {
        FxToolkit.cleanupStages();
        Platform.runLater(() -> stage.close());
        robot.release(new KeyCode[]{});
        robot.release(new MouseButton[]{});
    }

    @Disabled
    @Test
    void should_initialize_stage_is_not_showing() {
        assertThat(stage.isShowing()).isFalse();
    }

    @Disabled
    @Test
    void should_initialize_stage_with_correct_title() {
        assertThat(stage.getTitle()).isEqualTo("Undecorated Useless JavaFX Window");
    }

    @Disabled
    @Test
    void should_initialize_stage_is_not_resizable() {
        assertThat(stage.isResizable()).isFalse();
    }

    @Disabled
    @Test
    void should_initialize_stage_with_height_of_400() {
        assertThat(stage.getHeight()).isEqualTo(400);
    }

    @Disabled
    @Test
    void should_initialize_stage_with_width_of_800() {
        assertThat(stage.getWidth()).isEqualTo(800);
    }

    @Disabled
    @Test
    void should_initialize_stage_is_undecorated() {
        assertThat(stage.getStyle()).isEqualTo(StageStyle.UNDECORATED);
    }

}
