package hackathon.gmasa.interceptorsumit.com.rajasthanhackathon30;

import retrofit.Call;
import retrofit.http.GET;

public interface RetrofitObjectAPI {

    @GET("v1/query")
    Call<getAuthor> getHasuraDetails();
}
