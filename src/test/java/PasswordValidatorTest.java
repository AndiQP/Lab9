import com.andi.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

public class PasswordValidatorTest {

    @Test
    public void testIsValidPassword(){

        //Arrange
        PasswordValidator pV = new PasswordValidator();

        //Act
        boolean result = pV.isValidPassword("ABCDEFG8");

        //Assert
        assertTrue(result);

    }

    @Test
    public void testNotificationOfValidPassword(){

        //Arrange: Creating the mock of NotificationService
        NotificationService mockNotifServ = mock(NotificationService.class);

        //Arrange: Inserting the mock into PasswordValidator
        PasswordValidator pV = new PasswordValidator(mockNotifServ);

        //Act: Calling isValidPassword under test
        pV.isValidPassword("1234");

        //Assert: Verify that sendNotification was called with the expected message
        verify(mockNotifServ).sendNotification("You can't use this password!");

    }
    
}
