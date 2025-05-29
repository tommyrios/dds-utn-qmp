package ar.edu.utn.frba.dds.qmp;

import static java.util.Objects.requireNonNull;

import java.util.List;

public class Atuendo {
  private final Prenda prendaSuperior;
  private final Prenda prendaInferior;
  private final Prenda calzado;
  private final List<Prenda> accesorios;

  public Atuendo(Prenda prendaSuperior, Prenda prendaInferior, Prenda calzado) {
    this(prendaSuperior, prendaInferior, calzado, List.of());
  }

  public Atuendo(Prenda prendaSuperior,
                 Prenda prendaInferior,
                 Prenda calzado,
                 List<Prenda> accesorios) {
    this.prendaSuperior = requireNonNull(prendaSuperior);
    this.prendaInferior = requireNonNull(prendaInferior);
    this.calzado = requireNonNull(calzado);
    this.accesorios = accesorios != null ? accesorios : List.of();
  }

  public boolean aptoParaTemperatura(int temperatura) {
    return prendaSuperior.aptaParaTemperatura(temperatura)
        && prendaInferior.aptaParaTemperatura(temperatura)
        && calzado.aptaParaTemperatura(temperatura);
  }

  public Prenda getPrendaSuperior() {
    return prendaSuperior;
  }

  public Prenda getPrendaInferior() {
    return prendaInferior;
  }

  public Prenda getCalzado() {
    return calzado;
  }

  public List<Prenda> getAccesorios() {
    return List.copyOf(accesorios);
  }

}
