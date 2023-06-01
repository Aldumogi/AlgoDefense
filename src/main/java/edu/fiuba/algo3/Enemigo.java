package edu.fiuba.algo3;

import edu.fiuba.algo3.exceptions.ElEnemigoEstaVivoException;

public abstract class Enemigo {
    private int velocidad;
    private int dañoCausado;
    protected int energia;
    private int creditosOtorgados;
    protected Coordenadas coordenadas;
    protected AccionesEnemigo acciones;
    //getters

    public int creditosOtorgados(){
        return this.creditosOtorgados;
    }
    //setters
    public void velocidad(int unaVelocidad){
        this.velocidad = unaVelocidad;
    }
    public void dañoCausado(int unDaño){
        this.dañoCausado = unDaño;
    }
    public void energia(int unaEnergia){
        this.energia = unaEnergia;
    }
    public void creditosOtorgados(int cred){
        this.creditosOtorgados = cred;
    }
    public boolean estaVivo() {
        return (this.energia > 0) ? true : false;
    }
    public abstract boolean esUnaHormiga();

    public int energia() {return this.energia;}
    public abstract int cantidadCreditosOtorgados(int cantidadDeMuertosDeUnTipoDeEnemigo);
    public abstract boolean recibirDanio(int unDanio);
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
