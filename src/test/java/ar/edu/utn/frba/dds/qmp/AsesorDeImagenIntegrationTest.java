package ar.edu.utn.frba.dds.qmp;

import ar.edu.utn.frba.dds.qmp.clima.AccuWeatherApi;
import ar.edu.utn.frba.dds.qmp.clima.*;
import ar.edu.utn.frba.dds.qmp.enums.*;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AsesorDeImagenIntegrationTest {

  Color blanco = new Color(100, 100, 100);
  Color azul = new Color(0, 0, 255);
  Color verde = new Color(0, 255, 0);

  Prenda remera = new Prenda(TipoPrenda.REMERA, Material.ALGODON, verde, null, Trama.LISA, Estilo.NEUTRO, 30);
  Prenda pantalon = new Prenda(TipoPrenda.PANTALON, Material.DENIM, azul, null, Trama.LISA, Estilo.NEUTRO, 25);
  Prenda zapas = new Prenda(TipoPrenda.ZAPATILLA, Material.CUERO, blanco, null, Trama.LISA, Estilo.NEUTRO, 35);

  Guardarropas guardarropas = new Guardarropas(
      List.of(remera),
      List.of(pantalon),
      List.of(zapas)
  );

  @Test
  public void sugerenciaDeAtuendoSegunTemperaturaActual() {
    AccuWeatherApi api = ciudad -> {
      java.util.Map<String, Object> condiciones = new java.util.HashMap<>();
      condiciones.put("Temperature", 22);
      condiciones.put("PrecipitationProbability", 0.2);
      return List.of(condiciones);
    };

    ServicioMeteorologico servicio = new ServicioMeteorologicoAccuWeather(api, Duration.ofHours(1));
    AsesorDeImagen asesor = new AsesorDeImagen(servicio);

    Atuendo sugerido = asesor.sugerirAtuendo("Buenos Aires", guardarropas);

    assertNotNull(sugerido);
    assertTrue(sugerido.aptoParaTemperatura(22));

    Prenda superior = sugerido.getPrendaSuperior();
    Prenda inferior = sugerido.getPrendaInferior();
    Prenda calzado = sugerido.getCalzado();

    System.out.println("Atuendo sugerido: " +
        superior.getTipo() +  " de " + superior.getMaterial() + ", " +
        inferior.getTipo() +  " de " + inferior.getMaterial() +  ", " +
        calzado.getTipo() + " de " + calzado.getMaterial() + ".");
  }
}
