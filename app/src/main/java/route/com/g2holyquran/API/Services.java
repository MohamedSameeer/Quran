package route.com.g2holyquran.API;

import retrofit2.Call;
import retrofit2.http.GET;
import route.com.g2holyquran.API.Model.RadiosResponse;

/**
 * Created by Mohamed Nabil Mohamed (Nobel) on 9/28/2018.
 * byte code SA
 * m.nabil.fci2015@gmail.com
 */
public interface Services {

    @GET("radio/radio_ar.json")
   Call<RadiosResponse> getRadioChannels();
}
