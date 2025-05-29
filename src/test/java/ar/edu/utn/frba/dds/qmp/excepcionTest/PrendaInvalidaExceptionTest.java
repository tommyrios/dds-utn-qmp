package ar.edu.utn.frba.dds.qmp.excepcionTest;

import ar.edu.utn.frba.dds.qmp.exceptions.PrendaInvalidaException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PrendaInvalidaExceptionTest {

  @Test
  public void sePuedeCrearYLeerElMensaje() {
    PrendaInvalidaException ex = new PrendaInvalidaException("La prenda es inválida");
    assertEquals("La prenda es inválida", ex.getMessage());
  }
}
