package test.demo.code.playwings;

import android.support.annotation.NonNull;
import android.util.Log;

import java.util.Map;

import io.realm.Realm;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.QueryName;
import test.demo.code.playwings.data.Realm.Beers;

public class Constants {

    public static void importFromJson(final String json) {
        try {
            Realm.getDefaultInstance().executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(@NonNull Realm realm) {
                    realm.createOrUpdateAllFromJson(Beers.class, json);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public enum URL {
        BEER_API_URL("https://api.punkapi.com/");

        private String url;

        public String getUrl() {
            return url;
        }

        URL(String url) {
            this.url = url;
        }

        public RetrofitService getRetroService() {
            Retrofit.Builder retrofit = new Retrofit.Builder()
                    // 테스트 URL을 설정한다.
                    .baseUrl(getUrl())
                    .addConverterFactory(ScalarsConverterFactory.create())
                    // 컨버팅은 Gson으로 해서 받는다.
                    .addConverterFactory(GsonConverterFactory.create())
                    // OkHttp로 클라이언트를 설정한다.
                    .client(new OkHttpClient());
            // RetrofitService 인터페이스에서 함수를 받아오겠다고 선언한다.
            return retrofit.build().create(RetrofitService.class);
        }

        /**
         * 레트로핏 서비스 요청에 사용되는 인터페이스 생성
         */
        public interface RetrofitService {
            @Headers("Content-Type: application/json")
            @GET("v2/beers")
            Call<String> beerData(@Query("page") int page);

            @Headers("Content-Type: application/json")
            @GET("v2/beers")
            Call<String> filterStringBeerData(@QueryMap Map<String,String> filter);
            @Headers("Content-Type: application/json")
            @GET("v2/beers")
            Call<String> filterDoubleBeerData(@QueryMap Map<String,Integer> filter);
        }
    }
}
