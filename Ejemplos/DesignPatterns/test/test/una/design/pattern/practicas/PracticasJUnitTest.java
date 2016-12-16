/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.una.design.pattern.practicas;

import org.junit.Test;
import static org.junit.Assert.*;
import una.design.pattern.practicas.FachadaImpresora;

/**
 *
 * @author mguzmana
 */
public class PracticasJUnitTest {
    
    public PracticasJUnitTest() {
    }

    @Test
    public void testFachadaImpresora() {
        FachadaImpresora impresora = new FachadaImpresora();
        String impresion1 = impresora.imprimirNormal("texto1");
        String impresion2 = impresora.imprimirDiferente("texto2");
        
        System.out.println(impresion2);
        
        assertEquals(impresion1, "Impresora {tipoDocumento=PDF, hoja=A4, color=true, texto=texto1}");
        assertEquals(impresion2, "Impresora {tipoDocumento=excel, hoja=a3, color=false, texto=texto2}");
    }
}