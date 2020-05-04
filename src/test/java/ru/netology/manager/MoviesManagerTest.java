package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movies;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MoviesManagerTest {
    private Movies first = new Movies(1, "Бладшоп", "боевик", "01.04.2020");
    private Movies second = new Movies(2, "Вперед", "мультфильм", "02.04.2020");
    private Movies third = new Movies(3, "Отель Белград", "комедия", "04.04.2020");
    private Movies fourth = new Movies(4, "Джентльмены", "боевик", "04.04.2020");
    private Movies fifth = new Movies(5, "Человек-невидмка", "ужасы", "01.04.2020");
    private Movies sixth = new Movies(6, "Тролли.Мировой тур", "мультфильм", "05.04.2020");
    private Movies seventh = new Movies(7, "Мульт в кино", "мультфильмы", "05.04.2020");
    private Movies eighth = new Movies(8, "Жили были", "комедия", "04.04.2020");
    private Movies ninth = new Movies(9, "Один день", "боевик", "03.04.2020");
    private Movies tenth = new Movies(10, "История легенды", "исторический", "01.04.2020");
    private Movies eleventh = new Movies(11, "Пингвины", "документальный", "06.04.2020");

    void setUp(MoviesManager managerSetup) {
        managerSetup.addMovies(first);
        managerSetup.addMovies(second);
        managerSetup.addMovies(third);
        managerSetup.addMovies(fourth);
        managerSetup.addMovies(fifth);
        managerSetup.addMovies(sixth);
        managerSetup.addMovies(seventh);
        managerSetup.addMovies(eighth);
        managerSetup.addMovies(ninth);
        managerSetup.addMovies(tenth);
        managerSetup.addMovies(eleventh);
    }

    @Test
    void shouldGeDefaultMoviesFullAfisha() {
        MoviesManager manager = new MoviesManager(0);
        setUp(manager);
        Movies[] actual = manager.getLastMovies();
        Movies[] expected = new Movies[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetNumberMoviesFullAfisha() {
        MoviesManager manager = new MoviesManager(3);
        setUp(manager);
        Movies[] actual = manager.getLastMovies();
        Movies[] expected = new Movies[]{eleventh, tenth, ninth};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGeMoviesNumberUnder0FullAfisha() {
        MoviesManager manager = new MoviesManager(-7);
        setUp(manager);
        Movies[] actual = manager.getLastMovies();
        Movies[] expected = new Movies[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGeMoviesNumderOverMaxFullAfisha() {
        MoviesManager manager = new MoviesManager(100);
        setUp(manager);
        Movies[] actual = manager.getLastMovies();
        Movies[] expected = new Movies[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGeMoviesTopFullAfisha() {
        MoviesManager manager = new MoviesManager(10);
        setUp(manager);
        Movies[] actual = manager.getLastMovies();
        Movies[] expected = new Movies[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGeMoviesBottomFullAfisha() {
        MoviesManager manager = new MoviesManager(1);
        setUp(manager);
        Movies[] actual = manager.getLastMovies();
        Movies[] expected = new Movies[]{eleventh};
        assertArrayEquals(expected, actual);
    }
}