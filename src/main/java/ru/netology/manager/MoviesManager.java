package ru.netology.manager;

import ru.netology.domain.Movies;
import ru.netology.repository.MoviesRepository;

public class MoviesManager {
    private int maxMovies = 10;
    private int numberMovies;
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

    public void addMovies(Movies movie) {
        repository.save(movie);
    }

    public Movies[] getLastMovies() {
        Movies[] movies = repository.findAll();
        // определяем количество фильмов которые выводим в афише
        //если пользователь запрашивает отрицательное кол-во фильмом, то метод ничего не возвращает
        if (numberMovies < 0) {
            return null;
        }
        //если вызов метода без указания кол-ва фильмов, или с указанием 0(в этих двух случаях параметр numberMovies=0),
        // то возвращается кол-во фильмов по умолчанию, если фильмов более 10 и все что есть, если фильмов менее 10
        if (numberMovies == 0) {
            if (movies.length >= maxMovies) {
                numberMovies = maxMovies;
            }
            if (movies.length < maxMovies) {
                numberMovies = movies.length;
            }
        }
        //если пользователь запрашивает более максимум фильмов,
        // то метод показывает максимум(10) фильмов, если в афише более максимум(10) фильмов
        // и все что есть, при количестве фильмов менее максимум (10)
        if (numberMovies > maxMovies) {
            if (movies.length < maxMovies) {
                numberMovies = movies.length;
            }
            if (movies.length >= maxMovies) {
                numberMovies = maxMovies;
            }
        }
        //если пользователь запрашивает менее 10 фильмов и количество фильмов меньше запрашиваемых,
        // то возвращается все, что есть
        if ((numberMovies < maxMovies) && (movies.length <= numberMovies)) {
            numberMovies = movies.length;
        }
        //в остальных случаях возвращается запрашиваемое кол-во фильмов
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