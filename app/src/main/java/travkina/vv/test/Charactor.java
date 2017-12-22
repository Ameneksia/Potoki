package travkina.vv.test;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;

/**
 * Created by Анастасия on 22.12.2017.
 */

public class Charactor {
    private float x, y;
    Paint p = new Paint();

     Charactor(float x, float y) {
        this.x = x;
        this.y = y;
    }

    void draw(Canvas canvas){
         canvas.drawCircle(x,y,30,p);
     }
     void touch(MotionEvent event){

        this.x = event.getX();

     }
}
