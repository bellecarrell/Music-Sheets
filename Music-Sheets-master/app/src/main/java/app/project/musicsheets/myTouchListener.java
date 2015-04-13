package app.project.musicsheets;

import android.content.ClipData;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Jacob on 4/5/2015.
 */
public class myTouchListener implements View.OnTouchListener {
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if(motionEvent.getAction() == MotionEvent.ACTION_DOWN)
        {
            ClipData data = ClipData.newPlainText("","");
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
            view.startDrag(data,shadowBuilder,view,0);
            view.setVisibility(View.INVISIBLE);
            return true;
        }
        else
            return false;
    }
}
