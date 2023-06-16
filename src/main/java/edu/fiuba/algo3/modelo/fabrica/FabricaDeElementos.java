package edu.fiuba.algo3.modelo.fabrica;

import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.enemigo.Enemigo;
import edu.fiuba.algo3.modelo.parcela.Parcela;

public interface FabricaDeElementos {
    Defensa crearDefensa(String tipoDefensa);
    Enemigo crearEnemigo(String tipoEnemigo, Coordenadas coordenadas);
    Parcela crearParcela(String tipoParcela, Coordenadas coordenadas);
}
