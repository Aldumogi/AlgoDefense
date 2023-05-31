package edu.fiuba.algo3;

public abstract class Enemigo {
    private int velocidad;
    private int dañoCausado;
    private int energia;
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

    public int recibirDanio(int unDanio){
        if(!estaVivo()){
            return 0;
        }
        this.energia = this.energia - unDanio;
        if(!estaVivo()){
            return cantidadCreditosOtorgados();
        }
        return 0;

    }
    //protected EstadoEnemigo estado;

    public abstract int cantidadCreditosOtorgados();


    public Coordenadas obtenerCoordenadas() {
        return this.coordenadas;
    }
}
