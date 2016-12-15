/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package una.design.pattern.singleton;

/**
 *
 * @author mguzmana
 */
public class MakeACaptain {

    private static MakeACaptain _captain;
    //We make the constructor private to prevent the use of "new" 	

    private MakeACaptain() {
    }

    // public static synchronized MakeACaptain getCaptain()
    public static MakeACaptain getCaptain() {

        // Lazy initialization 
        if (_captain == null) {
            _captain = new MakeACaptain();
            System.out.println("New Captain selected for our team");
        } else {
            System.out.print("You already have a Captain for your team.");
            System.out.println("Send him for the toss.");
        }
        return _captain;

    }

    //Bill Pugh solution
    private static class SingletonHelper {

        private static final MakeACaptain _captain = new MakeACaptain();
    }

}
