package demoQA.models;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public final class M_PracticeForm {
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String mobile;
}


