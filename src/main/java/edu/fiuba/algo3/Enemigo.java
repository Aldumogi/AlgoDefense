package edu.fiuba.algo3;

import edu.fiuba.algo3.exceptions.ElEnemigoEstaMuertoException;
import edu.fiuba.algo3.exceptions.ElEnemigoMurioDuranteElAtaqueException;
import edu.fiuba.algo3.exceptions.NoSePudoBorrarElEnemigoException;

import java.util.ArrayList;
import java.util.List;

public abstract class Enemigo {
    protected int velocidad;
    protected int dañoCausado;
    protected int creditosOtorgados;
    protected Coordenadas coordenadas;
    protected EstadoEnemigo estado;
    protected int cantidadDeMovimientosRealizados;
    public abstract int cantidadCreditosOtorgados(int cantidadDeMuertosDeUnTipoDeEnemigo);
    public abstract void acumularMuertos(ArrayList<Hormiga> hormigasMuertas);

    public Coordenadas obtenerCoordenadas() {
        return this.coordenadas;
    }

    public int obtenerDanioCausado (int numeroDeTurno) {
        return this.dañoCausado;
    }

    public void recibirDanio(int unDanio) throws ElEnemigoEstaMuertoException, ElEnemigoMurioDuranteElAtaqueException {
        this.estado = this.estado.recibirDanio(unDanio);
    }

    public void agregarIndiceDelEnemigoMuerto(List<Integer> indicesEnemigosMuertos, int posicionActual) {
        this.estado.agregarIndiceDeEnemigoMuerto(indicesEnemigosMuertos, posicionActual);
    }

    public void setCoordenadas(Coordenadas coordenadas){
        this.coordenadas = coordenadas;
    }

    public void mover(Mapa mapa) throws NoSePudoBorrarElEnemigoException{
        // Pedir a mapa pasarela actual y eliminar enemigo
        Parcela pasarela = mapa.obtenerCelda(this.coordenadas);
        pasarela.borrarObjeto(this);

        // Mover a la siguiente pasarela
        Coordenadas coordenadaSiguiente = mapa.devolverSiguientePasarela(this.coordenadas, this.velocidad);
        Parcela pasarelaSiguiente  = mapa.obtenerCelda(coordenadaSiguiente);
        pasarelaSiguiente.recibir(this);

        this.coordenadas = coordenadaSiguiente;
        this._actualizarVelocidadSegunCantidadDeMovimientos();
    }
    protected abstract void _actualizarVelocidadSegunCantidadDeMovimientos();
}
