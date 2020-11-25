package com.JesusAngarita.semana_5.presentador;

import android.content.Context;

import java.util.ArrayList;

import com.JesusAngarita.semana_5.DetalleMascota;
import com.JesusAngarita.semana_5.db.ConstructorPerrosDB;
import com.JesusAngarita.semana_5.pojo.Perro;

public class DetalleMascota_Presentador implements IDetalleMascota_Presentador {

    private DetalleMascota activity;
    private Context context;

    private ConstructorPerrosDB constructorPerrosDB;
    private ArrayList< Perro > perros;

    public DetalleMascota_Presentador(DetalleMascota activity, Context context){
        this.activity = activity;
        this.context = context;

        obtenerPerrosDB();
    }



    @Override
    public void obtenerPerrosDB() {
        constructorPerrosDB = new ConstructorPerrosDB( context );
        perros = constructorPerrosDB.obtenerDatos();

        mostrarPerrosDB();
    }

    @Override
    public void mostrarPerrosDB() {
        activity.inicializarAdaptador( activity.crearAdaptador( perros ) );

        activity.generarLinearLayoutVertical();
    }
}
