package edu.fiuba.algo3;

import edu.fiuba.algo3.exceptions.ElEnemigoEstaMuertoException;
import edu.fiuba.algo3.exceptions.ElEnemigoEstaVivoException;
import edu.fiuba.algo3.exceptions.ElEnemigoMurioDuranteElAtaqueException;

import java.util.List;

public class Vivo implements EstadoEnemigo {
    private int energia;
    public Vivo(int energia) {
        this.energia = energia;
    }
    public void mover(Enemigo enemigo) {

    }
    public EstadoEnemigo recibirDanio(int danio) throws ElEnemigoMurioDuranteElAtaqueException, ElEnemigoEstaMuertoException {
        this.energia = this.energia - danio;
        if ( this.energia < danio ) return new Muerto();
        return this;
    }
    public int creditosOtorgados(int creditos) {
        return 0;
    }
    public void verSiEstaMuerto() throws ElEnemigoEstaVivoException {
        throw new ElEnemigoEstaVivoException();
    }

    public int contarMuerto() {
        return 0;
    }
    public void agregarIndiceDeEnemigoMuerto(List<Integer> enemigosMuertos, int enemigo) {}
}
