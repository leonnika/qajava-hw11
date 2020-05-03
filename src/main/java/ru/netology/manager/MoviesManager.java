package ru.netology.manager;

import ru.netology.domain.Movies;

public class MoviesManager {
    private Movies[] movies = new Movies[0];
    private int numberMovies;
    private int maxMovies = 10;

    public MoviesManager(int numberMovies) {
        this.numberMovies = numberMovies;
    }

    public MoviesManager() {
    }

    public void addMovies(Movies movie) {
        int length = movies.length + 1;
        Movies[] tmp = new Movies[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public Movies[] getLastMovies() {
// определяем количество фильмов которые выводим в афише

        //если пользователь запрашивает отрицательное кол-во фильмом, то метод ничего не возвращает
        if (numberMovies < 0) {
            return null;
        }
        //если вызов метода без указания кол-ва фильмов, или с указанием 0(в этих двух случаях параметр numberMovies=0), то возвращается кол-во фильмов по умолчанию
        if (numberMovies == 0) {
            if (movies.length >= maxMovies) {
                numberMovies = maxMovies;
            }
            if (movies.length < maxMovies) {
                numberMovies = movies.length;
            }
        }
        if (numberMovies > maxMovies) {
            if (movies.length < maxMovies) {
                numberMovies = movies.length;
            }
            if (movies.length >= maxMovies) {
                numberMovies = maxMovies;
            }
        }
        if ((numberMovies < maxMovies) && (movies.length <= numberMovies)) {
            numberMovies = movies.length;
        }

// создаём массив для хранения результатов
        Movies[] result = new Movies[numberMovies];
// перебираем массив в прямом порядке
// но кладём в результаты в обратном
        for (int i = 0; i < numberMovies; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }

}