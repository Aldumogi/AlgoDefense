package edu.fiuba.algo3;

import edu.fiuba.algo3.exceptions.DefensaEnConstruccionException;
import edu.fiuba.algo3.exceptions.ElEnemigoEstaMuertoException;
import edu.fiuba.algo3.exceptions.ElEnemigoMurioDuranteElAtaqueException;
import edu.fiuba.algo3.exceptions.FueraDeRangoException;

import java.util.ArrayList;
import java.util.List;

public abstract class Defensa {
    protected String nombre;
    protected int costo;
    protected int tiempoDeConstruccion;
    protected int rangoDeAtaque;
    protected int danio;
    protected EstadoDefensa estado;
    protected Parcela parcela;
    protected int tiempoDeRalentizacion;
    protected double factorDeRalentizacion;
    public abstract void atacarEnemigo(Enemigo enemigo) throws ElEnemigoMurioDuranteElAtaqueException, ElEnemigoEstaMuertoException,
            DefensaEnConstruccionException, FueraDeRangoException;

    public abstract void construir(Parcela parcela);

    public int costo() {
        return this.costo;
    }

    public EstadoDefensa estadoDefensa() {
        return this.estado;
    }

    public void pasarTurno(List<Enemigo> enemigos, ArrayList<Hormiga> hormigasAsesinadas) {
        this.estado = this.estado.pasarTurno(enemigos, this.rangoDeAtaque, this.danio,
                this.parcela.obtenerCoordenadas(), hormigasAsesinadas, this.factorDeRalentizacion);
    }
}
