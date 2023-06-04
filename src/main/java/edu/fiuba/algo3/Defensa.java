package edu.fiuba.algo3;

import edu.fiuba.algo3.exceptions.DefensaEnConstruccionException;
import edu.fiuba.algo3.exceptions.ElEnemigoEstaMuertoException;
import edu.fiuba.algo3.exceptions.ElEnemigoMurioDuranteElAtaqueException;
import edu.fiuba.algo3.exceptions.FueraDeRangoException;

public abstract class Defensa {
    private String nombre;
    private int costo;
    private int tiempoDeConstruccion;
    protected int turnoEnElQueSeInicioLaConstruccion;
    protected int rangoDeAtaque;
    protected int danio;
    protected AccionesDefensa accionesDefensa;
    protected Tierra tierra;
    public int costo(){
        return this.costo;
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
    public AccionesDefensa accionesDefensa() { return this.accionesDefensa; }
    /*public Boolean atacarEnemigo(Enemigo enemigo){
        return enemigo.recibirDanio(this.danio);
    };*/
    public abstract void atacarEnemigo(Enemigo enemigo) throws ElEnemigoMurioDuranteElAtaqueException, ElEnemigoEstaMuertoException,
            DefensaEnConstruccionException, FueraDeRangoException;
    public abstract void construir(Tierra tierra, int numeroDeTurno);
    public void actualizarEstado(int numeroDeTurno) {
        if( numeroDeTurno - this.turnoEnElQueSeInicioLaConstruccion == this.tiempoDeConstruccion ) {
            this.accionesDefensa = new Terminada();
        }
    }
    public void terminarDeConstruir(){
        this.accionesDefensa = new Terminada();
    }
}
