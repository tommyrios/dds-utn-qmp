package ar.edu.utn.frba.dds.qmp;

import ar.edu.utn.frba.dds.qmp.enums.*;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class AtuendoTest {

  Color color = new Color(100, 100, 100);

  Prenda remera = new Prenda(TipoPrenda.REMERA, Material.ALGODON, color, null, Trama.LISA, Estilo.NEUTRO, 25);
  Prenda pantalon = new Prenda(TipoPrenda.PANTALON, Material.DENIM, color, null, Trama.LISA, Estilo.NEUTRO, 30);
  Prenda zapas = new Prenda(TipoPrenda.ZAPATILLA, Material.CUERO, color, null, Trama.LISA, Estilo.NEUTRO, 35);

  @Test
  public void atuendoEsAptoSiTodasLasPrendasSonAptasParaTemperatura() {
    Atuendo atuendo = new Atuendo(remera, pantalon, zapas);

    assertTrue(atuendo.aptoParaTemperatura(24));
    assertFalse(atuendo.aptoParaTemperatura(28));
  }
}
