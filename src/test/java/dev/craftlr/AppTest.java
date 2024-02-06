package dev.craftlr;

import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.ApplicationTest;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.util.NodeQueryUtils.hasText;

@ExtendWith(ApplicationExtension.class)
class AppTest extends ApplicationTest {

    @Test
    void should_initialize_button_with_text_click() {
        verifyThat("#buttonClick", hasText("Click !"));
    }

    @Test
    void should_increment_nbClick_when_click_on_button() {
        clickOn("#buttonClick");
        verifyThat("#buttonClick", hasText("1"));
    }

    @Test
    void should_increment_nbClick_when_click_on_button_again() {
        clickOn("#buttonClick").clickOn("#buttonClick");
        verifyThat("#buttonClick", hasText("2"));
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        new App().start(primaryStage);
    }
}
