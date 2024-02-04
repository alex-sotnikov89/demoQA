package demoQA.parameters;

import demoQA.models.M_PracticeForm;

import java.time.LocalDate;
import java.util.stream.Stream;

public class PracticeFormParam {
    static Stream<M_PracticeForm> fillPositiveArguments() {
        return Stream.of(
                M_PracticeForm.builder()
                        .firstName("Nina")
                        .lastName("Losa")
                        .gender("Female")
                        .email("Losa@ehoo.en")
                        .mobile("9011234567")
                        .dateOfBirth(LocalDate.of(1990, 3, 15))
                        .build(),
                M_PracticeForm.builder()
                        .firstName("Masha")
                        .lastName("Night")
                        .email("night_masha@r.com")
                        .gender("Female")
                        .mobile("8901123456")
                        .dateOfBirth(LocalDate.of(2020, 9, 2))
                        .subjects(new String[]{"Maths", "Physics"})
                        .hobbies(new String[]{"Reading", "Music"})
                        .currentAddress("Red square st., 11, 100")
                        .state("Haryana").city("Karnal")
                        .build());
    }
    static Stream<M_PracticeForm> fillNegativeArguments(){
        return Stream.of(
                M_PracticeForm.builder()
                        .firstName("Neg")
                        .build());
    }
}
