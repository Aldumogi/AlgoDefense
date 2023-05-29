package edu.fiuba.algo3;

public abstract class Enemigo {
    private int velocidad;
    private int dañoCausado;
    private int energia;
    private int creditosOtorgados;

    //getters
    public int velocidad(){
        return this.velocidad;
    }
    public int dañoCausado(){
        return this.dañoCausado;
    }
    public int energia(){
        return this.energia;
    }
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

    protected EstadoEnemigo estado;
    public abstract int cantidadCreditosOtorgados();

    public abstract boolean estaVivo();

}
