package pondthaitay.communicationfragment.exercises;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            setupInstance();
        }
    }

    private void setupInstance() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_a, FragmentA.getInstance())
                .commit();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_b, FragmentB.getInstance())
                .commit();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }
}
