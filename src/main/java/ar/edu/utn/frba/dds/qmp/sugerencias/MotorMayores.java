package ar.edu.utn.frba.dds.qmp.sugerencias;

import ar.edu.utn.frba.dds.qmp.Atuendo;
import ar.edu.utn.frba.dds.qmp.Prenda;
import ar.edu.utn.frba.dds.qmp.Usuario;
import ar.edu.utn.frba.dds.qmp.enums.Estilo;
import java.util.ArrayList;
import java.util.List;

public class MotorMayores implements MotorDeSugerencias {
  public List<Atuendo> generarSugerencias(Usuario usuario) {
    var prendasSup = usuario.getGuardarropas().getPrendasSuperiores()
        .stream().filter(p -> usuario.esMayorDe55()
                                ? p.getEstilo() != Estilo.INFORMAL : true).toList();
    var prendasInf = usuario.getGuardarropas().getPrendasInferiores()
        .stream().filter(p -> usuario.esMayorDe55()
                                ? p.getEstilo() != Estilo.INFORMAL : true).toList();
    var calzados = usuario.getGuardarropas().getCalzados()
        .stream().filter(p -> usuario.esMayorDe55()
                                ? p.getEstilo() != Estilo.INFORMAL : true).toList();

    List<Atuendo> atuendos = new ArrayList<>();
    for (Prenda s : prendasSup) {
      for (Prenda i : prendasInf) {
        for (Prenda c : calzados) {
          atuendos.add(new Atuendo(s, i, c));
        }
      }
    }
    return atuendos;
  }
}
