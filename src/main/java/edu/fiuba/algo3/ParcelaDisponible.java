package edu.fiuba.algo3;

public class ParcelaDisponible implements DisponibilidadParcela{

    public Boolean agregar(Defensa defensa, Parcela parcela) {
        return parcela.ocupar(defensa);
    }
}
