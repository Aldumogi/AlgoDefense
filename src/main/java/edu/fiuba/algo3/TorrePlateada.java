package edu.fiuba.algo3;
import edu.fiuba.algo3.Jugador;

public class TorrePlateada extends Defensa {

    // private Tierra tierra;
    // private Coodenada coordenada;

    public TorrePlateada(Jugador jugador) {
        this.nombre("Torre Plateada");
        this.costo(20);
        this.tiempoDeConstruccion(2);
        this.rangoDeAtaque(5);
        this.danio(2);
        this.duenio(jugador);
    }

    public void construir() {}
}
