package br.com.alura.forum.config.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.context.MessageSource;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ErrorValidationHandlerTests {

    @Mock
    private MessageSource messageSource;

    @InjectMocks
    private ErrorValidationHandler errorValidationHandler;

    /**
     * NOT NECESSARY. It would be if I wasn't using @Mock and @InjectMocks
     */
    @BeforeEach
    void setup(){
        messageSource = mock(MessageSource.class);
        errorValidationHandler = new ErrorValidationHandler();
        errorValidationHandler.setMessageSource(messageSource);
    }

    @Test
    void shouldReturnListOfFormErrorDto_whenValidationFails() {
        // Arrange
        FieldError fieldError1 = new FieldError("objectName", "field1", "defaultMessage");
        FieldError fieldError2 = new FieldError("objectName", "field2", "defaultMessage");

        BindingResult bindingResult = mock(BindingResult.class);
        when(bindingResult.getFieldErrors()).thenReturn(Arrays.asList(fieldError1, fieldError2));

        MethodArgumentNotValidException exception = mock(MethodArgumentNotValidException.class);
        when(exception.getBindingResult()).thenReturn(bindingResult);

        when(messageSource.getMessage(eq(fieldError1), any())).thenReturn("translated message 1");
        when(messageSource.getMessage(eq(fieldError2), any())).thenReturn("translated message 2");

        // Act
        List<FormErrorDto> result = errorValidationHandler.Handler(exception);

        // Assert
        assertEquals(2, result.size());
        assertEquals("field1", result.get(0).getField());
        assertEquals("translated message 1", result.get(0).getError());

        assertEquals("field2", result.get(1).getField());
        assertEquals("translated message 2", result.get(1).getError());
    }
}
