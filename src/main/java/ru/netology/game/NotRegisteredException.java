package ru.netology.game;
public class NotRegisteredException extends RuntimeException{
    public NotRegisteredException(String name){
        super("Игрок с таким именем " + name + " не зарегистрирован");
    }
}
