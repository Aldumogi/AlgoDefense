package edu.fiuba.algo3.modelo.enemigo;

import edu.fiuba.algo3.modelo.exceptions.ElEnemigoEstaMuertoException;
import edu.fiuba.algo3.modelo.exceptions.ElEnemigoMurioDuranteElAtaqueException;
import edu.fiuba.algo3.modelo.exceptions.NoSePudoBorrarElEnemigoException;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.parcela.Parcela;

import java.util.ArrayList;
import java.util.List;

public abstract class Enemigo {
    protected int velocidad;
    protected int dañoCausado;
    protected int creditosOtorgados;
    protected Coordenadas coordenadas;
    protected EstadoEnemigo estado;
    protected int cantidadDeMovimientosRealizados;
    protected double coeficienteDeRalentizacion;
    public abstract int cantidadCreditosOtorgados(int cantidadDeMuertosDeUnTipoDeEnemigo);
    public abstract void acumularMuertos(ArrayList<Hormiga> hormigasMuertas);

    public Coordenadas obtenerCoordenadas() {
        return this.coordenadas;
    }

    public int obtenerDanioCausado (int numeroDeTurno) {
        return this.dañoCausado;
    }
    
    public boolean atacaTorres(){
        return false;
    }

    public void recibirDanio(int unDanio) throws ElEnemigoEstaMuertoException, ElEnemigoMurioDuranteElAtaqueException {
        this.estado = this.estado.recibirDanio(unDanio);
    }

    public int obtenerCreditos() { return this.creditosOtorgados; }

    public void agregarIndiceDelEnemigoMuerto(List<Integer> indicesEnemigosMuertos, int posicionActual) {
        this.estado.agregarIndiceDeEnemigoMuerto(indicesEnemigosMuertos, posicionActual);
    }

    public void mover(Mapa mapa) throws NoSePudoBorrarElEnemigoException{
        // Pedir a mapa pasarela actual y eliminar enemigo
        Parcela pasarela = mapa.obtenerCelda(this.coordenadas);
        pasarela.borrarObjeto(this);

        // Mover a la siguiente pasarela
        double velocidad = this.velocidad * this.coeficienteDeRalentizacion;
        Coordenadas coordenadaSiguiente = mapa.devolverSiguientePasarela(this.coordenadas, velocidad);
        Parcela pasarelaSiguiente  = mapa.obtenerCelda(coordenadaSiguiente);
        pasarelaSiguiente.recibir(this);
        this.cantidadDeMovimientosRealizados++;

        this.coordenadas = coordenadaSiguiente;
        this._actualizarVelocidadSegunCantidadDeMovimientos();
    }
    protected abstract void _actualizarVelocidadSegunCantidadDeMovimientos();
    public void recibirRalentizacion(double coeficienteDeRalentizacion) {
        this.coeficienteDeRalentizacion = coeficienteDeRalentizacion;
    }

    public void setCoordenadas(Coordenadas coordenadas) {
        this.coordenadas = coordenadas;
    }

    public double obtenerVelocidad() { return this.velocidad; }

    public Object obtenerEnergia() { return this.estado.obtenerEnergia(); }
}
