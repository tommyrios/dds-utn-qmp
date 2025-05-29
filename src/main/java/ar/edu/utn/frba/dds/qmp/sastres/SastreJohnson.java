package ar.edu.utn.frba.dds.qmp.sastres;

import ar.edu.utn.frba.dds.qmp.Borrador;
import ar.edu.utn.frba.dds.qmp.Color;
import ar.edu.utn.frba.dds.qmp.Prenda;
import ar.edu.utn.frba.dds.qmp.enums.Material;
import ar.edu.utn.frba.dds.qmp.enums.TipoPrenda;

public class SastreJohnson extends Sastre {

  @Override
  protected Prenda fabricarParteSuperior() {
    Borrador borrador = new Borrador(TipoPrenda.CAMISA);
    borrador.especificarMaterial(Material.ALGODON);
    borrador.especificarColorPrincipal(new Color(255, 255, 255));
    return borrador.crearPrenda();
  }

  @Override
  protected Prenda fabricarParteInferior() {
    Borrador borrador = new Borrador(TipoPrenda.PANTALON);
    borrador.especificarMaterial(Material.ALGODON);
    borrador.especificarColorPrincipal(new Color(0, 0, 0));
    return borrador.crearPrenda();
  }

  @Override
  protected Prenda fabricarCalzado() {
    Borrador borrador = new Borrador(TipoPrenda.ZAPATO);
    borrador.especificarMaterial(Material.CUERO);
    borrador.especificarColorPrincipal(new Color(0, 0, 0));
    return borrador.crearPrenda();
  }
}
