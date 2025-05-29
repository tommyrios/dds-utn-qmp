package ar.edu.utn.frba.dds.qmp.clima;

import java.util.List;
import java.util.Map;

public interface AccuWeatherApi {
  List<Map<String, Object>> getWeather(String ciudad);
}

