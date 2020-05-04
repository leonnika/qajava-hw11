package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movies;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MoviesManagerNotFullAfishaTest {

    private Movies first = new Movies(1, "Бладшоп", "боевик", "01.04.2020");
    private Movies second = new Movies(2, "Вперед", "мультфильм", "02.04.2020");
    private Movies third = new Movies(3, "Отель Белград", "комедия", "04.04.2020");
    private Movies fourth = new Movies(4, "Джентльмены", "боевик", "04.04.2020");
    private Movies fifth = new Movies(5, "Человек-невидмка", "ужасы", "01.04.2020");

    void setUp(MoviesManager managerSetup) {
        managerSetup.addMovies(first);
        managerSetup.addMovies(second);
        managerSetup.addMovies(third);
        managerSetup.addMovies(fourth);
        managerSetup.addMovies(fifth);
    }

    @Test
    void shouldGeDefaulttMoviesNotFullAfisha() {
        MoviesManager manager = new MoviesManager(0);
        setUp(manager);
        Movies[] actual = manager.getLastMovies();
        Movies[] expected = new Movies[]{fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetNumberMoviesNotFullAfisha() {
        MoviesManager manager = new MoviesManager(1);
        setUp(manager);
        Movies[] actual = manager.getLastMovies();
        Movies[] expected = new Movies[]{fifth};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGeMoviesNumberUnder0NotFullAfisha() {
        MoviesManager manager = new MoviesManager(-3);
        setUp(manager);
        Movies[] actual = manager.getLastMovies();
        Movies[] expected = new Movies[]{fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetMovieNumberOverMaxNotFullAfisha() {
        MoviesManager manager = new MoviesManager(100);
        setUp(manager);
        Movies[] actual = manager.getLastMovies();
        Movies[] expected = new Movies[]{fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetMovieNumberOverAvailableNotFullAfisha() {
        MoviesManager manager = new MoviesManager(7);
        setUp(manager);
        Movies[] actual = manager.getLastMovies();
        Movies[] expected = new Movies[]{fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }
}