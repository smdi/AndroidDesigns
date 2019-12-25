package aidev.com.androiddesigns;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class design extends AppCompatActivity {


    ListView listView;
    ArrayList<Initialiser> al;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design);


        initialiser();
        dataSource();
    }

    private void dataSource() {

        Initialiser initialiser;

        for(int i = 0; i<20; i++){
            initialiser = new Initialiser("Username "+i,"Bio "+i);
            al.add(initialiser);
        }
        Adapter adapter = new Adapter(design.this,al);
        listView.setAdapter(adapter);

    }

    private void initialiser() {

        listView = (ListView)findViewById(R.id.listview);
        al = new ArrayList<Initialiser>();
    }
}
