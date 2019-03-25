package route.com.g2holyquran;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import route.com.g2holyquran.API.APIManager;
import route.com.g2holyquran.API.Model.RadiosItem;
import route.com.g2holyquran.API.Model.RadiosResponse;
import route.com.g2holyquran.Adapters.RadioRecyclerAdapter;
import route.com.g2holyquran.Base.MyBaseFragment;

public class RadioFragment extends MyBaseFragment {


    public RadioFragment() {
        // Required empty public constructor
    }

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    RadioRecyclerAdapter adapter;
    List<RadiosItem> channelsArray;
    View view;
    ImageButton play,stop;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_radio, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);
        play = view.findViewById(R.id.play);
        stop = view.findViewById(R.id.stop);


        getChannels();

        return view;
    }
    SnapHelper snapHelper;
    public void SetAdapter(){
        adapter= new RadioRecyclerAdapter(channelsArray);
        layoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
         snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view =  snapHelper.findSnapView(layoutManager);
                int pos= recyclerView.getChildAdapterPosition(view);
                PlayChnnel(channelsArray.get(pos).getURL());
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             stopChannel();
                  }
        });


    }

    MediaPlayer mediaPlayer;
    public void PlayChnnel(String url){
        mediaPlayer= new MediaPlayer();

        try {
            mediaPlayer.setDataSource(url);
            mediaPlayer.prepareAsync();
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.start();
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void stopChannel(){
        if(mediaPlayer!=null&&mediaPlayer.isPlaying())
            mediaPlayer.stop();

    }

    public void getChannels(){

        ShowProgressBar();
        APIManager.getAPIS().getRadioChannels()
                .enqueue(new Callback<RadiosResponse>() {
                    @Override
                    public void onResponse(Call<RadiosResponse> call, Response<RadiosResponse> response) {
                        HideProgressBar();
                        channelsArray = response.body().getRadios();
                        SetAdapter();

                    }

                    @Override
                    public void onFailure(Call<RadiosResponse> call, Throwable t) {
                        HideProgressBar();
                        ShowMessage("error",t.getLocalizedMessage());
                    }
                });
    }
}
