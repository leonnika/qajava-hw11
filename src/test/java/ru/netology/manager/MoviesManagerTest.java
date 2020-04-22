package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movies;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MoviesManagerTest {
    private MoviesManager manager;
    private Movies first;
    private Movies second;
    private Movies third;
    private Movies fourth;
    private Movies fifth;
    private Movies sixth;
    private Movies seventh;
    private Movies eighth;
    private Movies ninth;
    private Movies tenth;
    private Movies eleventh;

    @BeforeEach
    void setUp() {
        first = new Movies(1, "Бладшоп", "боевик", "01.04.2020");
        second = new Movies(2, "Вперед", "мультфильм", "02.04.2020");
        third = new Movies(3, "Отель Белград", "комедия", "04.04.2020");
        fourth = new Movies(4, "Джентльмены", "боевик", "04.04.2020");
        fifth = new Movies(5, "Человек-невидмка", "ужасы", "01.04.2020");
        sixth = new Movies(6, "Тролли.Мировой тур", "мультфильм", "05.04.2020");
        seventh = new Movies(7, "Мульт в кино", "мультфильмы", "05.04.2020");
        eighth = new Movies(8, "Жили были", "комедия", "04.04.2020");
        ninth = new Movies(9, "Один день", "боевик", "03.04.2020");
        tenth = new Movies(10, "История легенды", "исторический", "01.04.2020");
        eleventh = new Movies(11, "Пингвины", "документальный", "06.04.2020");
    }

    @Test
    void shouldGetLastMoviesOverNumberFullAfisha() {
        MoviesManager manager = new MoviesManager();
        manager.AddMovies(first);
        manager.AddMovies(second);
        manager.AddMovies(third);
        manager.AddMovies(fourth);
        manager.AddMovies(fifth);
        manager.AddMovies(sixth);
        manager.AddMovies(seventh);
        manager.AddMovies(eighth);
        manager.AddMovies(ninth);
        manager.AddMovies(tenth);
        manager.AddMovies(eleventh);
        Movies[] actual = manager.getLastMovies();
        Movies[] expected = new Movies[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetLastMoviesIsNumberFullAfisha() {
        MoviesManager manager = new MoviesManager(3);
        manager.AddMovies(first);
        manager.AddMovies(second);
        manager.AddMovies(third);
        manager.AddMovies(fourth);
        manager.AddMovies(fifth);
        manager.AddMovies(sixth);
        manager.AddMovies(seventh);
        manager.AddMovies(eighth);
        manager.AddMovies(ninth);
        manager.AddMovies(tenth);
        manager.AddMovies(eleventh);
        Movies[] actual = manager.getLastMovies();
        Movies[] expected = new Movies[]{eleventh, tenth, ninth};
        assertArrayEquals(expected, actual);
    }
}