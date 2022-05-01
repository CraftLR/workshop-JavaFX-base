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

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(ApplicationExtension.class)
public class TestMyUndecoratedJavaFXWindow {

    Stage stage;

    @Start
    void start(Stage stage) throws Exception {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
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
        assertFalse(stage.isShowing());
    }

    @Disabled
    @Test
    void should_initialize_stage_with_correct_title() {
        assertEquals("Undecorated Useless JavaFX Window", stage.getTitle());
    }

    @Disabled
    @Test
    void should_initialize_stage_is_always_on_top() {
        assertTrue(stage.alwaysOnTopProperty().get());
    }

    @Disabled
    @Test
    void should_initialize_stage_is_not_resizable() {
        assertFalse(stage.isResizable());
    }

    @Disabled
    @Test
    void should_initialize_stage_with_height_of_400() {
        assertEquals(400, stage.getHeight());
    }

    @Disabled
    @Test
    void should_initialize_stage_with_width_of_800() {
        assertEquals(800, stage.getWidth());
    }

    @Disabled
    @Test
    void should_initialize_stage_is_undecorated() {
        assertEquals(StageStyle.UNDECORATED, stage.getStyle());
    }

}
