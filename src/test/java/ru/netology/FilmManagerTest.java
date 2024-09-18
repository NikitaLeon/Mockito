package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FilmManagerTest {

    @Test
    public void addFilms() {
        FilmManager manager = new FilmManager();

        manager.addFilm("Бладшот");
        manager.addFilm("Вперёд");
        manager.addFilm("Отель 'Белград'");

        String[] expected = {"Бладшот", "Вперёд", "Отель 'Белград'"};
        String[] actual = manager.findAllFilms();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void lastFilm() {
        FilmManager manager = new FilmManager();

        manager.addFilm("Бладшот");
        manager.addFilm("Вперёд");
        manager.addFilm("Отель 'Белград'");

        String[] expected = {"Отель 'Белград'", "Вперёд", "Бладшот"};
        String[] actual = manager.findLastFilms();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void lessLimit() {
        FilmManager manager = new FilmManager(5);

        manager.addFilm("Бладшот");
        manager.addFilm("Вперёд");
        manager.addFilm("Отель 'Белград'");
        manager.addFilm("Джентльмены");

        String[] expected = {"Джентльмены", "Отель 'Белград'", "Вперёд", "Бладшот"};
        String[] actual = manager.findLastFilms();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void limit() {
        FilmManager manager = new FilmManager(5);

        manager.addFilm("Бладшот");
        manager.addFilm("Вперёд");
        manager.addFilm("Отель 'Белград'");
        manager.addFilm("Джентльмены");
        manager.addFilm("Человек-невидимка");

        String[] expected = {"Человек-невидимка", "Джентльмены", "Отель 'Белград'", "Вперёд", "Бладшот"};
        String[] actual = manager.findLastFilms();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void moreLimit() {
        FilmManager manager = new FilmManager(5);

        manager.addFilm("Бладшот");
        manager.addFilm("Вперёд");
        manager.addFilm("Отель 'Белград'");
        manager.addFilm("Джентльмены");
        manager.addFilm("Человек-невидимка");
        manager.addFilm("Тролли.Мировой тур");

        String[] expected = {"Тролли.Мировой тур", "Человек-невидимка", "Джентльмены", "Отель 'Белград'", "Вперёд"};
        String[] actual = manager.findLastFilms();
        Assertions.assertArrayEquals(expected, actual);
    }
}
