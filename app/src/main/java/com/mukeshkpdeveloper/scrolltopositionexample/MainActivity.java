package com.mukeshkpdeveloper.scrolltopositionexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ScrollPositionListener{
    private RecyclerView rv;
    private ScrollPositionListener scrollPositionListener;
    private ArrayList<LocationMasterDatum> locationMasterData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scrollPositionListener = this;
        rv = findViewById(R.id.rv_location);

        for (int i = 0; i < 10; i++) {
            LocationMasterDatum locationMasterDatum = new LocationMasterDatum();
            locationMasterDatum.setLocationId(i);
            locationMasterDatum.setLocationName("Test "+i);
            locationMasterData.add(locationMasterDatum);
        }

        RvAdapter recyclerDataAdapter = new RvAdapter(MainActivity.this, locationMasterData, scrollPositionListener);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(layoutManager);
        rv.setAdapter(recyclerDataAdapter);
        rv.setHasFixedSize(true);
    }

    @Override
    public void scrollPositionListener(int position) {

      //  rv.scrollToPosition(position + 1);
       /* LinearLayoutManager manager = (LinearLayoutManager) rv.getLayoutManager();
        int position1 = manager.findFirstVisibleItemPosition();
        View firstItemView = manager.findViewByPosition(position1);
        int Offset = firstItemView.getTop();
        ((LinearLayoutManager)rv.getLayoutManager()).scrollToPositionWithOffset(position + 1,Offset);*/

        LinearSmoothScroller smoothScroller=new LinearSmoothScroller(MainActivity.this){
            @Override
            protected int getVerticalSnapPreference() {
                return LinearSmoothScroller.SNAP_TO_START;
            }
        };
        smoothScroller.setTargetPosition(position + 1);  // pos on which item you want to scroll recycler view
        rv.getLayoutManager().startSmoothScroll(smoothScroller);
    }
}