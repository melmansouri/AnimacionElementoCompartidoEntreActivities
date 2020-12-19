package com.mel.animacionelementocompartidoentreactivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private GridView gridView;
    private GridAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView=findViewById(R.id.grid);
        gridView.setOnItemClickListener(this);
        adapter=new GridAdapter();
        gridView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Item item=(Item) adapterView.getItemAtPosition(i);
        Intent intent=new Intent(this,DetailActivity.class);
        intent.putExtra(Constantes.EXTRA_ID,item.getId());
        //Obtenemos una referencia a los elementos visuales que queremos transicionar
        //ImageView.....
        //TextView.....

        ActivityOptionsCompat activityOptionsCompat=ActivityOptionsCompat.makeSceneTransitionAnimation(this,new Pair<View,String>(imageview,"shared_view_photo")
        ,new Pair<View,String>(textview,"shared_view_title"));
        startActivity(intent,activityOptionsCompat.toBundle());
    }

    private class GridAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return Item.ITEMS.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            return null;
        }
    }
}