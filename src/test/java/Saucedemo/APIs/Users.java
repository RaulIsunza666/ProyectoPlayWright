package Saucedemo.APIs;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class Users {
    private int id;
    private String name;
    @SerializedName("username")
    private String userName;
    private String email;
}