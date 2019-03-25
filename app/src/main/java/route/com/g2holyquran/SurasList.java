package route.com.g2holyquran;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

import route.com.g2holyquran.Adapters.SurasRecyclerAdapter;
import route.com.g2holyquran.Model.Sura;


public class SurasList extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    SurasRecyclerAdapter adapter;
    ArrayList<Sura> SurasArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suras_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView=findViewById(R.id.recycler_view);
        layoutManager=new LinearLayoutManager(this);

        //prepare array list
        SurasArray = new ArrayList<>();
        for(int i=0;i<DataHolder.ArSuras.length;i++)
            SurasArray.add(new Sura(DataHolder.ArSuras[i]));

        adapter = new SurasRecyclerAdapter(SurasArray);
        adapter.setOnItemClickListener(new SurasRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position, Sura sura) {
                Intent intent=new Intent(SurasList.this,SuraContent.class);
                intent.putExtra("file_name",(position+1)+".txt");
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration decoration = new DividerItemDecoration(
                recyclerView.getContext(), DividerItemDecoration.HORIZONTAL);
        Drawable drawable = ContextCompat.getDrawable(SurasList.this,
                R.drawable.line_divider);
        decoration.setDrawable(drawable);

        recyclerView.addItemDecoration(decoration);
    }

}
