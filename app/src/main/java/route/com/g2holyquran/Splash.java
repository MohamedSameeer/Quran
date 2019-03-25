package route.com.g2holyquran;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import route.com.g2holyquran.Base.MyBaseActivity;

public class Splash extends MyBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);




        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Splash.this,
                        HomeActivity.class));
            }
        }, 3000);

    }
}
