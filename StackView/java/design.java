package aidev.com.androiddesigns;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;
import android.widget.StackView;

import java.util.ArrayList;

public class design extends AppCompatActivity {


    private StackView stackView;
    private ArrayList<Initialiser> al;
    private String data = "Wed and Mobile application developer";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design);

        initialiser();
        dataSource();
    }

    private void dataSource() {

        for(int i = 0; i<3; i++){
            al.add( new Initialiser("Shaik Mohammad Imran",data));
        }
        Adapter adapter = new Adapter(design.this, R.layout.listitem, al);
        stackView.setAdapter(adapter);

    }

    private void initialiser() {

        stackView = (StackView) findViewById(R.id.stackView);
        getSupportActionBar().hide();
        al = new ArrayList<Initialiser>();
    }
}
