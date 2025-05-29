package ar.edu.utn.frba.dds.qmp.sastres;

import ar.edu.utn.frba.dds.qmp.Prenda;
import ar.edu.utn.frba.dds.qmp.Uniforme;

public abstract class Sastre {
  public Uniforme fabricarUniforme() {
    return new Uniforme(this.fabricarParteSuperior(),
                 this.fabricarParteInferior(),
                 this.fabricarCalzado());
  }

  protected abstract Prenda fabricarParteSuperior();

  protected abstract Prenda fabricarParteInferior();

  protected abstract Prenda fabricarCalzado();
}
