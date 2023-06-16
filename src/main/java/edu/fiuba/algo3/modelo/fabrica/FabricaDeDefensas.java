package edu.fiuba.algo3.modelo.fabrica;

import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.defensa.TorreBlanca;
import edu.fiuba.algo3.modelo.defensa.TorrePlateada;
import edu.fiuba.algo3.modelo.defensa.TrampaArenosa;
import edu.fiuba.algo3.modelo.enemigo.Enemigo;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.parcela.Parcela;

public class FabricaDeDefensas implements FabricaDeElementos {
    public Defensa crearDefensa(String tipoDefensa) {
        Defensa defensa = null;
        switch (tipoDefensa.toLowerCase()) {
            case "torre blanca":
                defensa = new TorreBlanca();
                break;
            case "torre plateada":
                defensa = new TorrePlateada();
                break;
            case "trampa arenosa":
                defensa = new TrampaArenosa();
        }
        return defensa;
    }

    public Enemigo crearEnemigo(String tipoEnemigo, Coordenadas coordenadas) { return null; }

    public Parcela crearParcela(String tipoParcela, Coordenadas coordenadas) { return null; }

}