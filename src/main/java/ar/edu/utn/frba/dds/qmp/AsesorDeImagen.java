package ar.edu.utn.frba.dds.qmp;

import ar.edu.utn.frba.dds.qmp.clima.EstadoDelTiempo;
import ar.edu.utn.frba.dds.qmp.clima.ServicioMeteorologico;

public class AsesorDeImagen {
  private final ServicioMeteorologico servicio;

  public AsesorDeImagen(ServicioMeteorologico servicio) {
    this.servicio = servicio;
  }

  public Atuendo sugerirAtuendo(String ciudad, Guardarropas guardarropas) {
    EstadoDelTiempo clima = servicio.obtenerCondicionesClimaticas(ciudad);

    return guardarropas.generarTodasLasCombinaciones().stream()
        .filter(a -> a.aptoParaTemperatura(clima.getTemperatura()))
        .findFirst()
        .orElseThrow(() -> new RuntimeException("No hay atuendos válidos"));
  }
}

