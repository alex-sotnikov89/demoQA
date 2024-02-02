package demoQA.parameters;

import demoQA.models.M_PracticeForm;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.time.LocalDate;
import java.util.stream.Stream;

public class PracticeFormParam implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return Stream.of(
                Arguments.of(
                        M_PracticeForm.builder()
                                .firstName("Nina")
                                .lastName("Losa")
                                .gender("Female")
                                .email("Losa@ehoo.en")
                                .mobile("9011234567")
                                .dateOfBirth(LocalDate.of(1990, 3, 15))
                                .build()),
                Arguments.of(
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
                                .build())
        );
    }
}
