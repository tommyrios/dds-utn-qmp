package ar.edu.utn.frba.dds.qmp;

import ar.edu.utn.frba.dds.qmp.enums.Estilo;
import ar.edu.utn.frba.dds.qmp.enums.Material;
import ar.edu.utn.frba.dds.qmp.enums.TipoPrenda;
import ar.edu.utn.frba.dds.qmp.enums.Trama;
import ar.edu.utn.frba.dds.qmp.exceptions.MaterialInvalidoException;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GuardarropasTest {
  Color colorGenerico = new Color(1, 0, 25);
  int temperaturaMaxima = 100;

  Prenda p1 = new Prenda(TipoPrenda.BUZO, Material.ALGODON, colorGenerico, colorGenerico, null, null, temperaturaMaxima);
  Prenda p2 = new Prenda(TipoPrenda.REMERA, Material.ALGODON, colorGenerico, null, Trama.LISA, Estilo.FORMAL, temperaturaMaxima);
  Prenda p3 = new Prenda(TipoPrenda.POLLERA, Material.DENIM, colorGenerico, null, null, null, temperaturaMaxima);
  Prenda p4 = new Prenda(TipoPrenda.PANTALON, Material.GABARDINA, colorGenerico, null, Trama.CUADROS, Estilo.NEUTRO, temperaturaMaxima);
  Prenda p5 = new Prenda(TipoPrenda.ZAPATILLA, Material.CUERO, colorGenerico, null, null, null, temperaturaMaxima);

  @Test
  public void generarTodasCombinacionesFuncionaCorrectamente() {

    Guardarropas guardarropas = new Guardarropas(
        List.of(p1, p2),
        List.of(p3, p4),
        List.of(p5)
    );

    List<Atuendo> atuendos = guardarropas.generarTodasLasCombinaciones();
    assertEquals(4, atuendos.size());
  }

  @Test
  public void noSePuedeCrearGuardarropasConPrendaDeMaterialInvalido() {
    assertThrows(MaterialInvalidoException.class, () -> {
      Prenda p6 = new Prenda(TipoPrenda.ZAPATILLA, Material.SEDA, colorGenerico, null, null, null, temperaturaMaxima);
      new Guardarropas(List.of(p1), List.of(p4), List.of(p6));
    });
  }

}
