package aidev.com.androiddesigns;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class design extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design);


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.home);
    }



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {


            final Fragment[] fragment = {null};

            switch (item.getItemId()) {


                case R.id.home :

                    fragment[0] = new Home();
                    break;

                case R.id.events :

                    fragment[0] = new Events();
                    break;

                case R.id.history :

                    fragment[0] = new History();
                    break;

                case R.id.posts :

                    fragment[0] = new Posts();
                    break;

                case R.id.profile :

                    fragment[0] = new Profile();
                    break;

            }
            return loadFragment(fragment[0]);

        }
    };

    public boolean loadFragment(Fragment fragment)
    {
        if(fragment!=null)
        {
            android.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.frame, fragment).addToBackStack("tag");
            ft.commit();
            return  true;
        }
        return false;

    }


}
