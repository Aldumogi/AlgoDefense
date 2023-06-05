package edu.fiuba.algo3;

public abstract class Defensa {
    protected String nombre;
    protected int costo;
    protected int tiempoDeConstruccion;
    protected int turnoEnElQueSeInicioLaConstruccion;
    protected int rangoDeAtaque;
    protected int danio;
    protected AccionesDefensa accionesDefensa;
    protected Tierra tierra;

    public abstract void construir(Tierra tierra, int numeroDeTurno);

    public int costo() {
        return this.costo;
    }

    public AccionesDefensa accionesDefensa() {
        return this.accionesDefensa;
    }

    public Boolean atacarEnemigo(Enemigo enemigo) {
        return enemigo.recibirDanio(this.danio);
    }

    public void actualizarEstado(int numeroDeTurno) {
        if( numeroDeTurno - this.turnoEnElQueSeInicioLaConstruccion == this.tiempoDeConstruccion ) {
            this.accionesDefensa = new Terminada();
        }
    }
    public void terminarDeConstruir() {
        this.accionesDefensa = new Terminada();
    }
}
