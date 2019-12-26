package aidev.com.androiddesigns;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

public class Adapter extends ArrayAdapter<Initialiser> {

    private List<Initialiser> listitem;
    private Context context;


    public Adapter(Context context, int textViewResourceId, List<Initialiser> listitem) {
        super(context,textViewResourceId,listitem);
        this.listitem = listitem;
        this.context = context;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        if (itemView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = layoutInflater.inflate(R.layout.listitem, null);
        }
        Initialiser stackItem = listitem.get(position);
        if (stackItem != null) {

            TextView bio = (TextView) itemView.findViewById(R.id.bio);
            TextView username = (TextView) itemView.findViewById(R.id.username);
            ImageView imageView = (ImageView) itemView.findViewById(R.id.profile);


            if (bio != null) {
                bio.setText(stackItem.getBio());
                username.setText(stackItem.getUsername());
                imageView.setImageResource(R.drawable.imran);
                imageView.setBackgroundColor(Color.rgb(211,204,188));
            }

        }
        return itemView;
    }



}