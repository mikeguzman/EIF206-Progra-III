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
import org.junit.Test;
import org.junit.Before;
import una.ui.swing.frame.Authenticator;

/**
 *
 * @author mguzmana
 */
public class AuthenticatorJUnitTest {

    private FrameFixture window;
    private JPanelFixture panel;

    public AuthenticatorJUnitTest() {
    }

    @Before
    public void setUp() {
        Authenticator frame = GuiActionRunner.execute(() -> new Authenticator());
        window = new FrameFixture(frame);
        window.show();
        panel = window.panel("Form");
    }

    @Test
    public void testVisibleComponents() {
        panel.label("lblUsername").requireVisible();
        panel.label("lblPassword").requireVisible();
        panel.label("lblComments").requireVisible();
        panel.textBox("username").requireVisible();
        panel.textBox("password").requireVisible();
        panel.textBox("comments").requireVisible();
        panel.button("ok").requireVisible();
        panel.button("cancel").requireVisible();
    }

    @After
    public void tearDown() {
        window.cleanUp();
    }
}
