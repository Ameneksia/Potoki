package travkina.vv.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    int i = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView = (ImageView) findViewById(R.id.image);
        imageView.setImageResource(R.drawable.a);

        imageView.setOnClickListener(this);

    }



    @Override
    public void onClick(View v) {

        ImageView imageView =  (ImageView) findViewById(R.id.image);
        if(i%2==0) {
            imageView.setImageResource(R.drawable.q);
        }
        else{
            imageView.setImageResource(R.drawable.a);
        }
        i++;
    }


}
