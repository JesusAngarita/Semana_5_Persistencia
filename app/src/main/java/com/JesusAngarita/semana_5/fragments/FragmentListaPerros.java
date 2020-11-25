package com.JesusAngarita.semana_5.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import com.JesusAngarita.semana_5.R;
import com.JesusAngarita.semana_5.adaptadores.Adaptador;
import com.JesusAngarita.semana_5.db.ConstructorPerrosDB;
import com.JesusAngarita.semana_5.pojo.Perro;

public class FragmentListaPerros extends Fragment {

    ArrayList<Perro> perros;
    private RecyclerView rvPerro;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.lista_perros_fragment, container, false);


        rvPerro = (RecyclerView) v.findViewById(R.id.rvPerro);

        LinearLayoutManager llm = new LinearLayoutManager( getActivity() );
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvPerro.setLayoutManager(llm);
        iniciarPerros();
        inicializarAdaptador();

        return v;
    }

    public void iniciarPerros(){
        perros = new ArrayList< Perro >();

        ConstructorPerrosDB constructorPerrosDB = new ConstructorPerrosDB( getContext() );

        perros.add(new Perro(R.drawable.perro_nueve, "Dollar", constructorPerrosDB.obtenerLikePerro( "Dollar" ) ));
        perros.add(new Perro(R.drawable.perro_cuatro, "Killer", constructorPerrosDB.obtenerLikePerro( "Killer" ) ));
        perros.add(new Perro(R.drawable.perro_ocho, "Yandy", constructorPerrosDB.obtenerLikePerro( "Yandy" ) ));
        perros.add(new Perro(R.drawable.perro_cinco, "Maximo", constructorPerrosDB.obtenerLikePerro( "Maximo" ) ));
        perros.add(new Perro(R.drawable.perro_dos, "Tony", constructorPerrosDB.obtenerLikePerro( "Tony" ) ));
        perros.add(new Perro(R.drawable.perro_tres, "Chester", constructorPerrosDB.obtenerLikePerro( "Chester" ) ));
        perros.add(new Perro(R.drawable.perro_seis, "Niño", constructorPerrosDB.obtenerLikePerro( "Niño" ) ));
        perros.add(new Perro(R.drawable.perro_siete, "Princesa", constructorPerrosDB.obtenerLikePerro( "Princesa" ) ));
    }

    public void inicializarAdaptador(){
        Adaptador adaptador = new Adaptador( perros, getActivity() );

        rvPerro.setAdapter(adaptador);
    }

}
