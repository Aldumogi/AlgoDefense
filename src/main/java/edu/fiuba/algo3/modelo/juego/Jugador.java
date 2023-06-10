package edu.fiuba.algo3.modelo.juego;
import edu.fiuba.algo3.modelo.exceptions.NoSePudoConstruirException;
import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.enemigo.Enemigo;
import edu.fiuba.algo3.modelo.enemigo.Hormiga;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
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

    public void generarConstruccion(Defensa unaDefensa, Coordenadas coordenadas) throws NoSePudoConstruirException {
        if(this.cantidadDeCreditos >= unaDefensa.costo()){
            Tierra tierra = new Tierra(coordenadas);
            tierra.construir(unaDefensa);
            this.defensas.add(unaDefensa);
            this.cantidadDeCreditos -= unaDefensa.costo();
        }

        logger.info("El jugador creó una" + unaDefensa.getNombre());
    }

    public void finalizarTurno(List<Enemigo> enemigos){
        this.defensas.forEach( defensa -> defensa.pasarTurno(enemigos, this.hormigasAsesinadas) );
        this.agregarCreditosAlMatarEnemigos(enemigos);
    }

    private void agregarCreditosAlMatarEnemigos(List<Enemigo> enemigos) {
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
}
