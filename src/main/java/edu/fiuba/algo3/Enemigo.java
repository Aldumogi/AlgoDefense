package edu.fiuba.algo3;

import com.google.gson.JsonObject;

import edu.fiuba.algo3.exceptions.ElEnemigoEstaVivoException;
import org.json.simple.JSONObject;

public abstract class Enemigo {
    protected int velocidad;
    protected int dañoCausado;
    protected int energia;
    protected int creditosOtorgados;
    protected Coordenadas coordenadas;
    protected AccionesEnemigo acciones;

    public abstract int cantidadCreditosOtorgados(int cantidadDeMuertosDeUnTipoDeEnemigo);
    public abstract boolean recibirDanio(int unDanio);

    public abstract boolean esUnaHormiga();

    public int creditosOtorgados() {
        return this.creditosOtorgados;
    }

    public boolean estaVivo() {
        return (this.energia > 0) ? true : false;
    }

    public int energia() {
        return this.energia;
    }

    public boolean actualizarEstado() {
        try {
            this.acciones.verSiEstaMuerto();
        }
        catch(ElEnemigoEstaVivoException e) {
            if (this.energia <= 0) {
                this.acciones = new Muerto();
                return true;
            }
        }
        return false;
    }

    public Coordenadas obtenerCoordenadas() {
        return this.coordenadas;
    }

    public int obtenerDanioCausado () {
        return this.dañoCausado;
    }

}
