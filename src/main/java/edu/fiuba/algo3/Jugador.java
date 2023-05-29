package edu.fiuba.algo3;
import java.util.ArrayList;
import java.util.List;

public class Jugador {
    private int puntosDeVida;
    private int cantidadDeCreditos;
    private String nombre;
    private List<Defensa> defensas;

    
    public Jugador(String nombre){
        this.puntosDeVida = 20;
        this.cantidadDeCreditos = 100;
        this.nombre = nombre;
        this.defensas = new ArrayList<Defensa>();
    }
    public int obtenerPuntosDeVida() {
        return this.puntosDeVida;
    }
    public int obtenerCantidadDeCreditos(){
        return this.cantidadDeCreditos;
    }
    //public void creditos(int unosCreditos){
      //  cantidadDeCreditos;
    //}
    public List<Defensa> obtenerDefensas(){
        return this.defensas;
    }
    public boolean generarConstruccion(Defensa unaDefensa){
        if(this.obtenerCantidadDeCreditos() >= unaDefensa.costo()){
            this.defensas.add(unaDefensa);
            this.cantidadDeCreditos -= unaDefensa.costo();
   
            return true;
        }
        return false;
    }
}
