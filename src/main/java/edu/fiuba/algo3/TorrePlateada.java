package edu.fiuba.algo3;

public class TorrePlateada extends Defensa {

    public TorrePlateada() {
        this.nombre("Torre Plateada");
        this.costo(20);
        this.tiempoDeConstruccion(2);
        this.rangoDeAtaque(5);
        this.danio(2);
    }

    public void construir(Tierra tierra, int numeroDeTurno) {
        this.tierra = tierra;
        this.accionesDefensa = new EnConstruccion();
        this.turnoEnElQueSeInicioLaConstruccion = numeroDeTurno;
    }
    public Boolean atacarEnemigo(Enemigo enemigo){
        return this.accionesDefensa.atacarEnemigo(enemigo, this.rangoDeAtaque, this.danio , this.tierra.obtenerCoordenadas());
    }
}
