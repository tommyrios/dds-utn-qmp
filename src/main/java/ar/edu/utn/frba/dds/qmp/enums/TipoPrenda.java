package ar.edu.utn.frba.dds.qmp.enums;

import java.util.Set;

public enum TipoPrenda {
  REMERA(CategoriaPrenda.PARTE_SUPERIOR,
         Set.of(Material.ALGODON, Material.PIQUE, Material.POLYESTER)),
  CAMISA(CategoriaPrenda.PARTE_SUPERIOR, Set.of(Material.ALGODON, Material.LANA, Material.SEDA)),
  PANTALON(CategoriaPrenda.PARTE_INFERIOR,
           Set.of(Material.DENIM, Material.ACETATO, Material.GABARDINA, Material.ALGODON)),
  ZAPATO(CategoriaPrenda.CALZADO, Set.of(Material.CUERO)),
  ZAPATILLA(CategoriaPrenda.CALZADO, Set.of(Material.CUERO, Material.ALGODON)),
  POLLERA(CategoriaPrenda.PARTE_INFERIOR,
          Set.of(Material.ALGODON, Material.POLYESTER, Material.DENIM)),
  CHOMBA(CategoriaPrenda.PARTE_SUPERIOR, Set.of(Material.PIQUE, Material.ALGODON)),
  CAMISA_ESCOLAR(CategoriaPrenda.PARTE_SUPERIOR, Set.of(Material.ALGODON, Material.POLYESTER)),
  BUZO(CategoriaPrenda.PARTE_SUPERIOR, Set.of(Material.ALGODON, Material.POLYESTER)),;

  private final CategoriaPrenda categoria;
  private final Set<Material> materialesValidos;

  TipoPrenda(CategoriaPrenda categoria, Set<Material> materialesValidos) {
    this.categoria = categoria;
    this.materialesValidos = materialesValidos;
  }


  public CategoriaPrenda getCategoria() {
    return categoria;
  }

  public Set<Material> materialesValidos() {
    return Set.copyOf(this.materialesValidos); // vista inmutable
  }
}
