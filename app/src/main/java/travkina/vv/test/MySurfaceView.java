package travkina.vv.test;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Анастасия on 26.01.2018.
 */

public class MySurfaceView  extends SurfaceView implements SurfaceHolder.Callback{
    public MySurfaceView(Context context){
        super(context);
    }

    public MySurfaceView(Context context, AttributeSet attrs) {

        super(context, attrs);
        getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
      new MyTread().start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    class MyTread extends Thread {
        @Override
        public void run() {
            Paint p = new Paint();
            p.setColor(Color.GREEN);
            int x= 0;
            while (true){
                try {
                    MyTread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Canvas canvas = getHolder().lockCanvas();
                canvas.drawCircle(x,200,30,p);
                getHolder().unlockCanvasAndPost(canvas);
                x++;
            }
        }
    }
}
