package travkina.vv.test;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity  {
   private GameView gameView;
   private Bitmap pic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gameView  = (GameView) findViewById(R.id.gameView);
        pic  = BitmapFactory.decodeResource(getResources(),R.drawable.spritestrip);
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Peron charactor = new Peron(200, 200, pic, 6);
        gameView.addCharactor(charactor);
    }
}
