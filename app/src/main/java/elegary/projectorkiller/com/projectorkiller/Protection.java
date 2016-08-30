package elegary.projectorkiller.com.projectorkiller;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;
import android.content.Intent;

public class Protection extends Activity{
    @Override
    protected void onCreate(Bundle SavedInstanceState){
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.ir_activity);
        Toast toast = Toast.makeText(getApplicationContext(), "Protection activée", Toast.LENGTH_SHORT);
        toast.show();

    }
    @Override
    protected void onStop(){
        super.onStop();
        Toast toast = Toast.makeText(getApplicationContext(), "Protection désactivée", Toast.LENGTH_SHORT);
        toast.show();
    }
}
