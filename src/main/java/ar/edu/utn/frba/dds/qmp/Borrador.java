package ar.edu.utn.frba.dds.qmp;

import static java.util.Objects.requireNonNull;

import ar.edu.utn.frba.dds.qmp.enums.Estilo;
import ar.edu.utn.frba.dds.qmp.enums.Material;
import ar.edu.utn.frba.dds.qmp.enums.TipoPrenda;
import ar.edu.utn.frba.dds.qmp.enums.Trama;

public class Borrador {
  private final TipoPrenda tipo;
  private Material material;
  private Color colorPrincipal;
  private Color colorSecundario;
  private Trama trama = Trama.LISA;
  private Estilo estilo;
  private int temperaturaMaxima;

  public Borrador(TipoPrenda tipo) {
    requireNonNull(tipo);
    this.tipo = tipo;
  }

  public void especificarMaterial(Material material) {
    requireNonNull(material);
    this.material = material;
  }

  public void especificarColorPrincipal(Color colorPrincipal) {
    requireNonNull(colorPrincipal);
    this.colorPrincipal = colorPrincipal;
  }

  public void especificarColorSecundario(Color colorSecundario) {
    this.colorSecundario = colorSecundario;
  }

  public void especificarTrama(Trama trama) {
    this.trama = trama;
  }

  public void especificarEstilo(Estilo estilo) {
    this.estilo = estilo;
  }

  public void especificarTemperaturaMaxima(int temperatura) {
    this.temperaturaMaxima = temperatura;
  }

  public Prenda crearPrenda() {
    return new Prenda(tipo,
                      material,
                      colorPrincipal,
                      colorSecundario,
                      trama,
                      estilo,
                      temperaturaMaxima);
  }
}
