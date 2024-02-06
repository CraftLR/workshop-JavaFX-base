package dev.craftlr.exercice4;

import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
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
class TestMySecondJavaFXWindow {

    Stage stage;

    @BeforeEach
    void setUpClass() throws Exception {
        ApplicationTest.launch(MySecondJavaFXWindow.class);
    }

    @Start
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        stage.show();
    }

    @AfterEach
    void afterEachTest(FxRobot robot) throws TimeoutException {
        FxToolkit.cleanupStages();
        robot.release(new KeyCode[] {});
        robot.release(new MouseButton[] {});
    }

    @Disabled("Remove to activate")
    @Test
    void should_initialize_stage_with_correct_title() {
        assertThat(stage.getTitle()).isEqualTo("Second Useless JavaFX Window");
    }

    @Disabled("Remove to activate")
    @Test
    void should_initialize_stage_is_always_on_top() {
        assertThat(stage.alwaysOnTopProperty().get()).isTrue();
    }

    @Disabled("Remove to activate")
    @Test
    void should_initialize_stage_is_not_resizable() {
        assertThat(stage.resizableProperty().get()).isFalse();
    }

    @Disabled("Remove to activate")
    @Test
    void should_initialize_stage_with_height_of_400() {
        assertThat(stage.getHeight()).isCloseTo(400d, Offset.offset(1d));
    }

    @Disabled("Remove to activate")
    @Test
    void should_initialize_stage_with_width_of_800() {
        assertThat(stage.getWidth()).isCloseTo(800d, Offset.offset(1d));
    }

    @Disabled("Remove to activate")
    @Test
    void should_initialize_stage_is_showing() {
        assertThat(stage.isShowing()).isTrue();
    }

}
