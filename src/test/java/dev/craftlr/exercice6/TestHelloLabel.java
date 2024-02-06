package dev.craftlr.exercice6;

import javafx.application.Platform;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
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
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.util.NodeQueryUtils.hasText;

@ExtendWith(ApplicationExtension.class)
class TestHelloLabel {

    Stage stage;

    @Start
    public void start(Stage stage) throws Exception {
        Platform.runLater(() -> {
            TestHelloLabel.this.stage = new Stage();
            try {
                FxToolkit.setupStage((sta) -> {
                    try {
                        new HelloLabel().start(TestHelloLabel.this.stage);
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
        robot.release(new KeyCode[] {});
        robot.release(new MouseButton[] {});
    }

    @Disabled("Remove to activate")
    @Test
    void should_initialize_stage_with_correct_title() {
        assertThat(stage.getTitle()).isEqualTo("Hello !");
    }

    @Disabled("Remove to activate")
    @Test
    void should_initialize_stage_is_showing() {
        assertThat(stage.isShowing()).isTrue();
    }

    @Disabled("Remove to activate")
    @Test
    void should_initialize_stage_with_height_of_100() {
        assertThat(stage.getScene().getHeight()).isEqualTo(100);
    }

    @Disabled("Remove to activate")
    @Test
    void should_initialize_stage_with_width_of_250() {
        assertThat(stage.getScene().getWidth()).isEqualTo(250);
    }

    @Disabled("Remove to activate")
    @Test
    void should_initialize_label_with_text_hello() {
        verifyThat("#labelHello", hasText("Hello !"));
    }

}
