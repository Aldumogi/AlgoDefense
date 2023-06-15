package edu.fiuba.algo3.modelo.juego;
import edu.fiuba.algo3.modelo.exceptions.NoSePudoConstruirException;
import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.enemigo.Enemigo;
import edu.fiuba.algo3.modelo.enemigo.Hormiga;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.parcela.Tierra;

import java.util.ArrayList;
import java.util.List;

import static edu.fiuba.algo3.modelo.LoggerManager.logger;

public class Jugador {
    private ArrayList<Hormiga> hormigasAsesinadas;
    private int puntosDeVida;
    private int cantidadDeCreditos;
    private String nombre;
    private List<Defensa> defensas;

    public Jugador(String nombre){
        this.puntosDeVida = 20;
        this.cantidadDeCreditos = 100;
        this.nombre = nombre;
        this.defensas = new ArrayList<Defensa>();
        this.hormigasAsesinadas = new ArrayList<Hormiga>();
    }

    public int obtenerPuntosDeVida() {
        return this.puntosDeVida;
    }

    public int obtenerCantidadDeCreditos(){
        return this.cantidadDeCreditos;
    }

    public List<Defensa> obtenerDefensas(){
        return this.defensas;
    }

    public String obtenerNombre() {
        return this.nombre;
    }

    public void generarConstruccion(Defensa unaDefensa, Coordenadas coordenadas, Mapa mapa) throws NoSePudoConstruirException {
        if(this.cantidadDeCreditos >= unaDefensa.costo()){
            unaDefensa.construir(mapa, coordenadas);
            this.defensas.add(unaDefensa);
            this.cantidadDeCreditos -= unaDefensa.costo();
        }
    }


    public void finalizarTurno(List<Enemigo> enemigos, Mapa mapa){
        List<Defensa> trampasAEliminar = new ArrayList<>();
        this.defensas.forEach( defensa -> defensa.pasarTurno(enemigos, this.hormigasAsesinadas, this.defensas, mapa, trampasAEliminar) );
        for (Defensa trampa: trampasAEliminar) {
            this.defensas.remove(trampa);
        }
        this._agregarCreditosAlMatarEnemigos(enemigos);
    }

    private void _agregarCreditosAlMatarEnemigos(List<Enemigo> enemigos) {
        enemigos.forEach( enemigo -> {
            this.cantidadDeCreditos += enemigo.obtenerCreditos();
        } );
    }

    public boolean estaVivo() {
        return (this.puntosDeVida > 0);
    }

    public void restarEnergia(int energia) {
        this.puntosDeVida -= energia;
    }

    public void destruirPrimeraTorre() {
        if(this.defensas.isEmpty()){
            defensas.remove(0);
        }
    }
}
