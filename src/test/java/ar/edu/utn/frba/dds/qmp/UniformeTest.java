package ar.edu.utn.frba.dds.qmp;

import ar.edu.utn.frba.dds.qmp.enums.Estilo;
import ar.edu.utn.frba.dds.qmp.enums.Material;
import ar.edu.utn.frba.dds.qmp.enums.TipoPrenda;
import ar.edu.utn.frba.dds.qmp.enums.Trama;
import ar.edu.utn.frba.dds.qmp.sastres.Sastre;
import ar.edu.utn.frba.dds.qmp.sastres.SastreJohnson;
import ar.edu.utn.frba.dds.qmp.sastres.SastreSanJuan;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UniformeTest {

  int temperaturaMaxima = 100;

  @Test
  public void sePuedeCrearUnUniformeConPrendasValidas() {
    Prenda superior = new Prenda(TipoPrenda.CHOMBA, Material.PIQUE, new Color(0, 100, 0), null, Trama.LISA, Estilo.FORMAL, temperaturaMaxima);
    Prenda inferior = new Prenda(TipoPrenda.PANTALON, Material.ACETATO, new Color(128, 128, 128), null, Trama.LISA, Estilo.FORMAL, temperaturaMaxima);
    Prenda calzado = new Prenda(TipoPrenda.ZAPATILLA, Material.CUERO, new Color(255, 255, 255), null, Trama.LISA, Estilo.FORMAL, temperaturaMaxima);

    Uniforme uniforme = new Uniforme(superior, inferior, calzado);

    assertEquals(superior, uniforme.getPrendaSuperior());
    assertEquals(inferior, uniforme.getPrendaInferior());
    assertEquals(calzado, uniforme.getCalzado());
  }

  @Test
  public void sastreSanJuanFabricaUnUniformeCorrecto() {
    Sastre sastre = new SastreSanJuan();
    Uniforme uniforme = sastre.fabricarUniforme();

    assertEquals(TipoPrenda.CHOMBA, uniforme.getPrendaSuperior().getTipo());
    assertEquals(Material.PIQUE, uniforme.getPrendaSuperior().getMaterial());
    assertEquals(TipoPrenda.PANTALON, uniforme.getPrendaInferior().getTipo());
    assertEquals(Material.ACETATO, uniforme.getPrendaInferior().getMaterial());
    assertEquals(TipoPrenda.ZAPATILLA, uniforme.getCalzado().getTipo());
    assertEquals(Material.CUERO, uniforme.getCalzado().getMaterial());
  }

  @Test
  public void sastreJohnsonFabricaUnUniformeCorrecto() {
    Sastre sastre = new SastreJohnson();
    Uniforme uniforme = sastre.fabricarUniforme();

    assertEquals(TipoPrenda.CAMISA, uniforme.getPrendaSuperior().getTipo());
    assertEquals(Material.ALGODON, uniforme.getPrendaSuperior().getMaterial());
    assertEquals(TipoPrenda.PANTALON, uniforme.getPrendaInferior().getTipo());
    assertEquals(Material.ALGODON, uniforme.getPrendaInferior().getMaterial());
    assertEquals(TipoPrenda.ZAPATO, uniforme.getCalzado().getTipo());
    assertEquals(Material.CUERO, uniforme.getCalzado().getMaterial());
  }
}
