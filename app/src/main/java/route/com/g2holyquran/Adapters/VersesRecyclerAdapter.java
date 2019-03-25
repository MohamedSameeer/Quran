package route.com.g2holyquran.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import route.com.g2holyquran.Model.Verse;
import route.com.g2holyquran.R;


/**
 * Created by Mohamed Nabil Mohamed (Nobel) on 4/7/2018.
 * byte code SA
 * m.nabil.fci2015@gmail.com
 */

public class VersesRecyclerAdapter extends RecyclerView.Adapter <VersesRecyclerAdapter.ViewHolder> {

    ArrayList<Verse> data;

    public VersesRecyclerAdapter(ArrayList data){
        this.data=data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView =
                LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sura_item, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Verse item=data.get(position);
        holder.name.setText(item.getText()+"{"+(position+1)+"}");

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        View parent;
        TextView name;

        public ViewHolder(View parent){
            super(parent);
            this.parent=parent;
            name=parent.findViewById(R.id.name);

        }
    }
}
