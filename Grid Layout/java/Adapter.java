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

        private TextView data1;
        private ImageView img1;
        public ViewHolder(View itemView) {
            super(itemView);
            data1 = (TextView) itemView.findViewById(R.id.data1);
            img1 = (ImageView) itemView.findViewById(R.id.image1);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {


        Initialiser homeInitialiser = listitem.get(position);
        final String data = ""+homeInitialiser.getData1();
        holder.data1.setText(" "+data);
        if(data.equals("Cardiogram")){Glide.with(context).load(R.drawable.cardiogram).into(holder.img1);}
        else{Glide.with(context).load(R.drawable.glucometer).into(holder.img1);}

        holder.img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,""+data,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listitem.size();
    }
}