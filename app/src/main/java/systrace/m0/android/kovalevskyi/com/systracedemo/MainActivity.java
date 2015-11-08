package systrace.m0.android.kovalevskyi.com.systracedemo;

import android.os.Trace;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Trace.beginSection("MainActivity.onCreate");
        super.onCreate(savedInstanceState);
        slowMethod();
        setContentView(R.layout.activity_main);
        Trace.endSection();
    }

    private void slowMethod() {
        Trace.beginSection("MainActivity.slowMethod");
        try {
            Thread.sleep(4_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Trace.endSection();
    }

}
