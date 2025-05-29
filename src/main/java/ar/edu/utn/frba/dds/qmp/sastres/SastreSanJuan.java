package ar.edu.utn.frba.dds.qmp.sastres;

import ar.edu.utn.frba.dds.qmp.Borrador;
import ar.edu.utn.frba.dds.qmp.Color;
import ar.edu.utn.frba.dds.qmp.Prenda;
import ar.edu.utn.frba.dds.qmp.enums.Material;
import ar.edu.utn.frba.dds.qmp.enums.TipoPrenda;

public class SastreSanJuan extends Sastre {

  @Override
  protected Prenda fabricarParteSuperior() {
    Borrador borrador = new Borrador(TipoPrenda.CHOMBA);
    borrador.especificarMaterial(Material.PIQUE);
    borrador.especificarColorPrincipal(new Color(0, 100, 0)); // Verde
    return borrador.crearPrenda();
  }

  @Override
  protected Prenda fabricarParteInferior() {
    Borrador borrador = new Borrador(TipoPrenda.PANTALON);
    borrador.especificarMaterial(Material.ACETATO);
    borrador.especificarColorPrincipal(new Color(128, 128, 128)); // Gris
    return borrador.crearPrenda();
  }

  @Override
  protected Prenda fabricarCalzado() {
    Borrador borrador = new Borrador(TipoPrenda.ZAPATILLA);
    borrador.especificarMaterial(Material.CUERO);
    borrador.especificarColorPrincipal(new Color(255, 255, 255)); // Blanco
    return borrador.crearPrenda();
  }
}

