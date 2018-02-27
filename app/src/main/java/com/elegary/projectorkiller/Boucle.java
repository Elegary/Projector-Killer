package com.elegary.projectorkiller;

import android.app.Activity;
import android.content.Context;
import android.hardware.ConsumerIrManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Boucle extends Activity{
    final int[] pattern_base = {1, 1, 96, 24, 48, 24, 48, 24, 48, 24, 48, 24, 24, 24, 48, 24, 24, 24, 48, 24, 24, 24, 24, 24, 24, 24, 24, 985, 96, 24, 48, 24, 48, 24, 48, 24, 48, 24, 24, 24, 48, 24, 24, 24, 48, 24, 24, 24, 24, 24, 24, 24, 24, 985, 96, 24, 48, 24, 48, 24, 48, 24, 48, 24, 24, 24, 48, 24, 24, 24, 48, 24, 24, 24, 24, 24, 24, 24, 24, 5128};

    @Override
    protected void onCreate(Bundle SavedInstanceState){
        super.onCreate(SavedInstanceState);
        Toast toast = Toast.makeText(getApplicationContext(), "Démarrage de l'envoie en boucle...", Toast.LENGTH_SHORT);
        toast.show();
        setContentView(R.layout.boucle_layout);

        final Context context = this;
        final ConsumerIrManager IR = (ConsumerIrManager) context.getSystemService(Context.CONSUMER_IR_SERVICE);

       Button btn_repetitive_jv_stop = (Button) findViewById(R.id.btn_repetetive_stop);
        btn_repetitive_jv_stop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                finish();
            }
        });
        int i = 0;
        while (i<10) {
            setContentView(R.layout.boucle_layout);
            i = i + 1;
            IR.transmit(38400, MainActivity.ConvertPattern(pattern_base));
        }
    }

    @Override
    protected void onStop(){
        super.onStop();
        Toast toast = Toast.makeText(getApplicationContext(), "Arrêt de l'envoie en boucle...", Toast.LENGTH_SHORT);
        toast.show();
    }

}
