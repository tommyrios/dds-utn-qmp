package ar.edu.utn.frba.dds.qmp.excepcionTest;

import ar.edu.utn.frba.dds.qmp.exceptions.MaterialInvalidoException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MaterialInvalidoExceptionTest {

  @Test
  public void sePuedeCrearYLeerElMensaje() {
    MaterialInvalidoException ex = new MaterialInvalidoException("material no válido");
    assertEquals("material no válido", ex.getMessage());
  }
}
