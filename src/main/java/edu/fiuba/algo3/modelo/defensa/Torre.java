package edu.fiuba.algo3.modelo.defensa;

import edu.fiuba.algo3.modelo.enemigo.Enemigo;
import edu.fiuba.algo3.modelo.enemigo.Hormiga;
import edu.fiuba.algo3.modelo.exceptions.*;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.parcela.Parcela;

import java.util.ArrayList;
import java.util.List;

public class Torre extends Defensa {
    public void atacarEnemigo(Enemigo enemigo) throws ElEnemigoMurioDuranteElAtaqueException, ElEnemigoEstaMuertoException,
            DefensaEnConstruccionException, FueraDeRangoException {}


    public void construir(Mapa mapa, Coordenadas coordenadas) throws NoSePudoConstruirException {}

    public void pasarTurno(List<Enemigo> enemigos, ArrayList<Hormiga> hormigasAsesinadas) {
        this.estado = this.estado.pasarTurno(enemigos, this.rangoDeAtaque, this.danio,
                this.obtenerCoordenadas(), hormigasAsesinadas, this.factorDeRalentizacion);
    }
}
