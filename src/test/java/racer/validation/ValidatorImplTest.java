package racer.validation;

import com.loctionov.racer.validation.Validator;
import com.loctionov.racer.validation.ValidatorImpl;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ValidatorImplTest {
    private final Validator<String> validator = new ValidatorImpl();

    @Test
    void validationFilePathShouldBeThrownIllegalArgumentExceptionIfIfPathOfFileNull() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
                () -> validator.validationFilePath(null, "Path of start.log is not corrected!" ));

        assertThat("Path of start.log is not corrected!", is(thrown.getMessage()));
    }

    @Test
    void validationFilePathShouldBeThrownIllegalArgumentExceptionIfIfPathOfFileIsEmpty() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
                () -> validator.validationFilePath("", "Path of start.log is not corrected!"));

        assertThat("Path of start.log is not corrected!", is(thrown.getMessage()));
    }

    @Test
    void validationFilePathShouldBeThrownIllegalArgumentExceptionIfPathOfFileNotExist() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
                () -> validator.validationFilePath("pathnotexist.txt", "Path of start.log is not corrected!"));

        assertThat("Path of start.log is not corrected!", is(thrown.getMessage()));
    }

    @Test
    void validationFilePathDoesNotShouldBeThrownWhenFilePathsIsExist() {
        assertDoesNotThrow(() -> {
            validator.validationFilePath("files/start.log", "Path of start.log is not corrected!");
        });
    }
}
