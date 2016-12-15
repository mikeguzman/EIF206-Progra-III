/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package una.design.pattern.template;

/**
 *
 * @author mguzmana
 */
public class ComputerScience extends BasicEngineering {

    private String book;
    
    @Override
    public void SpecialPaper() {
        this.setBook("Object Oriented Programming");
        System.out.println("Object Oriented Programming");
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }
    
    
}
