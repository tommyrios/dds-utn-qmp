package ar.edu.utn.frba.dds.qmp;

import static java.util.List.copyOf;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Guardarropas {
  private List<Prenda> prendasSuperiores;
  private List<Prenda> prendasInferiores;
  private List<Prenda> calzados;

  public Guardarropas(List<Prenda> prendasSuperiores,
                      List<Prenda> prendasInferiores,
                      List<Prenda> calzados) {
    this.prendasSuperiores = new ArrayList<>(prendasSuperiores);
    this.prendasInferiores = new ArrayList<>(prendasInferiores);
    this.calzados = new ArrayList<>(calzados);
  }

  public Atuendo generarSugerencia() {
    return new Atuendo(
        elegirAlAzar(prendasSuperiores),
        elegirAlAzar(prendasInferiores),
        elegirAlAzar(calzados));
  }

  private static final Random random = new Random();

  private <T> T elegirAlAzar(List<T> lista) {
    return lista.get(random.nextInt(lista.size()));
  }

  public List<Atuendo> generarTodasLasCombinaciones() {
    List<Atuendo> atuendos = new ArrayList<>();
    for (Prenda sup : prendasSuperiores) {
      for (Prenda inf : prendasInferiores) {
        for (Prenda calz : calzados) {
          atuendos.add(new Atuendo(sup, inf, calz));
        }
      }
    }
    return atuendos;
  }

  public List<Prenda> getPrendasSuperiores() {
    return copyOf(prendasSuperiores);
  }

  public List<Prenda> getPrendasInferiores() {
    return copyOf(prendasInferiores);
  }

  public List<Prenda> getCalzados() {
    return copyOf(calzados);
  }

  public void anadirPrenda(Prenda prenda) {
    if (prenda.esSuperior(prenda)) {
      prendasSuperiores.add(prenda);
    }
    if (prenda.esInferior(prenda)) {
      prendasInferiores.add(prenda);
    }
    if (prenda.esCalzado(prenda)) {
      calzados.add(prenda);
    }
  }
}
