package ar.edu.utn.frba.dds.qmp.sugerencias;

import ar.edu.utn.frba.dds.qmp.Atuendo;
import ar.edu.utn.frba.dds.qmp.Usuario;
import java.util.List;

public interface MotorDeSugerencias {
  List<Atuendo> generarSugerencias(Usuario usuario);
}
