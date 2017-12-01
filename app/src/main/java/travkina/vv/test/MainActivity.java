package travkina.vv.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
         button.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        Toast tost = Toast.makeText(this,R.string.text, Toast.LENGTH_LONG);
        tost.show();
    }
}
