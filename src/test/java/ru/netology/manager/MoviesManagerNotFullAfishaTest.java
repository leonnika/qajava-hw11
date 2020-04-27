package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movies;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MoviesManagerNotFullAfishaTest {

    private MoviesManager manager;
    private Movies first;
    private Movies second;
    private Movies third;
    private Movies fourth;
    private Movies fifth;

    @BeforeEach
    void setUp() {
        first = new Movies(1, "Бладшоп", "боевик", "01.04.2020");
        second = new Movies(2, "Вперед", "мультфильм", "02.04.2020");
        third = new Movies(3, "Отель Белград", "комедия", "04.04.2020");
        fourth = new Movies(4, "Джентльмены", "боевик", "04.04.2020");
        fifth = new Movies(5, "Человек-невидмка", "ужасы", "01.04.2020");
    }

    @Test
    void shouldGetLastMoviesNotFullAfisha() {
        MoviesManager manager = new MoviesManager();
        manager.AddMovies(first);
        manager.AddMovies(second);
        manager.AddMovies(third);
        manager.AddMovies(fourth);
        manager.AddMovies(fifth);
        Movies[] actual = manager.getLastMovies();
        Movies[] expected = new Movies[]{fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetLastMoviesIsNumberNotFullAfisha() {
        MoviesManager manager = new MoviesManager(2);
        manager.AddMovies(first);
        manager.AddMovies(second);
        manager.AddMovies(third);
        manager.AddMovies(fourth);
        manager.AddMovies(fifth);
        Movies[] actual = manager.getLastMovies();
        Movies[] expected = new Movies[]{fifth, fourth};
        assertArrayEquals(expected, actual);
    }
}