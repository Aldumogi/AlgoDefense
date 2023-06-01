package edu.fiuba.algo3;
import edu.fiuba.algo3.exceptions.NoDisponibleParaConstruirException;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
    private int puntosDeVida;
    private int cantidadDeCreditos;
    private String nombre;
    private List<Defensa> defensas;
    private int hormigasMuertas;

    
    public Jugador(String nombre){
        this.puntosDeVida = 20;
        this.cantidadDeCreditos = 100;
        this.nombre = nombre;
        this.defensas = new ArrayList<Defensa>();
        this.hormigasMuertas = 0;
    }
    public int hormigasMuertas(){
        return this.hormigasMuertas;
    }
    public void mateUnaHormiga(){
        hormigasMuertas += 1;
    }
    public int obtenerPuntosDeVida() {
        return this.puntosDeVida;
    }
    public int obtenerCantidadDeCreditos(){
        return this.cantidadDeCreditos;
    }
    public void agregarCreditos(int creditos){
        this.cantidadDeCreditos += creditos;
    }

    public List<Defensa> obtenerDefensas(){
        return this.defensas;
    }
    public boolean generarConstruccion(Defensa unaDefensa, Coordenadas coordenadas, int numeroDeTurno){
        if(this.obtenerCantidadDeCreditos() >= unaDefensa.costo()){
            Tierra tierra = new Tierra(coordenadas);
            try{
                tierra.construir(unaDefensa, numeroDeTurno);
            }
            catch (NoDisponibleParaConstruirException e) {
                return false;
            }
            this.defensas.add(unaDefensa);
            this.cantidadDeCreditos -= unaDefensa.costo();
            return true;
        }
        return false;
    }
    public void actualizarDefensasAlFinalizarTurno(int numeroDeTurno){
        this.defensas.forEach(defensa -> defensa.actualizarEstado(numeroDeTurno));
    }
}
