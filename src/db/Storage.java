package db;

import entity.User;

import java.util.HashSet;
import java.util.Set;

public interface Storage {
    Set<User> users = new HashSet<>();
}
