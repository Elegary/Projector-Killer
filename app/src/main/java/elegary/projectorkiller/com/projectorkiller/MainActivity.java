package elegary.projectorkiller.com.projectorkiller;

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
        final int statut = 1;
        final Context context = this;
        final ConsumerIrManager IR = (ConsumerIrManager) context.getSystemService(Context.CONSUMER_IR_SERVICE);
        final int[] pattern = {1, 1, 96, 24, 48, 24, 48, 24, 48, 24, 48, 24, 24, 24, 48, 24, 24, 24, 48, 24, 24, 24, 24, 24, 24, 24, 24, 985, 96, 24, 48, 24, 48, 24, 48, 24, 48, 24, 24, 24, 48, 24, 24, 24, 48, 24, 24, 24, 24, 24, 24, 24, 24, 985, 96, 24, 48, 24, 48, 24, 48, 24, 48, 24, 24, 24, 48, 24, 24, 24, 48, 24, 24, 24, 24, 24, 24, 24, 24, 5128};
        final int frequency = pattern * 26.3;


        final Button button = (Button) findViewById(R.id.btn_pwr);

        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                IR.transmit(frequency, pattern);
            }
        });
        Button btn_mask = (Button) findViewById(R.id.btn_protect);
        btn_mask.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent protect = new Intent(MainActivity.this, Protection.class);
                startActivity(protect);
            }
        });
        final Button btn_repetitive_jv = (Button) findViewById(R.id.btn_repetetive);
        final Button btn_repetitive_jv_stop = (Button) findViewById(R.id.btn_repetetive_stop);

        btn_repetitive_jv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), "OK", Toast.LENGTH_SHORT);
                toast.show();
            }


        });
        btn_repetitive_jv_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast_stop = Toast.makeText(getApplicationContext(), "OK_stop", Toast.LENGTH_SHORT);
                toast_stop.show();


            }
        });

        }

}


