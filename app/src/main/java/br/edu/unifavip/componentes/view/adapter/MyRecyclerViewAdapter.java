package br.edu.unifavip.componentes.view.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import br.edu.unifavip.componentes.R;

/**
 * Created by pedrodimoura on 10/09/16.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyRecyclerViewViewHolder> {

    private Context mContext;
    private String[] mPlanets;

    private View mView;

    public MyRecyclerViewAdapter(Context context, String[] planets) {
        this.mContext = context;
        this.mPlanets = planets;
    }

    @Override
    public MyRecyclerViewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        this.mView = LayoutInflater.from(this.mContext).inflate(R.layout.planet_item, parent, false);
        return new MyRecyclerViewViewHolder(this.mView);
    }

    @Override
    public void onBindViewHolder(MyRecyclerViewViewHolder holder, int position) {

        holder.imageView.setImageDrawable(ContextCompat.getDrawable(this.mContext, R.drawable.ic_earth_white_24dp));
        holder.textView.setText(this.mPlanets[position]);

    }

    @Override
    public int getItemCount() {
        return (this.mPlanets != null && this.mPlanets.length > 0 ? this.mPlanets.length : 0);
    }

    class MyRecyclerViewViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageView;
        TextView textView;

        public MyRecyclerViewViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            textView = (TextView) itemView.findViewById(R.id.textView);
            itemView.setOnClickListener(MyRecyclerViewViewHolder.this);
        }

        @Override
        public void onClick(View view) {
            Log.d("TAG", "Item Selecionado -> " + mPlanets[getLayoutPosition()]);
        }
    }

}
