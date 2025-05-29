package ar.edu.utn.frba.dds.qmp;

import ar.edu.utn.frba.dds.qmp.sugerencias.MotorDeSugerencias;
import java.util.List;

public class Usuario {
  private int edad;
  private Guardarropas guardarropas;

  public Usuario(int edad, Guardarropas guardarropas) {
    this.edad = edad;
    this.guardarropas = guardarropas;
  }

  public boolean esMayorDe55() {
    return edad > 55;
  }

  public List<Atuendo> generarSugerencias(MotorDeSugerencias motorSugerencias) {
    return motorSugerencias.generarSugerencias(this);
  }

  public Guardarropas getGuardarropas() {
    return guardarropas;
  }
}

