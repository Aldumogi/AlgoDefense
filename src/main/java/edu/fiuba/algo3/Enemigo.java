package edu.fiuba.algo3;

import edu.fiuba.algo3.exceptions.ElEnemigoEstaMuertoException;
import edu.fiuba.algo3.exceptions.ElEnemigoMurioDuranteElAtaqueException;

import java.util.ArrayList;
import java.util.List;

public abstract class Enemigo {
    protected int velocidad;
    protected int dañoCausado;
    protected int energiaInicial;
    protected int creditosOtorgados;
    protected Coordenadas coordenadas;
    protected EstadoEnemigo estado;

    public abstract int cantidadCreditosOtorgados(int cantidadDeMuertosDeUnTipoDeEnemigo);
    public Coordenadas obtenerCoordenadas() {
        return this.coordenadas;
    }

    public int obtenerDanioCausado () {
        return this.dañoCausado;
    }

    public void recibirDanio(int unDanio) throws ElEnemigoEstaMuertoException, ElEnemigoMurioDuranteElAtaqueException {
        this.estado = this.estado.recibirDanio(unDanio);
    }
    public abstract void acumularMuertos(ArrayList<Hormiga> hormigasMuertas);
    public void agregarIndiceDelEnemigoMuerto(List<Integer> indicesEnemigosMuertos, int posicionActual) {
        this.estado.agregarIndiceDeEnemigoMuerto(indicesEnemigosMuertos, posicionActual);
    }
}
