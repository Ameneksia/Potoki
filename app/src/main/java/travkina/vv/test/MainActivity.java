package travkina.vv.test;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.sip.SipSession;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity  {
   private EditText editText;
   private SeekBar seekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText =  (EditText) findViewById(R.id.Ed1);
        seekBar = (SeekBar) findViewById(R.id.fontSize);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                editText.setTextSize(i);
                SharedPreferences.Editor editor = getSharedPreferences("Settings", MODE_PRIVATE).edit();
                editor.putInt("fontSize", i);
                editor.commit();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        try {
            File file = new File("abc.txt");

            // OutputStream os = new FileOutputStream(file);
            OutputStream os = this.openFileOutput("abc.txt", MODE_PRIVATE);
            PrintStream out = new PrintStream(os);
            out.println("Yes\n NextYes\n 123\n 5671");
            out.flush();
            out.close();


        InputStream is =  this.openFileInput("abc.txt");

        Scanner scanner = new Scanner(is);

            while (scanner.hasNext()) {
                String s = scanner.nextLine();

                editText.append(s+"\n");

            }


        } catch (FileNotFoundException e){
        Toast. makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }




    }

    @Override
    protected void onPause() {
        super.onPause();
        try {
            OutputStream os = this.openFileOutput("abc.txt", MODE_PRIVATE);
            PrintStream out = new PrintStream(os);
            out.println(""+editText.getText().toString());
            out.flush();
            out.close();
        } catch (FileNotFoundException e){
            Toast. makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences preferences = getSharedPreferences("Settings", MODE_PRIVATE);
        int fontSixe = preferences.getInt("fontSize",25);
        editText.setTextSize(fontSixe);
        seekBar.setProgress(fontSixe);


    }
}
