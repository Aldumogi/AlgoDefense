package edu.fiuba.algo3;

import edu.fiuba.algo3.exceptions.NoDisponibleParaConstruirException;

public abstract class Defensa {
    private String nombre;
    private int costo;
    private int tiempoDeConstruccion;
    private int rangoDeAtaque;
    private int danio;
    private int turnoEnElQueSeInicioLaConstruccion;

    public String nombre(){
        return this.nombre;
    }
    public int costo(){
        return this.costo;
    }
    public int tiempoDeConstruccion(){
        return this.tiempoDeConstruccion;
    }
    public int rangoDeAtaque(){
        return this.rangoDeAtaque;
    }
    public int danio(){
        return this.danio;
    }
    public void nombre(String unNombre){
        this.nombre = unNombre;
    }
    public void costo(int unCosto){
        this.costo = unCosto;
    }
    public void tiempoDeConstruccion(int unTiempo){
        this.tiempoDeConstruccion = unTiempo;
    }
    public void rangoDeAtaque(int unRango){
        this.rangoDeAtaque = unRango;
    }
    public void danio(int unDanio){
        this.danio =  unDanio;
    }
    protected AccionesDefensa estado;
    public abstract Boolean atacarEnemigo(Enemigo enemigo);
    public AccionesDefensa obtenerEstado(){
        return this.estado;
    }
    public void actualizarEstado(int numeroDeTurno) {
        if( numeroDeTurno - this.turnoEnElQueSeInicioLaConstruccion == this.tiempoDeConstruccion ) {
            this.estado = new Terminada();
        }
    }
    public abstract boolean construir(Coordenadas coordenadas) ;
}
