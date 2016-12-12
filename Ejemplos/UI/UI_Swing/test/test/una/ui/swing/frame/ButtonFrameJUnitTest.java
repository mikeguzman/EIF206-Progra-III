/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.una.ui.swing.frame;

import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JPanelFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import una.ui.swing.frame.ButtonFrame;

/**
 *
 * @author mguzmana
 */
public class ButtonFrameJUnitTest {

    private FrameFixture window;
    private JPanelFixture panel;

    public ButtonFrameJUnitTest() {
    }

    @Before
    public void setUp() {
        ButtonFrame frame = GuiActionRunner.execute(() -> new ButtonFrame());
        window = new FrameFixture(frame);
        window.show(); 
        panel = window.panel("Form");
    }

    @Test
    public void testButtons() {
        panel.button("load").requireVisible();
        panel.button("save").requireVisible();
        panel.button("unsubscribe").requireVisible();
    }

    @After
    public void tearDown() {
        window.cleanUp();
    }
}
