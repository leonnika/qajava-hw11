package ru.netology.manager;

import ru.netology.domain.Movies;
import ru.netology.repository.MoviesRepository;

public class MoviesManager {
    private int numberMovies = 10;
    private MoviesRepository repository;

    public MoviesManager(MoviesRepository repository, int numberMovies) {
        this.repository = repository;
        this.numberMovies = numberMovies;
    }

    public MoviesManager(MoviesRepository repository) {
        this.repository = repository;
    }

    public MoviesManager(int numberMovies) {
        this.numberMovies = numberMovies;
    }

    public MoviesManager() {
    }

    public void AddMovies(Movies movie) {
        repository.save(movie);

    }

    public Movies[] getLastMovies() {
        Movies[] movies = repository.findAll();
        // определяем количество фильмов которые выводим в афише
        if (movies.length < numberMovies) {
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