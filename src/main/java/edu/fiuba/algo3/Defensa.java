package edu.fiuba.algo3;

public abstract class Defensa {
    private String nombre;
    private int costo;
    private int tiempoDeConstruccion;
    private int turnoEnElQueSeInicioLaConstruccion;
    protected int rangoDeAtaque;
    protected int danio;

    protected Tierra tierra;
    public int costo(){
        return this.costo;
    }
    
    public void nombre(String unNombre){
        this.nombre = unNombre;
    }
    public void costo(int unCosto){
        this.costo = unCosto;
    }
    public void tiempoDeConstruccion(int unTiempo){
        this.tiempoDeConstruccion = unTiempo;
    }
    public void rangoDeAtaque(int unRango){
        this.rangoDeAtaque = unRango;
    }
    public void danio(int unDanio){
        this.danio =  unDanio;
    }
    protected AccionesDefensa accionesDefensa;
    public Boolean atacarEnemigo(Enemigo enemigo){
        return enemigo.recibirDanio(this.danio);
    };
    public abstract void construir(Tierra tierra);

    public void terminarDeConstruir(){
        this.accionesDefensa = new Terminada();
    }
}
