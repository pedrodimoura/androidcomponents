package br.edu.unifavip.componentes.view.fragment.impl;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.edu.unifavip.componentes.R;
import br.edu.unifavip.componentes.view.adapter.MyRecyclerViewAdapter;

/**
 * Created by pedrodimoura on 10/09/16.
 */

public class FragmentTwo extends Fragment {

    private RecyclerView mRecyclerView;
    private MyRecyclerViewAdapter mMyRecyclerViewAdapter;

    private View mView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.mView = inflater.inflate(R.layout.fragment_two, container, false);
        return this.mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
    }

    private void init() {
        this.mRecyclerView = (RecyclerView) getActivity().findViewById(R.id.recyclerView);

        this.mMyRecyclerViewAdapter = new MyRecyclerViewAdapter(getActivity(), getResources().getStringArray(R.array.planets_array));
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        this.mRecyclerView.setAdapter(this.mMyRecyclerViewAdapter);
    }

}
