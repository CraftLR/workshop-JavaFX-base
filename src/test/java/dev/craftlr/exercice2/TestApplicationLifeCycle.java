package dev.craftlr.exercice2;

import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.framework.junit5.Start;

import java.io.PrintStream;
import java.util.concurrent.TimeoutException;

import static org.mockito.Mockito.verify;

@Disabled("Remove to activate")
@ExtendWith(ApplicationExtension.class)
class TestApplicationLifeCycle {

    @Mock
    PrintStream out;

    @BeforeEach
    void setUpClass() throws Exception {
        MockitoAnnotations.initMocks(this);
        System.setOut(out);
        ApplicationTest.launch(ApplicationLifeCycle.class);
    }

    @Start
    void start(Stage stage) throws Exception {
        stage.show();
    }

    @AfterEach
    void afterEachTest(FxRobot robot) throws TimeoutException {
        FxToolkit.cleanupStages();
        robot.release(new KeyCode[] {});
        robot.release(new MouseButton[] {});
    }

    @Test
    void constructor() throws Exception {
        verify(out).println("constructeur ApplicationLifeCycle()");
    }

    @Disabled("Remove to activate")
    @Test
    void test_init() {
        verify(out).println("init()");
    }

    @Disabled("Remove to activate")
    @Test
    void test_stop() throws Exception {
        FxToolkit.setupApplication(ApplicationLifeCycle.class).stop();
        verify(out).println("stop()");
    }

    @Disabled("Remove to activate")
    @Test
    void test_life_cycle_output() {
        verify(out).println("constructeur ApplicationLifeCycle()");
        verify(out).println("start() : avant show stage");
        verify(out).println("start() : après show stage");
    }

}