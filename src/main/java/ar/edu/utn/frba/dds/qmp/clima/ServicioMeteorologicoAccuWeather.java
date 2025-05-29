package ar.edu.utn.frba.dds.qmp.clima;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServicioMeteorologicoAccuWeather implements ServicioMeteorologico {

  private final AccuWeatherApi apiClima;
  private final Duration tiempoDeValidez;
  private final Map<String, RespuestaMeteorologica> cache = new HashMap<>();

  public ServicioMeteorologicoAccuWeather(AccuWeatherApi apiClima, Duration tiempoDeValidez) {
    this.apiClima = apiClima;
    this.tiempoDeValidez = tiempoDeValidez;
  }

  @Override
  public EstadoDelTiempo obtenerCondicionesClimaticas(String ciudad) {
    if (cache.containsKey(ciudad) && !cache.get(ciudad).estaVencida()) {
      return cache.get(ciudad).estadoDelTiempo();
    }

    RespuestaMeteorologica respuesta = consultarApi(ciudad);
    cache.put(ciudad, respuesta);
    return respuesta.estadoDelTiempo();
  }

  public RespuestaMeteorologica consultarApi(String ciudad) {
    List<Map<String, Object>> respuestaApi = apiClima.getWeather(ciudad);

    Map<String, Object> datos = respuestaApi.get(0);
    int temperatura = (int) datos.get("Temperature");
    double probPrecipitacion = (double) datos.get("PrecipitationProbability");

    EstadoDelTiempo estado = new EstadoDelTiempo(temperatura, probPrecipitacion);
    return new RespuestaMeteorologica(estado, tiempoDeValidez);
  }
}
