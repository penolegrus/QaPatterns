package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserModel {
    private String username;
    private String password;
    private Integer age;
    private Boolean isMarried;
    private Double salary;
}
