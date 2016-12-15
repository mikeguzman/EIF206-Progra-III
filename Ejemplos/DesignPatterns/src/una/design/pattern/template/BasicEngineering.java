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
public abstract class BasicEngineering {

    private String math;
    private String softSkills;

    public void Papers() {
        //Common Papers:
        Math();
        SoftSkills();
        //Specialized Paper:
        SpecialPaper();
    }

    private void Math() {
        this.setMath("Mathematics");
        System.out.println("Mathematics");
    }

    private void SoftSkills() {
        this.setSoftSkills("SoftSkills");
        System.out.println("SoftSkills");
    }

    public String getMath() {
        return math;
    }

    public void setMath(String math) {
        this.math = math;
    }

    public String getSoftSkills() {
        return softSkills;
    }

    public void setSoftSkills(String softSkills) {
        this.softSkills = softSkills;
    }

    public abstract void SpecialPaper();
}
