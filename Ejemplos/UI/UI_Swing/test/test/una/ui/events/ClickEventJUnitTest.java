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
import una.ui.events.ClickEvent;

/**
 *
 * @author mguzmana
 */
public class ClickEventJUnitTest {

    private FrameFixture window;

    public ClickEventJUnitTest() {
    }

    @Before
    public void setUp() {
        ClickEvent frame = GuiActionRunner.execute(() -> new ClickEvent());
        window = new FrameFixture(frame);
        window.show();
    }

    @Test
    public void testClickEvents() {
        window.button("nameA").requireVisible();
        window.button("nameB").requireVisible();
        window.button("nameB").click();
        assertEquals(window.label("result").text(), "My name is Juan");
    }

    @After
    public void tearDown() {
        window.cleanUp();
    }
}
