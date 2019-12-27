package aidev.com.androiddesigns;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.graphics.Path;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.StackView;

import java.util.ArrayList;

public class design extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design);

        btn = (Button)findViewById(R.id.go);

        animaterHandler(3000);

    }

    private void animaterHandler(final long time) {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                callCircularAnim();
                handler.postDelayed(this,time);
            }
        }, time);
    }

    private void callCircularAnim() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Path path = new Path();
            path.addCircle(600f, 900f, 300f, Path.Direction.CCW);
            ObjectAnimator animator = ObjectAnimator.ofFloat(btn, View.X, View.Y, path);
            animator.setDuration(2000);
            animator.start();
        }
    }

}
