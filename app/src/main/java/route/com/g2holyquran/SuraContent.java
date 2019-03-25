package route.com.g2holyquran;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import route.com.g2holyquran.Adapters.VersesRecyclerAdapter;
import route.com.g2holyquran.Base.MyBaseActivity;
import route.com.g2holyquran.Model.Verse;

public class SuraContent extends MyBaseActivity {

    RecyclerView recyclerView;
    VersesRecyclerAdapter adapter;
    LinearLayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sura_content);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String fileName =getIntent().getStringExtra("file_name");
        ArrayList<Verse> allVerses = ReadSura(fileName);
        recyclerView= findViewById(R.id.recycler_view);
        adapter=new VersesRecyclerAdapter(allVerses);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(
                new DividerItemDecoration(SuraContent.this,
                        DividerItemDecoration.HORIZONTAL));



    }


    ArrayList<Verse> ReadSura(String fileName){

        ArrayList<Verse> AllVerses = new ArrayList<>();

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(getAssets().open(fileName)));

            // do reading, usually loop until end of file reading
            String mLine;
            int index=1;
            while ((mLine = reader.readLine()) != null) {
                //process line
                AllVerses.add(new Verse(mLine,index++));
            }
        } catch (IOException e) {
            //log the exception
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    //log the exception
                }
            }
        }
        return AllVerses;
    }
}
