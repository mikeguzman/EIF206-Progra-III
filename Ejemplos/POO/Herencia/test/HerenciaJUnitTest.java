/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import herencia.Empleado;
import herencia.Gerente;
import herencia.Vendedor;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mguzmana
 */
public class HerenciaJUnitTest {

    public HerenciaJUnitTest() {
    }

    @Test
    public void testEmpleado() {
        Empleado empleado = new Empleado("Juan", 2000, 250000);
        empleado.calcularAnosEmpresa();

        assertEquals("Calcular los años en la empresa: ", empleado.getAnosEmpresa(), 16);
        assertEquals("Nombre del empleado", empleado.getNombre(), "Juan");

        empleado.cambiarNombre("Mike");

        assertEquals("Nombre Actualizado", empleado.getNombre(), "Mike");
    }

    @Test
    public void testVendedor() {
        double salarioEsperado = 1020000;
        double ventasEsperadas = 300000;
        Vendedor vendedor = new Vendedor("Juan", 2000, 1000000, 100000);

        vendedor.calcularSalarioFinal();

        assertEquals("Calcular salario final: ", vendedor.getSalarioFinal(), salarioEsperado, 0);

        vendedor.sumarVentas(200000);
        assertEquals("Calcular ventas: ", vendedor.getVentas(), ventasEsperadas, 0);

        assertEquals("Nombre del empleado", vendedor.getNombre(), "Juan");
    }

    @Test
    public void testGerente() {
        double salarioEsperado = 2200000;
        double bonificacionEsperada = 200000;

        Gerente gerente = new Gerente("Pedro", 2000, 2000000, 100000);

        gerente.sumarBonificacion(100000);
        assertEquals("Sumar Bonificacion: ", gerente.getBonificacion(), bonificacionEsperada, 0);

        gerente.calcularSalarioFinal();
        assertEquals("Calcular salario final: ", gerente.getSalarioFinal(), salarioEsperado, 0);
        
        assertEquals("Nombre del empleado", gerente.getNombre(), "Pedro");
    }
}
