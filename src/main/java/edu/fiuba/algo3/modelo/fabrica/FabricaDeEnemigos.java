package edu.fiuba.algo3.modelo.fabrica;

import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.enemigo.*;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.parcela.Parcela;

public class FabricaDeEnemigos implements FabricaDeElementos{
    public Defensa crearDefensa(String tipoDefensa) { return null; }

    public Enemigo crearEnemigo(String tipoEnemigo, Coordenadas coordenadas) {
        Enemigo enemigo = null;
        switch (tipoEnemigo.toLowerCase()) {
            case "araña":
                enemigo = new Arania(coordenadas);
                break;
            case "hormiga":
                enemigo = new Hormiga(coordenadas);
                break;
            case "lechuza":
                enemigo = new Lechuza(coordenadas);
                break;
            case "topo":
                enemigo = new Topo(coordenadas);
        }
        return enemigo;
    }

    public Parcela crearParcela(String tipoParcela, Coordenadas coordenadas) { return null; }

}