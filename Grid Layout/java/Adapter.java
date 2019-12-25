package aidev.com.androiddesigns;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<Initialiser> listitem;
    private Context context;


    public Adapter(Context context, List<Initialiser> listitem) {
        this.listitem = listitem;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{



        private TextView data1,data2;
        private ImageView img1,img2;
        public ViewHolder(View itemView) {
            super(itemView);

            data1 = (TextView) itemView.findViewById(R.id.data1);
            data2 = (TextView) itemView.findViewById(R.id.data2);
            img1 = (ImageView) itemView.findViewById(R.id.image1);
            img2 = (ImageView) itemView.findViewById(R.id.image2);
        }
    }


    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem,parent,false);

        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        Initialiser homeInitialiser = listitem.get(position);

        holder.data1.setText(" "+homeInitialiser.getData1());

        holder.data2.setText(" "+homeInitialiser.getData2());

        Glide.with(context).load(R.drawable.cardiogram).into(holder.img1);
        Glide.with(context).load(R.drawable.glucometer).into(holder.img2);
    }


    @Override
    public int getItemCount() {
        return listitem.size();
    }
}