package com.vikas.codetest.activity;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.support.v7.widget.RecyclerView;
        import android.util.Log;

        import com.vikas.codetest.R;
        import com.vikas.codetest.adapter.Movie_List_Adapter;
        import com.vikas.codetest.model.Dates;
        import com.vikas.codetest.model.Movie;
        import com.vikas.codetest.model.Result;
        import com.vikas.codetest.rest.ApiClient;
        import com.vikas.codetest.rest.ApiInterface;

        import java.util.ArrayList;
        import java.util.List;

        import retrofit2.Call;
        import retrofit2.Callback;
        import retrofit2.Response;

        import static com.vikas.codetest.Constant.AppConstant.API_KEY;


public class MainActivity extends AppCompatActivity {
    private static final String TAG=MainActivity.class.getSimpleName();
    private RecyclerView mRecyclerView;
    List<Result> result=new ArrayList<Result>() ;
    List<Dates> dates;
    Movie_List_Adapter mMovie_List_Adapter;
  //  private final static String API_KEY = "b7cd3340a794e5a2f35e3abb820b497f";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        getUpcommingMovieList();

    }

    private void getUpcommingMovieList() {
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);
        Call<Movie> call=apiService.getUpcomingMovie(API_KEY);
                    call.enqueue(new Callback<Movie>() {
                        @Override
                        public void onResponse(Call<Movie> call, Response<Movie> response) {
                            Log.d(TAG,"UpcommingMovieList onResponse"+response.toString());
                            result=response.body().getResults();
                            Log.d(TAG,"UpcommingMovieList size = "+result.size());
                            mMovie_List_Adapter=new Movie_List_Adapter(MainActivity.this,result);
                            mRecyclerView.setAdapter(mMovie_List_Adapter);
                            mMovie_List_Adapter.notifyDataSetChanged();
                            //

                        }

                        @Override
                        public void onFailure(Call<Movie> call, Throwable t) {
                        Log.e(TAG,"onFailure"+t.toString());
                        }
                    });
    }

    private void init() {
        mRecyclerView= (RecyclerView) findViewById(R.id.recyclerview_movie);

    }
}
