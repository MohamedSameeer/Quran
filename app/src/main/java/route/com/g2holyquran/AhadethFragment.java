package route.com.g2holyquran;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import route.com.g2holyquran.Adapters.AhadethRecyclerAdapter;
import route.com.g2holyquran.Base.MyBaseFragment;
import route.com.g2holyquran.Model.Hadeth;


/**
 * A simple {@link Fragment} subclass.
 */
public class AhadethFragment extends MyBaseFragment {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    ArrayList<Hadeth> Allahadeth;
    AhadethRecyclerAdapter adapter;
    public AhadethFragment() {
        // Required empty public constructor
    }


    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_ahadeath, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);

        Allahadeth = ReadAhadethFile();
        adapter = new AhadethRecyclerAdapter(Allahadeth);
        adapter.setOnItemClickListener(new AhadethRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position, Hadeth hadeth) {
                HadethDialogFragment dialogFragment= new HadethDialogFragment();
                dialogFragment.setHadethItem(hadeth);
                dialogFragment.show(getChildFragmentManager(),"hadethDialog");
                
            }
        });
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);


        return view;
    }

    ArrayList<Hadeth> ReadAhadethFile(){

        ArrayList<Hadeth> AllAhadeth = new ArrayList<>();

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(getActivity().getAssets().open("ahadith_arabic.txt")));

            // do reading, usually loop until end of file reading
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                //process line
                Hadeth hadeth= new Hadeth();
                hadeth.setTitle(mLine);
                while ((mLine = reader.readLine()) != null){
                    if(mLine.equals("#"))break;
                    hadeth.setContent(hadeth.getContent()+"\n"+mLine);
                }
                AllAhadeth.add(hadeth);

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
        return AllAhadeth;
    }



}
