package edu.fiuba.algo3;

public class Hormiga extends Enemigo {
    private int cantidadDeHormigasMuertas;

    public Hormiga() {
        this.velocidad(1);
        this.dañoCausado(1);
        this.energia(1);
        this.creditosOtorgados(1);
        this.coordenadas = this.getCoordenadasLargada();
        this.cantidadDeHormigasMuertas = 0;
    }
    public Hormiga(Coordenadas coordenadas) {
        this.velocidad(1);
        this.dañoCausado(1);
        this.energia(1);
        this.creditosOtorgados(1);
        this.coordenadas = coordenadas;
    }

    public int cantidadCreditosOtorgados() {
        return ( this.cantidadDeHormigasMuertas < 11 ) ? 1:2;
    }

    private Coordenadas getCoordenadasLargada() {
        // Al mapa le pedira las coordenadas de la parcela de largada
        return new Coordenadas(3,1);
    }
    public boolean recibirDanio(int unDanio){
        if (estaVivo()){
            this.energia = this.energia - unDanio;
            if( this.energia <= 0 ) {
                this.cantidadDeHormigasMuertas++;
            }
            return true;
        }
        return false;
    }
}



