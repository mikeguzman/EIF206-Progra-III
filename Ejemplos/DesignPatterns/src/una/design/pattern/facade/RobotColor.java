/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package una.design.pattern.facade;

/**
 *
 * @author mguzmana
 */
public class RobotColor {

    private String color;

    public void setColor(String color) {
        this.color = color;
        System.out.println("Color is set to : " + this.color);
    }
}
