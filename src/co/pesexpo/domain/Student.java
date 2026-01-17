package co.pesexpo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private Integer id;

    private String firstName;

    private String lastName;

    private Integer age;

    private String grade;
}
