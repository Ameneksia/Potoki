package travkina.vv.test;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.graphics.Canvas;

import java.util.ArrayList;


public class GameView extends View {

    private ArrayList<Peron> objects = new ArrayList<>();


    public GameView(Context context) {
        super(context);
    }

    void addCharactor(Peron charactor){
        objects.add(charactor);

    }

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);


    }
        @Override
        protected void onDraw (Canvas canvas){

for (Peron charactor: objects){
    charactor.draw(canvas);
    charactor.update();
}


            invalidate();
        }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
          for (Peron charactor: objects) {
              charactor.touch(event);
          }

        return super.onTouchEvent(event);

    }
}