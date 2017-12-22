package travkina.vv.test;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.graphics.Canvas;

import java.util.ArrayList;

/**
 * Created by Анастасия on 22.12.2017.
 */

public class GameView extends View {

    private ArrayList<Charactor> objects = new ArrayList<>();


    public GameView(Context context) {
        super(context);
    }

    void addCharactor(Charactor charactor){
        objects.add(charactor);

    }

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);


    }
        @Override
        protected void onDraw (Canvas canvas){

for (Charactor charactor: objects){
    charactor.draw(canvas);
}


            invalidate();
        }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
          for (Charactor charactor: objects) {
              charactor.touch(event);
          }

        return super.onTouchEvent(event);

    }
}