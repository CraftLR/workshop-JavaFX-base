package dev.craftlr.exercice3;

import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.framework.junit5.Start;

import java.io.PrintStream;
import java.util.concurrent.TimeoutException;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

@ExtendWith(ApplicationExtension.class)
class TestWhoIsWho {

    @Mock
    PrintStream out;

    @BeforeEach
    void setUpClass() throws Exception {
        initMocks(this);
        System.setOut(out);
        ApplicationTest.launch(WhoIsWho.class);
    }

    @Start
    public void start(Stage stage) throws Exception {
        stage.show();
    }

    @AfterEach
    void afterEachTest() throws TimeoutException {
        FxToolkit.cleanupStages();
        FxRobot robot = new FxRobot();
        robot.release(new KeyCode[] {});
        robot.release(new MouseButton[] {});
    }

    @Disabled("Remove to activate")
    @Test
    void test_life_cycle_output() {
        verify(out).println("[JavaFX Application Thread] constructeur WhoIsWho()");
        verify(out).println("[JavaFX Application Thread] start() : avant show stage");
        verify(out).println("[JavaFX Application Thread] start() : après show stage");
    }

}
