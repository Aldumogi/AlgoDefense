package edu.fiuba.algo3;

import edu.fiuba.algo3.exceptions.ElEnemigoEstaVivoException;

public class Hormiga extends Enemigo {

    public Hormiga() {
        this.velocidad(1);
        this.dañoCausado(1);
        this.energia(1);
        this.creditosOtorgados(1);
        this.coordenadas = this.getCoordenadasLargada();
        this.acciones = new Vivo();
    }
    public Hormiga(Coordenadas coordenadas) {
        this.velocidad(1);
        this.dañoCausado(1);
        this.energia(1);
        this.creditosOtorgados(1);
        this.coordenadas = coordenadas;
        this.acciones = new Vivo();
    }

    public void cantidadCreditosOtorgados(int cantidadDeHormigasMuertas) {
        this.creditosOtorgados ( ( cantidadDeHormigasMuertas < 11 ) ? 1:2 );
    }

    private Coordenadas getCoordenadasLargada() {
        // Al mapa le pedira las coordenadas de la parcela de largada
        return new Coordenadas(3,1);
    }
    public boolean recibirDanio(int unDanio){
        if (estaVivo()){
            this.energia = this.energia - unDanio;
            return true;
        }
        return false;
    }
    public boolean esUnaHormiga() {
        return true;
    }

}



