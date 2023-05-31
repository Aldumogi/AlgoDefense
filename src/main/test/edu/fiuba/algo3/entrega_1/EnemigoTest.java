package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.Arania;
import edu.fiuba.algo3.Defensa;
import edu.fiuba.algo3.Hormiga;
import edu.fiuba.algo3.TorreBlanca;
import edu.fiuba.algo3.TorrePlateada;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnemigoTest {
    @Test
    public void unaTorreBlancaAtacaAunaHormigaUnaVezYLaMata() {

        Hormiga unaHormiga = new Hormiga();
        Defensa unaDefensa = new TorreBlanca();
        unaDefensa.atacarEnemigo(unaHormiga);

        assertEquals( unaHormiga.estaVivo(), false );

    }
    @Test
    public void unaTorreBlancaAtacaNoPuedeAtacarAunaHormigaDosVecesPorqueEstaMuerta() {

        Hormiga unaHormiga = new Hormiga();
        Defensa unaDefensa = new TorreBlanca();
        unaDefensa.atacarEnemigo(unaHormiga);
        boolean pudeAtacar = unaDefensa.atacarEnemigo(unaHormiga);

        assertEquals( pudeAtacar, false );

    }
    @Test
    public void unaTorreBlancaAtacaAunaAraniaYNoLaMata() {

        Arania unaHormiga = new Arania();
        Defensa unaDefensa = new TorreBlanca();
        unaDefensa.atacarEnemigo(unaHormiga);

        assertEquals( unaHormiga.estaVivo(), true );

    }
    @Test
    public void unaTorreBlancaAtacaAunaAraniaDosVecesYLaMata() {

        Arania unaArania = new Arania();
        Defensa unaDefensa = new TorreBlanca();
        unaDefensa.atacarEnemigo(unaArania);
        unaDefensa.atacarEnemigo(unaArania);

        assertEquals( unaArania.estaVivo(), false );

    }
    @Test
    public void unaTorrePlateadaAtacaAunaHormigaUnaVezYLaMata() {

        Hormiga unaHormiga = new Hormiga();
        Defensa unaDefensa = new TorrePlateada();
        unaDefensa.atacarEnemigo(unaHormiga);

        assertEquals( unaHormiga.estaVivo(), false );

    }
    @Test
    public void unaTorrePlateadaAtacaAunaAraniaUnaVezYLaMata() {

        Arania unaArania = new Arania();
        Defensa unaDefensa = new TorrePlateada();
        unaDefensa.atacarEnemigo(unaArania);

        assertEquals( unaArania.estaVivo(), false );

    }
    @Test
    public void unaTorrePlateadaNoPuedeAtacarDosVecesUnaArania() {

        Arania unaArania = new Arania();
        Defensa unaDefensa = new TorrePlateada();
        unaDefensa.atacarEnemigo(unaArania);
        boolean pudeAtacar = unaDefensa.atacarEnemigo(unaArania);
        assertEquals( pudeAtacar, false );

    }

}