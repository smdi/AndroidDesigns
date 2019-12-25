package aidev.com.androiddesigns;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import java.util.ArrayList;

public class design extends AppCompatActivity {


    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Initialiser> al;
    private String data = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
            "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, " +
            "when an unknown printer took a galley of type and scrambled it to make a type specimen book. " +
            "It has survived not only five centuries, " +
            "but also the leap into electronic typesetting, remaining essentially unchanged.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design);


        initialiser();
        dataSource();
    }

    private void dataSource() {


        for(int i = 0; i<20; i++){
            al.add( new Initialiser("Shaik Mohammad Imran",data));
        }
        Adapter adapter = new Adapter(design.this,al);
        recyclerView.setAdapter(adapter);

    }

    private void initialiser() {

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true);
        recyclerView.setLayoutManager(layoutManager);
        getSupportActionBar().hide();
        al = new ArrayList<Initialiser>();
    }
}
