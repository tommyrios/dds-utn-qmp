package ar.edu.utn.frba.dds.qmp;

import ar.edu.utn.frba.dds.qmp.enums.CategoriaPrenda;
import ar.edu.utn.frba.dds.qmp.enums.Estilo;
import ar.edu.utn.frba.dds.qmp.enums.Material;
import ar.edu.utn.frba.dds.qmp.enums.TipoPrenda;
import ar.edu.utn.frba.dds.qmp.enums.Trama;
import ar.edu.utn.frba.dds.qmp.exceptions.MaterialInvalidoException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PrendaTest {

  Color rojo = new Color(255, 0, 0);
  Color azul = new Color(0, 0, 255);
  int temparaturaMaxima = 100;

  @Test
  public void noPermitePrendaSinTipo() {
    Exception exception = assertThrows(NullPointerException.class, () ->
        new Prenda(null, Material.ALGODON, rojo, azul, Trama.LISA, null, temparaturaMaxima)
    );
    assertEquals("tipo de prenda es obligatorio", exception.getMessage());
  }

  @Test
  public void noPermitePrendaSinMaterial() {
    Exception exception = assertThrows(NullPointerException.class, () ->
        new Prenda(TipoPrenda.BUZO, null, rojo, null, Trama.CUADROS, null, temparaturaMaxima)
    );
    assertEquals("material de prenda es obligatorio", exception.getMessage());
  }

  @Test
  public void noPermitePrendaSinColorPrincipal() {
    Exception exception = assertThrows(NullPointerException.class, () ->
        new Prenda(TipoPrenda.POLLERA, Material.DENIM, null, rojo, Trama.LISA, null, temparaturaMaxima)
    );
    assertEquals("color de prenda es obligatorio", exception.getMessage());
  }

  @Test
  public void permiteColorSecundarioNull() {
    assertDoesNotThrow(() ->
        new Prenda(TipoPrenda.REMERA, Material.ALGODON, rojo, null, null, null, temparaturaMaxima)
    );
  }

  @Test
  public void categoriaDePrendaEsLaDelTipo() {
    Prenda remera = new Prenda(TipoPrenda.REMERA, Material.ALGODON, rojo, azul, Trama.CUADROS, null, temparaturaMaxima);
    assertEquals(CategoriaPrenda.PARTE_SUPERIOR, remera.getCategoria());
  }

  @Test
  public void unaRemeraNoEsCalzado() {
    Prenda remera = new Prenda(TipoPrenda.REMERA, Material.ALGODON, rojo, null, Trama.ESTAMPADO, null, temparaturaMaxima);
    assertNotEquals(CategoriaPrenda.CALZADO, remera.getCategoria());
    assertEquals(CategoriaPrenda.PARTE_SUPERIOR, remera.getCategoria());
  }

  @Test
  public void noSePuedeCrearPrendaConMaterialInvalido() {
    assertThrows(MaterialInvalidoException.class, () -> {
      new Prenda(TipoPrenda.ZAPATILLA, Material.DENIM, new Color(0, 0, 0), null, Trama.LISA, Estilo.FORMAL, temparaturaMaxima);
    });
  }

}
