package com.elegary.projectorkiller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.ConsumerIrManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;



public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Context context = this;
        final ConsumerIrManager IR_LED = (ConsumerIrManager) context.getSystemService(Context.CONSUMER_IR_SERVICE);
        final int[] pattern_base = {1,1,340,169,19,24,19,65,19,24,19,24,19,24,19,24,19,24,19,24,19,24,19,65,19,65,19,65,19,65,19,65,19,65,19,65,19,24,19,65,19,24,19,24,19,24,19,24,19,24,19,24,19,65,19,24,19,65,19,65,19,65,19,65,19,65,19,65,19,4863};
        final Button btn_power = (Button) findViewById(R.id.btn_pwr);

            btn_power.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    if (IR_LED.hasIrEmitter()){
                        IR_LED.transmit(38400, ConvertPattern(pattern_base));
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Emetteur IR non trouvé", Toast.LENGTH_LONG).show();
                    }
                    }

            });
                Button btn_mask = (Button) findViewById(R.id.btn_protect);
                btn_mask.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Intent protect = new Intent(MainActivity.this, Protection.class);
                       startActivity(protect);
                }
           });
            Button btn_repetitive_jv = (Button) findViewById(R.id.btn_repetetive);


            btn_repetitive_jv.setOnClickListener(new View.OnClickListener() {
               // @Override
                public void onClick(View v) {

                    Intent boucle = new Intent(MainActivity.this, Boucle.class);
                    startActivity(boucle);
                }


            });


        }

    public static int[] ConvertPattern(int[] pattern){
        int[] pattern_converted = new int[pattern.length];
        if (android.os.Build.MANUFACTURER.equalsIgnoreCase("SAMSUNG")){
            for(int i =0; i<=pattern.length-1; i++){
                pattern_converted[i] = (int) Math.ceil(pattern[i] * 26.27272727272727);
            }
            return pattern_converted;
        }
        return pattern;
    }

    }




