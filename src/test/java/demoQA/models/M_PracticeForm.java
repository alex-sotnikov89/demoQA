package demoQA.models;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public final class M_PracticeForm {
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String mobile;
    private LocalDate dateOfBirth;
    private String[] subjects;
    private String[] hobbies;
    private String currentAddress;
    private String state;
    private String city;
}


