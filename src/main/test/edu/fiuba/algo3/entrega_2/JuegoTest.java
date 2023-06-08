package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.*;
import edu.fiuba.algo3.exceptions.FormatoEnemigosInvalidoException;
import edu.fiuba.algo3.exceptions.FormatoMapaInvalidoException;
import edu.fiuba.algo3.exceptions.NoSePudoBorrarElEnemigoException;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JuegoTest {
    @Test
    public void elJuegoSeCreaAcordeAAmbosJSON() throws FormatoEnemigosInvalidoException, IOException, ParseException, FormatoMapaInvalidoException, NoSePudoBorrarElEnemigoException {

        List<Enemigo> enemigosEnLaPasarela;
        Inicializador inicio = new Inicializador();
        inicio.agregarJugador("NombreDelJugador");
        Juego juego = inicio.obtenerJuego();
        Mapa mapaCargadoEnElJuego = juego.obtenerMapa();

        Coordenadas coordenadasLargada = new Coordenadas(1, 2);
        Parcela parcela = mapaCargadoEnElJuego.obtenerCelda(coordenadasLargada);

        // Assert
        assertThat(parcela, instanceOf(PasarelaLargada.class) );
        enemigosEnLaPasarela = parcela.obtener();

        // turno 1
        assertEquals(1, enemigosEnLaPasarela.size() );
        assertThat(enemigosEnLaPasarela.get(0), instanceOf(Hormiga.class));
        juego.avanzarTurno();
        mapaCargadoEnElJuego.borrar( enemigosEnLaPasarela.get(0) );

        // turno 2
        assertEquals(2, enemigosEnLaPasarela.size() );
        assertThat(enemigosEnLaPasarela.get(0), instanceOf(Hormiga.class));
        assertThat(enemigosEnLaPasarela.get(1), instanceOf(Arania.class));
        juego.avanzarTurno();
        mapaCargadoEnElJuego.borrar( enemigosEnLaPasarela.get(0) );
        mapaCargadoEnElJuego.borrar( enemigosEnLaPasarela.get(0) );

        // turno 3
        assertEquals(3, enemigosEnLaPasarela.size() );
        assertThat(enemigosEnLaPasarela.get(0), instanceOf(Hormiga.class));
        assertThat(enemigosEnLaPasarela.get(1), instanceOf(Hormiga.class));
        assertThat(enemigosEnLaPasarela.get(2), instanceOf(Arania.class));
        juego.avanzarTurno();
        mapaCargadoEnElJuego.borrar( enemigosEnLaPasarela.get(0) );
        mapaCargadoEnElJuego.borrar( enemigosEnLaPasarela.get(0) );
        mapaCargadoEnElJuego.borrar( enemigosEnLaPasarela.get(0) );

        // turno 4
        assertEquals(1, enemigosEnLaPasarela.size() );
        assertThat(enemigosEnLaPasarela.get(0), instanceOf(Arania.class));
        juego.avanzarTurno();
        mapaCargadoEnElJuego.borrar( enemigosEnLaPasarela.get(0) );

        // turno 5
        assertEquals(2, enemigosEnLaPasarela.size() );
        assertThat(enemigosEnLaPasarela.get(0), instanceOf(Hormiga.class));
        assertThat(enemigosEnLaPasarela.get(1), instanceOf(Arania.class));
        juego.avanzarTurno();
        mapaCargadoEnElJuego.borrar( enemigosEnLaPasarela.get(0) );
        mapaCargadoEnElJuego.borrar( enemigosEnLaPasarela.get(0) );

        // turno 6
        assertEquals(3, enemigosEnLaPasarela.size() );
        assertThat(enemigosEnLaPasarela.get(0), instanceOf(Hormiga.class));
        assertThat(enemigosEnLaPasarela.get(1), instanceOf(Arania.class));
        assertThat(enemigosEnLaPasarela.get(2), instanceOf(Arania.class));
        juego.avanzarTurno();
        mapaCargadoEnElJuego.borrar( enemigosEnLaPasarela.get(0) );
        mapaCargadoEnElJuego.borrar( enemigosEnLaPasarela.get(0) );
        mapaCargadoEnElJuego.borrar( enemigosEnLaPasarela.get(0) );

        // turno 7
        assertEquals(1, enemigosEnLaPasarela.size() );
        assertThat(enemigosEnLaPasarela.get(0), instanceOf(Arania.class));
        juego.avanzarTurno();
        mapaCargadoEnElJuego.borrar( enemigosEnLaPasarela.get(0) );

        // turno 8
        assertEquals(1, enemigosEnLaPasarela.size() );
        assertThat(enemigosEnLaPasarela.get(0), instanceOf(Hormiga.class));
        juego.avanzarTurno();
        mapaCargadoEnElJuego.borrar( enemigosEnLaPasarela.get(0) );

        // turno 9
        assertEquals(1, enemigosEnLaPasarela.size() );
        assertThat(enemigosEnLaPasarela.get(0), instanceOf(Hormiga.class));
        juego.avanzarTurno();
        mapaCargadoEnElJuego.borrar( enemigosEnLaPasarela.get(0) );

        // turno 10
        assertEquals(2, enemigosEnLaPasarela.size() );
        assertThat(enemigosEnLaPasarela.get(0), instanceOf(Hormiga.class));
        assertThat(enemigosEnLaPasarela.get(1), instanceOf(Hormiga.class));
        juego.avanzarTurno();
        mapaCargadoEnElJuego.borrar( enemigosEnLaPasarela.get(0) );
        mapaCargadoEnElJuego.borrar( enemigosEnLaPasarela.get(0) );

        // turno 11
        assertEquals(1, enemigosEnLaPasarela.size() );
        assertThat(enemigosEnLaPasarela.get(0), instanceOf(Arania.class));
        juego.avanzarTurno();
        mapaCargadoEnElJuego.borrar( enemigosEnLaPasarela.get(0) );

        // turno 12
        assertEquals(3, enemigosEnLaPasarela.size() );
        assertThat(enemigosEnLaPasarela.get(0), instanceOf(Hormiga.class));
        assertThat(enemigosEnLaPasarela.get(1), instanceOf(Arania.class));
        assertThat(enemigosEnLaPasarela.get(1), instanceOf(Arania.class));

    }
}
