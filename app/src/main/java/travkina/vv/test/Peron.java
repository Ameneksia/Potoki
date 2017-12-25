package travkina.vv.test;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Looper;
import android.view.MotionEvent;



public class Peron {
    private float x, y;
    Bitmap sprites;
    private int w,h,nFrames;
    private long prevTime;
    private long delay = 120;
    private float vx,vy;

    Paint p = new Paint();
    Rect frame ;

     Peron(float x, float y, Bitmap sprites, int nFrames) {
        this.x = x;
        this.y = y;
        this.sprites = sprites;
        this.nFrames = nFrames;
        this.w = sprites.getWidth() / this.nFrames;
        this.h = sprites.getHeight();
        frame = new Rect (0,0, w, h);
        prevTime = System.currentTimeMillis();
        this.vx = 0;
        this.vy = 0;
    }

    void update(){

        long nowTime = System.currentTimeMillis();;
        if((nowTime-prevTime)>= delay) {
            frame.left += w;
            frame.right += w;

            if (frame.right > sprites.getWidth()) {
                frame.left = 0;
                frame.right = w;

            }
            prevTime = nowTime;
        }
            x+=vx;

    }

    void draw(Canvas canvas){

        Rect frameTo = new Rect ((int)this.x-w/4, (int)this.y-h/4, (int)this.x+w/4, (int)this.y+h/4);
            canvas.drawBitmap(sprites, frame, frameTo, p);

     }

     void touch(MotionEvent event){

        if(event.getX()>this.x)
        vx = 1;
        else
         vx = -1;

     }
}
