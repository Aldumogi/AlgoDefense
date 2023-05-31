package edu.fiuba.algo3;

public class TorrePlateada extends Defensa {

    public TorrePlateada() {
        this.nombre("Torre Plateada");
        this.costo(20);
        this.tiempoDeConstruccion(2);
        this.rangoDeAtaque(5);
        this.danio(2);
    }

    public void construir(Tierra tierra) {
        this.tierra = tierra;
    }
    public Boolean atacarEnemigo(Enemigo enemigo){
        return this.accionesDefensa.atacarEnemigo(enemigo, this.rangoDeAtaque, this.danio , this.tierra.obtenerCoordenadas());
    }
}
