package route.com.g2holyquran;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import route.com.g2holyquran.Adapters.SurasRecyclerAdapter;
import route.com.g2holyquran.Base.MyBaseFragment;
import route.com.g2holyquran.Model.Sura;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuranFragment extends MyBaseFragment {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    SurasRecyclerAdapter adapter;
    ArrayList<Sura> SurasArray;

    public QuranFragment() {
        // Required empty public constructor
    }


    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_quran, container, false);
        recyclerView=view.findViewById(R.id.recycler_view);
        layoutManager=new LinearLayoutManager(getActivity());

        //prepare array list
        SurasArray = new ArrayList<>();
        for(int i=0;i<DataHolder.ArSuras.length;i++)
            SurasArray.add(new Sura(DataHolder.ArSuras[i]));

        adapter = new SurasRecyclerAdapter(SurasArray);
        adapter.setOnItemClickListener(new SurasRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position, Sura sura) {
                Intent intent=new Intent(getActivity(),SuraContent.class);
                intent.putExtra("file_name",(position+1)+".txt");
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);


        return view;
    }

}
