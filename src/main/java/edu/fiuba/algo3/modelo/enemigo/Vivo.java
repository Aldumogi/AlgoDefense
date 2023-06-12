package edu.fiuba.algo3.modelo.enemigo;

import edu.fiuba.algo3.modelo.exceptions.ElEnemigoEstaMuertoException;
import edu.fiuba.algo3.modelo.exceptions.ElEnemigoMurioDuranteElAtaqueException;

import java.util.ArrayList;
import java.util.List;

public class Vivo implements EstadoEnemigo {
    private int energia;

    public Vivo(int energia) {
        this.energia = energia;
    }

    public EstadoEnemigo recibirDanio(int danio) throws ElEnemigoMurioDuranteElAtaqueException, ElEnemigoEstaMuertoException {
        this.energia = this.energia - danio;
        if ( this.energia < danio ) return new Muerto();
        return this;
    }

    public int creditosOtorgados(int creditos) {
        return 0;
    }
    public int obtenerEnergia() { return this.energia; }
    public void mover(Enemigo enemigo) {}
    public void acumularHormigasMuertas(ArrayList<Hormiga> hormigasMuertas, Hormiga enemigo) {}
    public void agregarIndiceDeEnemigoMuerto(List<Integer> enemigosMuertos, int enemigo) {}

    @Override
    public boolean equals(Object o) {
        if ( o == this ) {
            return true;
        }
        if ( !(o instanceof Vivo) ) {
            return false;
        }
        Vivo e = (Vivo) o;
        return e.energia == this.energia;
    }
}
