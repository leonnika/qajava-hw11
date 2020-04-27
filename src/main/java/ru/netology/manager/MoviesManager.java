package ru.netology.manager;

import ru.netology.domain.Movies;

public class MoviesManager {
    private Movies[] movies = new Movies[0];

    public MoviesManager() {
    }

    public void AddMovies(Movies movie) {
        int length = movies.length + 1;
        Movies[] tmp = new Movies[length];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public Movies[] getAllMovies() {

// создаём массив для хранения результатов
        Movies[] result = new Movies[movies.length];
// перебираем массив в прямом порядке
// но кладём в результаты в обратном
        for (int i = 0; i < movies.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }


}