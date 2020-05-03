
package ru.netology.manager;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Movies;
import ru.netology.repository.MoviesRepository;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
        // расширение для JUnit
class MoviesManagerNumberUnder0Test {
    @Mock  // подставляет заглушку вместо реальной реализации
    private MoviesRepository repository;
    private int number = -4;
    @InjectMocks  // подставляет заглушку в конструктор
    private MoviesManager manager = new MoviesManager(repository, number);
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
        manager.addMovies(first);
        manager.addMovies(second);
        manager.addMovies(third);
        manager.addMovies(fourth);
        manager.addMovies(fifth);
        manager.addMovies(sixth);
        manager.addMovies(seventh);
        manager.addMovies(eighth);
        manager.addMovies(ninth);
        manager.addMovies(tenth);
        manager.addMovies(eleventh);
    }

    @Test
    void shouldLastMoviesNumberUnder0FullAfisha() {
// настройка заглушки
        Movies[] returned = new Movies[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh};
        doReturn(returned).when(repository).findAll();
        assertNull(manager.getLastMovies());
        verify(repository).findAll();
    }

    @Test
    void shouldGetMoviesNumberUnder0NoFullAfisha() {
// настройка заглушки
        Movies[] returned = new Movies[]{first, second, third};
        doReturn(returned).when(repository).findAll();
        assertNull(manager.getLastMovies());
        verify(repository).findAll();
    }
}


