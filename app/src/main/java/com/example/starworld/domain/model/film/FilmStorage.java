package com.example.starworld.domain.model.film;

import com.example.starworld.data.RetrofitBuilder;
import com.example.starworld.domain.model.film.Films;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmStorage {

    public static void getFilmGyId(Result result) {
        RetrofitBuilder.getInstance().getFilms().enqueue(new Callback<Films>() {
            @Override
            public void onResponse(Call<Films> call, Response<Films> response) {
                if (response.isSuccessful() && response.body() != null) {
                    result.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<Films> call, Throwable t) {
                result.onFailure(t);
            }
        });

    }

    public interface Result {
        void onSuccess(Films films);

        void onFailure(Throwable throwable);
    }
}
