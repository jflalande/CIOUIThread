package fr.insa_cvl.mooc.uithread;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread t = new Thread() {

            @Override
            public void run() {

                TextView tv = (TextView)findViewById(R.id.hello);
                RelativeLayout l = (RelativeLayout)findViewById(R.id.rootlayout);
                l.removeView(tv);
            }
        };
        t.start();
        try { Thread.sleep(1000); }
        catch (InterruptedException e) { e.printStackTrace(); }
        TextView tv = (TextView)findViewById(R.id.hello);
        tv.setText("Changing text of the textview (if still exists !)");

    }
}
