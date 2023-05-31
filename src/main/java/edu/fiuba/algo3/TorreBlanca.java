package edu.fiuba.algo3;

public class TorreBlanca extends Defensa {
    public TorreBlanca() {
        this.nombre("Torre Blanca");
        this.costo(10);
        this.tiempoDeConstruccion(1);
        this.rangoDeAtaque(3);
        this.danio(1);
        this.accionesDefensa = new EnConstruccion();
    }

    public void construir(Tierra tierra) {
        this.tierra = tierra;
    }

    public Boolean atacarEnemigo(Enemigo enemigo){
        return this.accionesDefensa.atacarEnemigo(enemigo, this.rangoDeAtaque, this.danio , this.tierra.obtenerCoordenadas());
    }

}
