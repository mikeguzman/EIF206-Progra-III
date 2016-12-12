/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.una.ui.events;

import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;
import una.ui.events.FocusExample;

/**
 *
 * @author mguzmana
 */
public class FocusJUnitTest {
    
    private FrameFixture window;
    
    public FocusJUnitTest() {
    }

    @Before
    public void setUp() {
        FocusExample frame = GuiActionRunner.execute(() -> new FocusExample());
        window = new FrameFixture(frame);
        window.show();
    }

    @Test
    public void testFocus() {
        window.textBox("value1").focus().deleteText();
        window.textBox("value1").enterText("2");
        window.textBox("value2").focus().deleteText();
        window.textBox("value2").enterText("2");
        window.textBox("sum").focus();
        assertEquals(window.textBox("sum").text(), "4.0");
    }

    @After
    public void tearDown() {
        window.cleanUp();
    }
}
