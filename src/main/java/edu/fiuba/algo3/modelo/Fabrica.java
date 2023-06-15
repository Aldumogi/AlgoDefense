package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.defensa.TorreBlanca;
import edu.fiuba.algo3.modelo.defensa.TorrePlateada;
import edu.fiuba.algo3.modelo.defensa.TrampaArenosa;
import edu.fiuba.algo3.modelo.enemigo.*;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.parcela.*;

public class Fabrica {
    public static Defensa crearDefensa(String tipo) {
        Defensa defensa = null;
        switch( tipo.toLowerCase() ) {
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
    public static Enemigo crearEnemigo(String tipo, Coordenadas coordenadas) {
        Enemigo enemigo = null;
        switch( tipo.toLowerCase() ) {
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

    public static Parcela crearParcela(String tipo, Coordenadas coordenadas) {
        Parcela parcela = null;
        switch( tipo.toLowerCase() ) {
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
