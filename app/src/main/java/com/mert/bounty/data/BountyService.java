package com.mert.getty.data;

import com.mert.getty.data.model.GettyResponse;
import com.mert.getty.data.model.Person;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Mert Kilic on 18.7.2017.
 */

public interface BountyService {
    @GET("search/images")
    Call<GettyResponse> search(@Query("phrase") String keyword, @Query("page_size") int pageSize, @Query("page") int page);

    @POST("login")
    Call<GettyResponse> login(@Query("username")String username, @Body RequestBody password);

    @GET("contacts")
    Call<List<Person>> getContacts();
}
