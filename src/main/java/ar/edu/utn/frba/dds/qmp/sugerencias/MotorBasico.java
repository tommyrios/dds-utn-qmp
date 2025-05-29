package ar.edu.utn.frba.dds.qmp.sugerencias;

import ar.edu.utn.frba.dds.qmp.Atuendo;
import ar.edu.utn.frba.dds.qmp.Usuario;
import java.util.List;

public class MotorBasico implements MotorDeSugerencias {
  public List<Atuendo> generarSugerencias(Usuario usuario) {
    return usuario.getGuardarropas().generarTodasLasCombinaciones();
  }
}