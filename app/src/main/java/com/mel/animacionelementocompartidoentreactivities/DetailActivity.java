package com.mel.animacionelementocompartidoentreactivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    private ImageView img;
    private TextView txt;
    private Item item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Bundle extras=getIntent().getExtras();
        int id =extras.getInt(Constantes.EXTRA_ID);
        item=Items.get(id);
        img=findViewById(R.id.imageView);
        txt=findViewById(R.id.textView);
        //Conexion de los elementos compartidos
        ViewCompat.setTransitionName(img,"shared_view_photo");
        ViewCompat.setTransitionName(txt,"shared_view_title");
        loadItem();
    }

    private void loadItem() {
        txt.setText(item.getName());
        //Cargar imagen con glide en el imageView.
    }
}