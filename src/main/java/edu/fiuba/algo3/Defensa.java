package edu.fiuba.algo3;

public abstract class Defensa {
    private String nombre;
    private int costo;
    private int tiempoDeConstruccion;
    private int rangoDeAtaque;
    private int danio;
    private Jugador duenio;


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
    public void duenio(Jugador jugador){
        this.duenio =  jugador;
    }
    
    protected AccionesDefensa estado;  
    //ataca a un enemigo y devuelve true si lo mata
    public Boolean atacarEnemigo(Enemigo enemigo){
        int creditos = enemigo.recibirDanio(this.danio);
        this.duenio.agregarCreditos(creditos);
        return creditos != 0;

    };
    public abstract void construir();
}
