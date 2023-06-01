package edu.fiuba.algo3;

public abstract class Defensa {
    private String nombre;
    private int costo;
    private int tiempoDeConstruccion;
    private Jugador duenio;
    protected int rangoDeAtaque;
    protected int danio;
    protected Tierra tierra;
    protected AccionesDefensa estado;  

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
    
    //ataca a un enemigo y devuelve true si lo mata
    public Boolean atacarEnemigo(Enemigo enemigo){
        int creditos = enemigo.recibirDanio(this.danio);
        if(creditos == 1){ //mate a una hormiga
            duenio.mateUnaHormiga();
        }
        if(duenio.hormigasMuertas() > 9){
            creditos += 1;
        }
        this.duenio.agregarCreditos(creditos);
        return creditos != 0;
    }

    protected AccionesDefensa accionesDefensa;

    public abstract void construir(Tierra tierra);

    public void terminarDeConstruir(){
        this.accionesDefensa = new Terminada();
    }
}
