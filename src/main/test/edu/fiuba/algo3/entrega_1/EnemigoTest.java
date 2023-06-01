package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.*;
import edu.fiuba.algo3.exceptions.NoDisponibleParaConstruirException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EnemigoTest {
    @Test
    public void unaTorreBlancaAtacaAunaHormigaUnaVezYLaMata() throws NoDisponibleParaConstruirException {
        Coordenadas coordenadasTorre = new Coordenadas(2,2);
        Coordenadas coordenadasHormiga = new Coordenadas(3,1);
        Hormiga unaHormiga = new Hormiga(coordenadasHormiga);
        Defensa unaDefensa = new TorreBlanca();

        Tierra tierra = new Tierra(coordenadasTorre);
        tierra.construir(unaDefensa, 0);
        unaDefensa.terminarDeConstruir();

        unaDefensa.atacarEnemigo(unaHormiga);

        assertFalse(unaHormiga.estaVivo());

    }
    @Test
    public void unaTorreBlancaAtacaNoPuedeAtacarAunaHormigaDosVecesPorqueEstaMuerta() throws NoDisponibleParaConstruirException {
        Coordenadas coordenadasTorre = new Coordenadas(2,2);
        Coordenadas coordenadasHormiga = new Coordenadas(3,1);
        Hormiga unaHormiga = new Hormiga(coordenadasHormiga);
        Defensa unaDefensa = new TorreBlanca();

        Tierra tierra = new Tierra(coordenadasTorre);
        tierra.construir(unaDefensa, 0);
        unaDefensa.terminarDeConstruir();

        unaDefensa.atacarEnemigo(unaHormiga);
        boolean pudeAtacar = unaDefensa.atacarEnemigo(unaHormiga);

        assertFalse(pudeAtacar);

    }
    @Test
    public void unaTorreBlancaAtacaAunaAraniaYNoLaMata() throws NoDisponibleParaConstruirException {
        Coordenadas coordenadasTorre = new Coordenadas(2,2);
        Coordenadas coordenadasArania = new Coordenadas(3,1);
        Arania unaArania = new Arania(coordenadasArania);
        Defensa unaDefensa = new TorreBlanca();

        Tierra tierra = new Tierra(coordenadasTorre);
        tierra.construir(unaDefensa, 0);
        unaDefensa.terminarDeConstruir();

        unaDefensa.atacarEnemigo(unaArania);

        assertTrue(unaArania.estaVivo());

    }
    @Test
    public void unaTorreBlancaAtacaAunaAraniaDosVecesYLaMata() throws NoDisponibleParaConstruirException {
        Coordenadas coordenadasTorre = new Coordenadas(2,2);
        Coordenadas coordenadasArania = new Coordenadas(3,1);
        Arania unaArania = new Arania(coordenadasArania);
        Defensa unaDefensa = new TorreBlanca();

        Tierra tierra = new Tierra(coordenadasTorre);
        tierra.construir(unaDefensa, 0);
        unaDefensa.terminarDeConstruir();

        unaDefensa.atacarEnemigo(unaArania);
        unaDefensa.atacarEnemigo(unaArania);

        assertFalse(unaArania.estaVivo());

    }
    @Test
    public void unaTorrePlateadaAtacaAunaHormigaUnaVezYLaMata() throws NoDisponibleParaConstruirException {
        Coordenadas coordenadasTorre = new Coordenadas(2,2);
        Coordenadas coordenadasHormiga = new Coordenadas(3,1);
        Hormiga unaHormiga = new Hormiga(coordenadasHormiga);
        Defensa unaDefensa = new TorrePlateada();

        Tierra tierra = new Tierra(coordenadasTorre);
        tierra.construir(unaDefensa, 0);
        unaDefensa.terminarDeConstruir();

        unaDefensa.atacarEnemigo(unaHormiga);

        assertFalse(unaHormiga.estaVivo());

    }
    @Test
    public void unaTorrePlateadaAtacaAunaAraniaUnaVezYLaMata() throws NoDisponibleParaConstruirException {
        Coordenadas coordenadasTorre = new Coordenadas(2,2);
        Coordenadas coordenadasArania = new Coordenadas(3,1);
        Arania unaArania = new Arania(coordenadasArania);
        Defensa unaDefensa = new TorrePlateada();

        Tierra tierra = new Tierra(coordenadasTorre);
        tierra.construir(unaDefensa, 0);
        unaDefensa.terminarDeConstruir();

        unaDefensa.atacarEnemigo(unaArania);

        assertFalse(unaArania.estaVivo());

    }
    @Test
    public void unaTorrePlateadaNoPuedeAtacarDosVecesUnaArania() throws NoDisponibleParaConstruirException {
        Coordenadas coordenadasTorre = new Coordenadas(2,2);
        Coordenadas coordenadasArania = new Coordenadas(3,1);
        Arania unaArania = new Arania(coordenadasArania);
        Defensa unaDefensa = new TorrePlateada();

        Tierra tierra = new Tierra(coordenadasTorre);
        tierra.construir(unaDefensa, 0);
        unaDefensa.terminarDeConstruir();

        unaDefensa.atacarEnemigo(unaArania);
        boolean pudeAtacar = unaDefensa.atacarEnemigo(unaArania);
        assertFalse(pudeAtacar);

    }

}