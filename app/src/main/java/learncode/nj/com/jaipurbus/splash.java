package learncode.nj.com.jaipurbus;

import android.animation.Animator;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class splash extends Activity {
        ImageView ims;
        TextView pow,lear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        ims=findViewById(R.id.image);
        pow=findViewById(R.id.pow);
        lear=findViewById(R.id.learn);
        pow.setVisibility(View.INVISIBLE);
        lear.setVisibility(View.INVISIBLE);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(4000);
                    startActivity(new Intent(splash.this,MainActivity.class));
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        }).start();

        YoYo.with(Techniques.FadeIn).withListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                pow.setVisibility(View.VISIBLE);
                lear.setVisibility(View.VISIBLE);
                YoYo.with(Techniques.FadeIn).duration(1450).playOn(pow);
                YoYo.with(Techniques.FadeIn).duration(1450).playOn(lear);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        }).duration(2000).playOn(ims);




    }
}
