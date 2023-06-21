package edu.fiuba.algo3.modelo.fabrica;

import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.enemigo.Enemigo;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.parcela.*;

public class FabricaDeParcelas implements FabricaDeElementos{
    public Defensa crearDefensa(String tipoDefensa) { return null; }

    public Enemigo crearEnemigo(String tipoEnemigo, Coordenadas coordenadas) { return null; }

    public Parcela crearParcela(String tipoParcela, Coordenadas coordenadas) {
        Parcela parcela = null;
        switch (tipoParcela.toLowerCase()) {
            case "largada":
                parcela = new PasarelaLargada(coordenadas);
                break;
            case "meta":
                parcela = new PasarelaMeta(coordenadas);
                break;
            case "pasarela":
                parcela = new PasarelaNormal(coordenadas);
                break;
            case "rocoso":
                parcela = new Rocoso(coordenadas);
                break;
            case "tierra":
                parcela = new Tierra(coordenadas);
        }
        return parcela;
    }
}