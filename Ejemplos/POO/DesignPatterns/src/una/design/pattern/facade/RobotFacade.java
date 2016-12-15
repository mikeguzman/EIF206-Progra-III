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
public class RobotFacade {

    RobotColor rc;
    RobotMetal rm;
    RobotBody rb;

    public RobotFacade() {
        rc = new RobotColor();
        rm = new RobotMetal();
        rb = new RobotBody();

    }

    public void ConstructRobot(String color, String metal) {
        System.out.println("\nCreation of the Robot Start");
        rc.setColor(color);
        rm.setMetal(metal);
        rb.CreateBody();
        System.out.println(" \nRobot Creation End");
        System.out.println();
    }
}
