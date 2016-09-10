package br.edu.unifavip.componentes.view.fragment.impl;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import br.edu.unifavip.componentes.R;
import br.edu.unifavip.componentes.view.adapter.ListViewCustomAdapter;

/**
 * Created by pedrodimoura on 10/09/16.
 */

public class FragmentOne extends Fragment implements AdapterView.OnItemClickListener {

    private ListView mListView;
    private ArrayAdapter<String> mArrayAdapterListView;
    private ListViewCustomAdapter mListViewCustomAdapter;

    private View mView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.mView = inflater.inflate(R.layout.fragment_one, container, false);
        Log.d("TAG", "onCreateView");
        return this.mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("TAG", "onViewCreated");
        init();
    }

    private void init() {

        this.mListView = (ListView) getActivity().findViewById(R.id.listView);

        this.mArrayAdapterListView = new ArrayAdapter<>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.planets_array)
        );

        this.mListView.setAdapter(this.mArrayAdapterListView);
        this.mListView.setOnItemClickListener(FragmentOne.this);

//        this.mListViewCustomAdapter = new ListViewCustomAdapter(
//                getActivity(),
//                getResources().getStringArray(R.array.planets_array)
//        );
//
//        this.mListView.setAdapter(this.mListViewCustomAdapter);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Log.d("TAG", "Item selecionado -> " + getResources().getStringArray(R.array.planets_array)[i]);
    }
}
