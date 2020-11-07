package com.example.uncompteur;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.le_compteur);
        if (savedInstanceState != null) {
            boolean isVisible =
                    savedInstanceState.getBoolean("reply_visible");

            if (isVisible) {
                mShowCount.setVisibility(View.VISIBLE);
                mShowCount.setText(savedInstanceState.getString("reply_text"));
                mShowCount.setVisibility(View.VISIBLE);
            }
        }

        Log.d("Question1", "Le compteur est réinitialisé à 0, mais le contenu de l'EditText est préservé.");
        Log.d("Question2", "Android arrête votre activité en appelant onPause(), onStop() et onDestroy(). Votre code doit redémarrer l'activité");
        Log.d("Question3", "onSaveInstanceState() est appelée avant la méthode onDestroy().");
        Log.d("Question4", "onPause() ou onStop()");
    }

    public void Count(View view) {
        mCount++;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // If the heading is visible, message needs to be saved.
        // Otherwise we're still using default layout.
        if (mShowCount.getVisibility() == View.VISIBLE) {
            outState.putBoolean("reply_visible", true);
            outState.putString("reply_text", mShowCount.getText().toString());
        }
    }
}