package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movies;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class MoviesManagerNotFullAfishaTest {

    private MoviesManager manager;
    private Movies first= new Movies(1, "Бладшоп", "боевик", "01.04.2020");
    private Movies second= new Movies(2, "Вперед", "мультфильм", "02.04.2020");
    private Movies third= new Movies(3, "Отель Белград", "комедия", "04.04.2020");
    private Movies fourth = new Movies(4, "Джентльмены", "боевик", "04.04.2020");
    private Movies fifth= new Movies(5, "Человек-невидмка", "ужасы", "01.04.2020");

    @BeforeEach
    void setUp() {


    }

    @Test
    void shouldGeDefaulttMoviesNotFullAfisha() {
        MoviesManager manager = new MoviesManager(0);
        manager.addMovies(first);
        manager.addMovies(second);
        manager.addMovies(third);
        manager.addMovies(fourth);
        manager.addMovies(fifth);
        Movies[] actual = manager.getLastMovies();
        Movies[] expected = new Movies[]{fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetNumberMoviesNotFullAfisha() {
        MoviesManager manager = new MoviesManager(1);
        manager.addMovies(first);
        manager.addMovies(second);
        manager.addMovies(third);
        manager.addMovies(fourth);
        manager.addMovies(fifth);
        Movies[] actual = manager.getLastMovies();
        Movies[] expected = new Movies[]{fifth};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGeMoviesNumberUnder0NotFullAfisha() {
        MoviesManager manager = new MoviesManager(-3);
        Movies[] actual = manager.getLastMovies();
        assertNull(actual);
    }

    @Test
    void shouldGetMovieNumberOverMaxNotFullAfisha() {
        MoviesManager manager = new MoviesManager(100);
        manager.addMovies(first);
        manager.addMovies(second);
        manager.addMovies(third);
        manager.addMovies(fourth);
        manager.addMovies(fifth);
        Movies[] actual = manager.getLastMovies();
        Movies[] expected = new Movies[]{fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetMovieNumberOverAvailableNotFullAfisha() {
        MoviesManager manager = new MoviesManager(7);
        manager.addMovies(first);
        manager.addMovies(second);
        manager.addMovies(third);
        manager.addMovies(fourth);
        manager.addMovies(fifth);
        Movies[] actual = manager.getLastMovies();
        Movies[] expected = new Movies[]{fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }
          }