package Saucedemo.APIs;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CrearPosts {
    private int userId;
    private int id;
    private String title;
    private String body;
}
