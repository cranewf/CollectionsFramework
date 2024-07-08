package ru.netology.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {
    Player p1 = new Player(1, "Slava", 70);
    Player p2 = new Player(2, "Vadya", 95);
    Player p3 = new Player(3, "Olya", 50);
    Player p4 = new Player(4, "Masha", 50);
    Player p5 = new Player(5, "Leha", 98);
    Player p6 = new Player(6, "Sanya", 74);

    Game game = new Game();


    @Test
    public void registredPlayer() {
        game.register(p1);
        game.register(p2);
        game.register(p3);
        game.register(p4);
        game.register(p5);
        game.register(p6);

        Player[] expected = {p1, p2, p3, p4, p5, p6};
        Player[] actual = {game.register(p1), game.register(p2), game.register(p3), game.register(p4), game.register(p5), game.register(p6)};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldWinSecoundPlayer() {
        game.register(p1);
        game.register(p2);

        Assertions.assertEquals(2, game.round("Slava", "Vadya"));

    }

    @Test
    public void shouldWinFirstPlayer() {
        game.register(p5);
        game.register(p6);

        Assertions.assertEquals(1, game.round("Leha", "Sanya"));
    }

    @Test
    public void shouldDraw() {
        game.register(p3);
        game.register(p4);

        Assertions.assertEquals(0, game.round("Olya", "Masha"));
    }

    @Test
    public void shouldNotRegisteredSecoundPlayer() {
        game.register(p4);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Masha", "Vova"));
    }

    @Test
    public void shouldNotRegisteredFirstPlayer() {
        game.register(p6);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Maksim", "Sanya"));
    }


}