package app.project.musicsheets;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.DragEvent;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Jacob on 4/5/2015.
 */
public class ComposeActivity extends ActionBarActivity implements View.OnDragListener, View.OnLongClickListener{

//    ImageView imageView = new ImageView(this);
/*
    imageView.setOnLongClickListener(new View.OnLongClickListener()
    {
        @Override
        public boolean onLongClick(View v){
            ClipData.Item item = new ClipData.Item((android.content.Intent) v.getTag());
            ClipData dragData = new ClipData(v.getTag(), ClipData.MIMETYPE_TEXT_PLAIN, item);

            // Instantiates the drag shadow builder.
            View.DragShadowBuilder myShadow = new MyDragShadowBuilder(imageView);
            return false;
        }
    });
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.compose_activity);


/*
        // Set touch listeners for each image view
        // TODO: Fix so that each image view is progammatically assigned Touch Listener

        findViewById(R.id.imageView).setOnTouchListener(new myTouchListener());
        findViewById(R.id.imageView2).setOnTouchListener(new myTouchListener());
        findViewById(R.id.imageView3).setOnTouchListener(new myTouchListener());
        findViewById(R.id.imageView4).setOnTouchListener(new myTouchListener());
        findViewById(R.id.imageView5).setOnTouchListener(new myTouchListener());
        findViewById(R.id.imageView6).setOnTouchListener(new myTouchListener());
        findViewById(R.id.imageView7).setOnTouchListener(new myTouchListener());
        findViewById(R.id.imageView8).setOnTouchListener(new myTouchListener());
        findViewById(R.id.imageView9).setOnTouchListener(new myTouchListener());
        findViewById(R.id.imageView10).setOnTouchListener(new myTouchListener());
        findViewById(R.id.imageView11).setOnTouchListener(new myTouchListener());
        findViewById(R.id.imageView12).setOnTouchListener(new myTouchListener());
        findViewById(R.id.imageView13).setOnTouchListener(new myTouchListener());
        findViewById(R.id.imageView14).setOnTouchListener(new myTouchListener());
        findViewById(R.id.imageView15).setOnTouchListener(new myTouchListener());
        findViewById(R.id.imageView16).setOnTouchListener(new myTouchListener());
        findViewById(R.id.imageView17).setOnTouchListener(new myTouchListener());
        findViewById(R.id.imageView18).setOnTouchListener(new myTouchListener());
*/
        // Set drag listeners for each image view
        // TODO: Fix so that each image view is progammatically assigned Drag Listener
/*
        findViewById(R.id.imageView).setOnDragListener(new MyDragListener());
        findViewById(R.id.imageView2).setOnDragListener(new MyDragListener(findViewById()));
        findViewById(R.id.imageView3).setOnDragListener(new MyDragListener(findViewById(R.drawable.imageView)));
        findViewById(R.id.imageView4).setOnDragListener(new MyDragListener(findViewById(R.drawable.imageView)));
        findViewById(R.id.imageView5).setOnDragListener(new MyDragListener(findViewById(R.drawable.imageView)));
        findViewById(R.id.imageView6).setOnDragListener(new MyDragListener(findViewById(R.drawable.imageView)));
        findViewById(R.id.imageView7).setOnDragListener(new MyDragListener(findViewById(R.drawable.imageView)));
        findViewById(R.id.imageView8).setOnDragListener(new MyDragListener(findViewById(R.drawable.imageView)));
        findViewById(R.id.imageView9).setOnDragListener(new MyDragListener(findViewById(R.drawable.imageView)));
        findViewById(R.id.imageView10).setOnDragListener(new MyDragListener(findViewById(R.drawable.imageView)));
        findViewById(R.id.imageView11).setOnDragListener(new MyDragListener(findViewById(R.drawable.imageView)));
        findViewById(R.id.imageView12).setOnDragListener(new MyDragListener(findViewById(R.drawable.imageView)));
        findViewById(R.id.imageView13).setOnDragListener(new MyDragListener(findViewById(R.drawable.imageView)));
        findViewById(R.id.imageView14).setOnDragListener(new MyDragListener(findViewById(R.drawable.imageView)));
        findViewById(R.id.imageView15).setOnDragListener(new MyDragListener(findViewById(R.drawable.imageView)));
        findViewById(R.id.imageView16).setOnDragListener(new MyDragListener(findViewById(R.drawable.imageView)));
        findViewById(R.id.imageView17).setOnDragListener(new MyDragListener(findViewById(R.drawable.imageView)));
        findViewById(R.id.imageView18).setOnDragListener(new MyDragListener(findViewById(R.drawable.imageView)));

*/
    }



    @Override
    public boolean onDrag(View v, DragEvent event) {
        return false;
    }

    @Override
    public boolean onLongClick(View v) {
        return false;
    }
}
