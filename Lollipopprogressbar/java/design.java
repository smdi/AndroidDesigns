package aidev.com.androiddesigns;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Path;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
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

    public ImageView img,bck;
    public int mLevel = 0;
    public Drawable imgDrawable;
    public Handler handler;
    private Runnable animateImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design);


        initializer();

    }

    @SuppressLint("ResourceType")
    private void initializer() {
        img = (ImageView) findViewById(R.id.lollipop);
        bck = (ImageView) findViewById(R.id.backlollipop);



        imgDrawable =  img.getBackground();

        if (imgDrawable instanceof ClipDrawable) {
            ((ClipDrawable)imgDrawable).setLevel(imgDrawable.getLevel() + 2000);
        }
        handler = new Handler();
        handler.post(animateImage);


        animaterHandler(0);

    }

    private void animaterHandler(final long time) {
        handler = new Handler();
        handler.postDelayed(animateImage =new Runnable() {
            @Override
            public void run() {
                doTheAnimation();
                handler.postDelayed(this,time);
            }
        }, time);
    }

    private void doTheAnimation() {
        mLevel += 2000;

        if (mLevel <= 10000) {
            imgDrawable.setLevel(mLevel);
        } else {
            mLevel = 0;
            imgDrawable.setLevel(mLevel);
        }
    }
}
