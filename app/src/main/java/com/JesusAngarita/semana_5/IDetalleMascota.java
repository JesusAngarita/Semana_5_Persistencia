package com.JesusAngarita.semana_5;

import java.util.ArrayList;

import com.JesusAngarita.semana_5.adaptadores.Adaptador;
import com.JesusAngarita.semana_5.pojo.Perro;

public interface IDetalleMascota {

    public void generarLinearLayoutVertical();

    public Adaptador crearAdaptador( ArrayList< Perro > perros );

    public void inicializarAdaptador(Adaptador adaptador);

}
