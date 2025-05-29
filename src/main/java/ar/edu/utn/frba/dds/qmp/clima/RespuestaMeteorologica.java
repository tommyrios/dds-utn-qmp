package ar.edu.utn.frba.dds.qmp.clima;

import java.time.Duration;
import java.time.LocalDateTime;

public class RespuestaMeteorologica {
  private final EstadoDelTiempo estadoDelTiempo;
  private final LocalDateTime vencimiento;

  public RespuestaMeteorologica(EstadoDelTiempo estadoDelTiempo, Duration duracionValidez) {
    this.estadoDelTiempo = estadoDelTiempo;
    this.vencimiento = LocalDateTime.now().plus(duracionValidez);
  }

  public boolean estaVencida() {
    return LocalDateTime.now().isAfter(vencimiento);
  }

  public EstadoDelTiempo estadoDelTiempo() {
    return estadoDelTiempo;
  }
}

