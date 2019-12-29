package aidev.com.androiddesigns;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Path;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.StackView;

import java.util.ArrayList;

public class design extends AppCompatActivity {

    private ImageView img;
    private Animation roration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design);


        img = (ImageView) findViewById(R.id.lollipop);
        roration = new RotateAnimation(0f,350f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);

        roration.setDuration(10000);               // duration in ms
        roration.setRepeatCount(-1);                // -1 = infinite repeated
        roration.setRepeatMode(Animation.REVERSE); // reverses each repeat
        roration.setFillAfter(true);

        img.setAnimation(roration);


    }
}
