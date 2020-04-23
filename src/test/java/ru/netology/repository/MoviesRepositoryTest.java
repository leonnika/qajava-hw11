package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movies;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MoviesRepositoryTest {
    private MoviesRepository repository = new MoviesRepository();
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

    @BeforeEach
    void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        repository.save(sixth);
        repository.save(seventh);
        repository.save(eighth);
        repository.save(ninth);
        repository.save(tenth);
        repository.save(eleventh);
    }

    @Test
    void shouldFindAll() {
        Movies[] actual = repository.findAll();
        Movies[] expected = new Movies[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldfindById() {
        Movies actual = repository.findById(2);
        Movies expected = second;
        assertEquals(expected, actual);
    }

    @Test
    void shouldfindByIdNull() {
        Movies actual = repository.findById(21);
        Movies expected = null;
        assertEquals(expected, actual);
    }

    @Test
    void shouldSave() {
        Movies twelfth = new Movies(12, "Тигры", "документальный", "06.04.2020");
        repository.save(twelfth);
        Movies[] actual = repository.findAll();
        Movies[] expected = new Movies[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth,eleventh,twelfth};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldremoveById() {
        repository.removeById(11);
        Movies[] actual = repository.findAll();
        Movies[] expected = new Movies[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveAll() {
        repository.removeAll();
        Movies[] actual = repository.findAll();
        Movies[] expected = new Movies[11];
        assertArrayEquals(expected, actual);
    }
}