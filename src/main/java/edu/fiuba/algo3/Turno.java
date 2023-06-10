package edu.fiuba.algo3;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Turno {
    private int turnoId;
    private ArrayList<Enemigo> listaEnemigosAgregadosEnElTurno = new ArrayList<>();

    public Turno(int turnoId) {
        this.turnoId = turnoId;
    }

    public Turno(int turnoId, int cantidadHormigas, int cantidadAranias, Coordenadas coordenadasLargada) {
        this.turnoId = turnoId;
        this.agregarEnemigos(cantidadHormigas, cantidadAranias, coordenadasLargada);
    }

    public void agregarEnemigos(int cantidadHormigas, int cantidadAranas, Coordenadas coordenadasLargada) {
        for(int i = 0; i < cantidadHormigas; i++) {
            Enemigo enemigo = new Hormiga(coordenadasLargada);
            this.listaEnemigosAgregadosEnElTurno.add(enemigo);
        }

        for(int i = 0; i < cantidadAranas; i++) {
            Enemigo enemigo = new Arania(coordenadasLargada);
            this.listaEnemigosAgregadosEnElTurno.add(enemigo);
        }
    }

    public int getTurnoId() {
        return this.turnoId;
    }

    public ArrayList<Enemigo> getListaEnemigosAgregadosEnElTurno() {
        return this.listaEnemigosAgregadosEnElTurno;
    }
}
