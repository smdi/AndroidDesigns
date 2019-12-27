package aidev.com.androiddesigns;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import java.util.ArrayList;

public class design extends AppCompatActivity {


    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Initialiser> al;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design);

        initialiser();
        dataSource();
    }

    private void dataSource() {

        for(int i = 0; i<10; i++){
            al.add( new Initialiser("Cardiogram"));
        }
        for(int i = 0; i<10; i++){
            al.add( new Initialiser("Glucometer"));
        }
        Adapter adapter = new Adapter(design.this,al);
        recyclerView.setAdapter(adapter);
    }

    private void initialiser() {

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
//        getSupportActionBar().hide();
        al = new ArrayList<Initialiser>();
    }
}
