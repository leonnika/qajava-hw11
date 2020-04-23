package ru.netology.repository;

import ru.netology.domain.Movies;

public class MoviesRepository {
    private Movies[] movie = new Movies[0];

    // возвращает массив всех хранящихся в массиве объектов
    public Movies[] findAll() {
        return movie;
    }

    //возвращает объект по идентификатору (либо null, если такого объекта нет)
    public Movies findById(int id) {
        int index = 0;
        for (Movies item : movie) {
           if (item.getId() == id) {
                return item;
           }
           index++;
       }
        return null;
    }

    //добавляет объект в массив
    public void save(Movies movies) {
        int length = movie.length + 1;
        Movies[] tmp = new Movies[length];
        System.arraycopy(movie, 0, tmp, 0, movie.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movies;
        movie = tmp;
    }

    // удаляет объект по идентификатору (если объекта нет, то исключение)
    public void removeById(int id) {
        int length = movie.length - 1;
        Movies[] tmp = new Movies[length];
        int index = 0;
        for (Movies item : movie) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        } // меняем наши элементы items = tmp;
        movie = tmp;
    }

    //полностью вычищает репозиторий
    public void removeAll() {
        Movies[] tmp = new Movies[movie.length];
        System.arraycopy(tmp, 0, movie, 0, movie.length);
        movie = tmp;

    }
}
