package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.*;
import edu.fiuba.algo3.exceptions.NoDisponibleParaConstruirException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnemigoTest {
    @Test
    public void unaTorreBlancaAtacaAunaHormigaUnaVezYLaMata() throws NoDisponibleParaConstruirException {
        Coordenadas coordenadasTorre = new Coordenadas(2,2);
        Coordenadas coordenadasHormiga = new Coordenadas(3,1);
        Hormiga unaHormiga = new Hormiga(coordenadasHormiga);
        Defensa unaDefensa = new TorreBlanca();

        Tierra tierra = new Tierra(coordenadasTorre);
        tierra.construir(unaDefensa);
        unaDefensa.terminarDeConstruir();

        unaDefensa.atacarEnemigo(unaHormiga);

        assertEquals( unaHormiga.estaVivo(), false );

    }
    @Test
    public void unaTorreBlancaAtacaNoPuedeAtacarAunaHormigaDosVecesPorqueEstaMuerta() throws NoDisponibleParaConstruirException {
        Coordenadas coordenadasTorre = new Coordenadas(2,2);
        Coordenadas coordenadasHormiga = new Coordenadas(3,1);
        Hormiga unaHormiga = new Hormiga(coordenadasHormiga);
        Defensa unaDefensa = new TorreBlanca();

        Tierra tierra = new Tierra(coordenadasTorre);
        tierra.construir(unaDefensa);
        unaDefensa.terminarDeConstruir();

        unaDefensa.atacarEnemigo(unaHormiga);
        boolean pudeAtacar = unaDefensa.atacarEnemigo(unaHormiga);

        assertEquals( pudeAtacar, false );

    }
    @Test
    public void unaTorreBlancaAtacaAunaAraniaYNoLaMata() throws NoDisponibleParaConstruirException {
        Coordenadas coordenadasTorre = new Coordenadas(2,2);
        Coordenadas coordenadasArania = new Coordenadas(3,1);
        Arania unaArania = new Arania(coordenadasArania);
        Defensa unaDefensa = new TorreBlanca();

        Tierra tierra = new Tierra(coordenadasTorre);
        tierra.construir(unaDefensa);
        unaDefensa.terminarDeConstruir();

        unaDefensa.atacarEnemigo(unaArania);

        assertEquals( unaArania.estaVivo(), true );

    }
    @Test
    public void unaTorreBlancaAtacaAunaAraniaDosVecesYLaMata() throws NoDisponibleParaConstruirException {
        Coordenadas coordenadasTorre = new Coordenadas(2,2);
        Coordenadas coordenadasArania = new Coordenadas(3,1);
        Arania unaArania = new Arania(coordenadasArania);
        Defensa unaDefensa = new TorreBlanca();

        Tierra tierra = new Tierra(coordenadasTorre);
        tierra.construir(unaDefensa);
        unaDefensa.terminarDeConstruir();

        unaDefensa.atacarEnemigo(unaArania);
        unaDefensa.atacarEnemigo(unaArania);

        assertEquals( unaArania.estaVivo(), false );

    }
    @Test
    public void unaTorrePlateadaAtacaAunaHormigaUnaVezYLaMata() throws NoDisponibleParaConstruirException {
        Coordenadas coordenadasTorre = new Coordenadas(2,2);
        Coordenadas coordenadasHormiga = new Coordenadas(3,1);
        Hormiga unaHormiga = new Hormiga(coordenadasHormiga);
        Defensa unaDefensa = new TorrePlateada();

        Tierra tierra = new Tierra(coordenadasTorre);
        tierra.construir(unaDefensa);
        unaDefensa.terminarDeConstruir();

        unaDefensa.atacarEnemigo(unaHormiga);

        assertEquals( unaHormiga.estaVivo(), false );

    }
    @Test
    public void unaTorrePlateadaAtacaAunaAraniaUnaVezYLaMata() throws NoDisponibleParaConstruirException {
        Coordenadas coordenadasTorre = new Coordenadas(2,2);
        Coordenadas coordenadasArania = new Coordenadas(3,1);
        Arania unaArania = new Arania(coordenadasArania);
        Defensa unaDefensa = new TorrePlateada();

        Tierra tierra = new Tierra(coordenadasTorre);
        tierra.construir(unaDefensa);
        unaDefensa.terminarDeConstruir();

        unaDefensa.atacarEnemigo(unaArania);

        assertEquals( unaArania.estaVivo(), false );

    }
    @Test
    public void unaTorrePlateadaNoPuedeAtacarDosVecesUnaArania() throws NoDisponibleParaConstruirException {
        Coordenadas coordenadasTorre = new Coordenadas(2,2);
        Coordenadas coordenadasArania = new Coordenadas(3,1);
        Arania unaArania = new Arania(coordenadasArania);
        Defensa unaDefensa = new TorrePlateada();

        Tierra tierra = new Tierra(coordenadasTorre);
        tierra.construir(unaDefensa);
        unaDefensa.terminarDeConstruir();

        unaDefensa.atacarEnemigo(unaArania);
        boolean pudeAtacar = unaDefensa.atacarEnemigo(unaArania);
        assertEquals( pudeAtacar, false );

    }

}