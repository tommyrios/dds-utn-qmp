package ar.edu.utn.frba.dds.qmp;

import ar.edu.utn.frba.dds.qmp.enums.*;
import ar.edu.utn.frba.dds.qmp.sugerencias.MotorDeSugerencias;
import ar.edu.utn.frba.dds.qmp.sugerencias.MotorMayores;
import ar.edu.utn.frba.dds.qmp.sugerencias.MotorBasico;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class SastresTest {

  int temperaturaMaxima = 100;

  @Test
  public void elMotorBasicoGeneraSugerenciasConTodasLasCombinaciones() {
    Guardarropas guardarropas = new Guardarropas(
        List.of(new Prenda(TipoPrenda.REMERA, Material.ALGODON, new Color(10, 10, 10), null, Trama.LISA, Estilo.NEUTRO, temperaturaMaxima)),
        List.of(new Prenda(TipoPrenda.PANTALON, Material.DENIM, new Color(20, 20, 20), null, Trama.LISA, Estilo.NEUTRO, temperaturaMaxima)),
        List.of(new Prenda(TipoPrenda.ZAPATILLA, Material.CUERO, new Color(30, 30, 30), null, Trama.LISA, Estilo.NEUTRO, temperaturaMaxima))
    );
    Usuario usuario = new Usuario(25, guardarropas);
    MotorDeSugerencias motor = new MotorBasico();

    List<Atuendo> sugerencias = motor.generarSugerencias(usuario);

    assertEquals(1, sugerencias.size());
    Atuendo atuendo = sugerencias.get(0);
    assertNotNull(atuendo.getPrendaSuperior());
    assertNotNull(atuendo.getPrendaInferior());
    assertNotNull(atuendo.getCalzado());
  }

  @Test
  public void elMotorMayoresFiltraPrendasInformalesSiUsuarioEsMayor() {
    Guardarropas guardarropas = new Guardarropas(
        List.of(new Prenda(TipoPrenda.REMERA, Material.ALGODON, new Color(10, 10, 10), null, Trama.LISA, Estilo.INFORMAL, temperaturaMaxima)),
        List.of(new Prenda(TipoPrenda.PANTALON, Material.DENIM, new Color(20, 20, 20), null, Trama.LISA, Estilo.FORMAL, temperaturaMaxima)),
        List.of(new Prenda(TipoPrenda.ZAPATILLA, Material.CUERO, new Color(30, 30, 30), null, Trama.LISA, Estilo.FORMAL, temperaturaMaxima))
    );
    Usuario usuario = new Usuario(60, guardarropas);
    MotorDeSugerencias motor = new MotorMayores();

    List<Atuendo> sugerencias = motor.generarSugerencias(usuario);

    assertEquals(0, sugerencias.size());
  }
}
