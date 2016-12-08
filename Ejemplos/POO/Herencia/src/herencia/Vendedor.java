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
public class Vendedor extends Empleado {

    /**
     *
     */
    protected double ventas;
    private double salarioFinal;

    /**
     *
     */
    public Vendedor() {
    }
    
    public Vendedor(String nombre, int anoIngreso, double salarioBase, double ventas) {
        super(nombre, anoIngreso, salarioBase);
        this.ventas = ventas;
    }

    /**
     *
     * @param ventas
     */
    public void sumarVentas(double ventas) {
        this.ventas = this.ventas + ventas;
    }

    /**
     *
     */
    public void calcularSalarioFinal() {
        this.salarioFinal = this.salarioBase + (this.ventas * 0.2);
    }

    /**
     *
     * @return
     */
    public double getVentas() {
        return ventas;
    }

    /**
     *
     * @param ventas
     */
    public void setVentas(double ventas) {
        this.ventas = ventas;
    }

    /**
     *
     * @return
     */
    public double getSalarioFinal() {
        return salarioFinal;
    }

    /**
     *
     * @param salarioFinal
     */
    public void setSalarioFinal(double salarioFinal) {
        this.salarioFinal = salarioFinal;
    }

    @Override
    public String toString() {
        return "Vendedor{" + "nombre=" + nombre + "ventas=" + ventas + ", salarioFinal=" + salarioFinal + '}';
    }
}
