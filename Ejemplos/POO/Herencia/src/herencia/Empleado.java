/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

/**
 *
 * @author mguzmana
 */
public class Empleado {

    private int ANO_ACTUAL = 2016;

    /**
     *
     */
    protected String nombre;

    /**
     *
     */
    protected int anoIngreso;

    /**
     *
     */
    protected double salarioBase;
    private int anosEmpresa;

    /**
     *
     */
    public Empleado() {
    }

    /**
     *
     * @param nombre
     * @param anoIngreso
     * @param salarioBase
     * @param anosEmpresa
     */
    public Empleado(String nombre, int anoIngreso, double salarioBase) {
        this.nombre = nombre;
        this.anoIngreso = anoIngreso;
        this.salarioBase = salarioBase;
    }

    /**
     *
     * @param nombre
     */
    public void cambiarNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     */
    public void calcularAnosEmpresa() {
        this.anosEmpresa = (ANO_ACTUAL - this.anoIngreso);
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    public int getAnoIngreso() {
        return anoIngreso;
    }

    /**
     *
     * @param anoIngreso
     */
    public void setAnoIngreso(int anoIngreso) {
        this.anoIngreso = anoIngreso;
    }

    /**
     *
     * @return
     */
    public double getSalarioBase() {
        return salarioBase;
    }

    /**
     *
     * @param salarioBase
     */
    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    /**
     *
     * @return
     */
    public int getAnosEmpresa() {
        return anosEmpresa;
    }

    /**
     *
     * @param anosEmpresa
     */
    public void setAnosEmpresa(int anosEmpresa) {
        this.anosEmpresa = anosEmpresa;
    }

    @Override
    public String toString() {
        return "Empleado{" + "nombre=" + nombre + ", anoIngreso=" + anoIngreso + ", salarioBase=" + salarioBase + ", anosEmpresa=" + anosEmpresa + '}';
    }

}
