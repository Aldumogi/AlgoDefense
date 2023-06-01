package edu.fiuba.algo3;

public abstract class Enemigo {
    private int velocidad;
    private int dañoCausado;
    protected int energia;
    private int creditosOtorgados;
    protected Coordenadas coordenadas;
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

    //protected EstadoEnemigo estado;

    public abstract int cantidadCreditosOtorgados();
    public abstract boolean recibirDanio(int unDanio);

    public Coordenadas obtenerCoordenadas() {
        return this.coordenadas;
    }
}
