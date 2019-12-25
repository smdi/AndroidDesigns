package aidev.com.androiddesigns;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Adapter extends ArrayAdapter<Initialiser> {


    private Context context;

    private ArrayList<Initialiser> androidAdapters;

    public Adapter(Activity context , ArrayList<Initialiser> androidAdapters)
    {
        super(context , 0 ,androidAdapters);
        this.context = context;
        this.androidAdapters = androidAdapters;
    }
    @SuppressLint("ResourceType")
    @Override
    public View getView(int position , View convert , ViewGroup parent)
    {
        View listItemView = convert;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.listitem, parent, false);
        }
        final Initialiser curr = getItem(position);

        TextView t1 = (TextView) listItemView.findViewById(R.id.timeing);
        t1.setText(curr.getTiming());


        TextView t2 = (TextView) listItemView.findViewById(R.id.date);
        t2.setText(curr.getDate());

        TextView t3 = (TextView) listItemView.findViewById(R.id.timezone);
        t3.setText(curr.getTimezone());

       ImageView imageView = (ImageView) listItemView.findViewById(R.id.profile);
       imageView.setImageResource(R.drawable.backsalah);

       listItemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Toast.makeText(context,""+curr.getTiming(),Toast.LENGTH_SHORT).show();
           }
       });

        return listItemView;
    }
    @Override
    public int getCount() {
        return androidAdapters.size();
    }
}