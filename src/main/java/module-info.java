module edu.fiuba.algo3 {
    requires javafx.controls;
    requires com.google.gson;
    requires org.testng;
    requires json.simple;
    requires org.apache.logging.log4j;
    requires com.networknt.schema;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.dataformat.yaml;
    requires org.apache.logging.log4j.core;
    exports edu.fiuba.algo3;
    exports edu.fiuba.algo3.modelo.defensa;
    exports edu.fiuba.algo3.modelo.enemigo;
    exports edu.fiuba.algo3.modelo.parcela;
    exports edu.fiuba.algo3.modelo.mapa;
    exports edu.fiuba.algo3.modelo.juego;
    exports edu.fiuba.algo3.modelo.utils;
    exports edu.fiuba.algo3.modelo.loaders;
    exports edu.fiuba.algo3.modelo;
}
