import entity.User;
import entity.enums.Role;
import service.AuthService;

import static db.DataSource.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        AuthService.service();
    }
}