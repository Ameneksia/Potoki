package travkina.vv.test;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  {
 //  private GameView gameView;
 //  private Bitmap pic;
   TextView tv;

    NumberHandler handler = new NumberHandler();

    class NumberHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            setNumber(msg.arg1);
        }
    }

   void setNumber (int i){
       tv.setText(" "+i);
   }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv = (TextView) findViewById(R.id.tv);
        new AddNumber().start();


      //  gameView  = (GameView) findViewById(R.id.gameView);
       // pic  = BitmapFactory.decodeResource(getResources(),R.drawable.spritestrip);
    }


    class AddNumber extends Thread{
        public void run(){
            super.run();
            for(int i = 1; i<10; i++){
                final int  k = i;
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        tv.setText(k);
                    }
                });

              /*  Message m = new Message();
                m.arg1 = i;
                handler.handleMessage(m);
                */
             /*   final int  k = i;
               runOnUiThread(new Runnable() {
                   @Override
                   public void run() {
                       tv.setText(" "+k);
                   }
               });
                  */
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }




 /*   @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Peron charactor = new Peron(200, 200, pic, 6);
        gameView.addCharactor(charactor);
    }
    */
}
