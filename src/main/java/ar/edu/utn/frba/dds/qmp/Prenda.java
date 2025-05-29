package ar.edu.utn.frba.dds.qmp;

import static java.util.Objects.requireNonNull;

import ar.edu.utn.frba.dds.qmp.enums.CategoriaPrenda;
import ar.edu.utn.frba.dds.qmp.enums.Estilo;
import ar.edu.utn.frba.dds.qmp.enums.Material;
import ar.edu.utn.frba.dds.qmp.enums.TipoPrenda;
import ar.edu.utn.frba.dds.qmp.enums.Trama;
import ar.edu.utn.frba.dds.qmp.exceptions.MaterialInvalidoException;

public class Prenda {
  private final TipoPrenda tipo;
  private final Material material;
  private final Color color;
  private final Color colorSecundario;
  private final Trama trama;
  private final Estilo estilo;
  private final int temperaturaMaxima;

  public Prenda(TipoPrenda tipo,
                Material material,
                Color color,
                Color colorSecundario,
                Trama trama,
                Estilo estilo,
                int temperaturaMaxima) {
    this.tipo = requireNonNull(tipo, "tipo de prenda es obligatorio");
    this.material = requireNonNull(material, "material de prenda es obligatorio");
    this.color = requireNonNull(color, "color de prenda es obligatorio");
    this.colorSecundario = colorSecundario;
    this.trama = trama;
    this.estilo = estilo;
    this.temperaturaMaxima = temperaturaMaxima;

    this.validar();
  }

  private void validar() {
    if (!tipo.materialesValidos().contains(material)) {
      throw new MaterialInvalidoException("El material " + material
                                          + " no es válido para el tipo " + tipo);
    }
  }

  public CategoriaPrenda getCategoria() {
    return tipo.getCategoria();
  }

  public boolean aptaParaTemperatura(int temperatura) {
    return temperatura <= temperaturaMaxima;
  }

  public TipoPrenda getTipo() {
    return tipo;
  }

  public Material getMaterial() {
    return material;
  }

  public Estilo getEstilo() {
    return estilo;
  }

  public Color getColorPrincipal() {
    return color;
  }

  public boolean esSuperior(Prenda prenda) {
    return prenda.getCategoria().equals(CategoriaPrenda.PARTE_SUPERIOR);
  }

  public boolean esInferior(Prenda prenda) {
    return prenda.getCategoria().equals(CategoriaPrenda.PARTE_INFERIOR);
  }

  public boolean esCalzado(Prenda prenda) {
    return prenda.getCategoria().equals(CategoriaPrenda.CALZADO);
  }

}