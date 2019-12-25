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



        private TextView username,bio;
        private ImageView profile;
        public ViewHolder(View itemView) {
            super(itemView);

            username = (TextView) itemView.findViewById(R.id.username);
            bio = (TextView) itemView.findViewById(R.id.bio);
            profile = (ImageView) itemView.findViewById(R.id.profile);

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

        holder.username.setText(" "+homeInitialiser.getUsername());

        holder.bio.setText(" "+homeInitialiser.getBio());

        Glide.with(context).load(R.drawable.imran).into(holder.profile);
    }


    @Override
    public int getItemCount() {
        return listitem.size();
    }
}