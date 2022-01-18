package models;

import lombok.*;
import org.testng.annotations.Test;

@Data
@ToString(exclude = "UUID")
public class User {
    private String email;
    private String password;
    private String UUID;
}
