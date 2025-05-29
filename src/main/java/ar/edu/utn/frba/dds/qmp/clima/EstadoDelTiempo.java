package ar.edu.utn.frba.dds.qmp.clima;

import ar.edu.utn.frba.dds.qmp.enums.Humedad;

public class EstadoDelTiempo {
  private final int temperatura;
  private final Humedad humedad;
  private final double probabilidadesPrecipitacion;

  public EstadoDelTiempo(int temperatura, double probabilidadesPrecipitacion) {
    this.temperatura = temperatura;
    this.humedad = probabilidadesPrecipitacion > 0.6 ? Humedad.ALTA : Humedad.BAJA;
    this.probabilidadesPrecipitacion = probabilidadesPrecipitacion;
  }

  public int getTemperatura() {
    return temperatura;
  }

  public Humedad getHumedad() {
    return humedad;
  }

  public double getProbabilidadesPrecipitacion() {
    return probabilidadesPrecipitacion;
  }
}
