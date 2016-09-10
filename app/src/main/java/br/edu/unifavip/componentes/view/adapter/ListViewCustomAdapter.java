package br.edu.unifavip.componentes.view.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import br.edu.unifavip.componentes.R;

/**
 * Created by pedrodimoura on 10/09/16.
 */

public class ListViewCustomAdapter extends BaseAdapter {

    private Context mContext;
    private String[] mPlanets;

    public ListViewCustomAdapter(Context context, String[] planets) {
        this.mContext = context;
        this.mPlanets = planets;
    }

    @Override
    public int getCount() {
        return (mPlanets != null && mPlanets.length > 0 ? mPlanets.length : 0);
    }

    @Override
    public String getItem(int i) {
        return this.mPlanets[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

        ListViewCustomAdapterViewHolder listViewCustomAdapterViewHolder;

        if (view == null) {

            view = LayoutInflater.from(this.mContext).inflate(R.layout.planet_item, viewGroup, false);

            listViewCustomAdapterViewHolder = new ListViewCustomAdapterViewHolder();
            listViewCustomAdapterViewHolder.imageView = (ImageView) view.findViewById(R.id.imageView);
            listViewCustomAdapterViewHolder.textView = (TextView) view.findViewById(R.id.textView);
            view.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    Log.d("TAG", "Item Selecionado -> " + mPlanets[i]);
                }
            });

            view.setTag(listViewCustomAdapterViewHolder);
        } else {
            listViewCustomAdapterViewHolder = (ListViewCustomAdapterViewHolder) view.getTag();
        }

        listViewCustomAdapterViewHolder.imageView.setImageDrawable(ContextCompat.getDrawable(this.mContext, R.drawable.ic_earth_white_24dp));
        listViewCustomAdapterViewHolder.textView.setText(this.mPlanets[i]);

        return view;
    }

    private class ListViewCustomAdapterViewHolder {
        ImageView imageView;
        TextView textView;
    }

}
