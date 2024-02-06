package dev.craftlr.exercice1;

import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.framework.junit5.Start;

import java.util.concurrent.TimeoutException;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(ApplicationExtension.class)
class TestMyFirstJavaFXWindow {

    Stage stage;

    @BeforeEach
    void setUpClass() throws Exception {
        ApplicationTest.launch(MyFirstJavaFXWindow.class);
    }

    @Start
    void onStart(Stage stage) throws Exception {
        this.stage = stage;
    }

    @AfterEach
    void afterEachTest(FxRobot robot) throws TimeoutException {
        FxToolkit.cleanupStages();
        robot.release(new KeyCode[] {});
        robot.release(new MouseButton[] {});
    }

    @Test
    void should_initialize_stage_with_correct_title() {
        assertThat(stage.getTitle()).isEqualTo("A Useless JavaFX Window");
    }

}
