package edu.fiuba.algo3;

import java.util.ArrayList;

public class Turno {
    private int turnoId;
    private ArrayList<Enemigo> listaEnemigosAgregadosEnElTurno = new ArrayList<>();

    public Turno(int turnoId) {
        this.turnoId = turnoId;
    }

    public Turno(int turnoId, int cantidadHormigas, int cantidadAranias) {
        this.turnoId = turnoId;
        this.agregarEnemigos(cantidadHormigas, cantidadAranias);
    }

    public void agregarEnemigos(int cantidadHormigas, int cantidadAranas) {
        for(int i = 0; i < cantidadHormigas; i++) {
            Enemigo enemigo = new Hormiga();
            this.listaEnemigosAgregadosEnElTurno.add(enemigo);
        }

        for(int i = 0; i < cantidadAranas; i++) {
            Enemigo enemigo = new Arania();
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
