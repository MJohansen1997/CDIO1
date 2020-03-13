package test.JUnitTest;

import CDIO.dto.UserDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDTOTest {
    UserDTO person;
    @BeforeEach
    void setUp() {
        person = new UserDTO(99, "Peter Peter", "PP");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getUserId() {
        int result = person.getUserId();
        int expected = 99;
        assertEquals(result, expected);
    }

    @Test
    void setUserId() {
        int result = 98;
        person.setUserId(result);
        assertEquals(result, person.getUserId());
    }

    @Test
    void getUserName() {
        String result = person.getUserName();
        String expected = "Peter Peter";
        assertEquals(result, expected);
    }

    @Test
    void setUserName() {
        String result = "Peter Hansen";
        person.setUserName(result);
        assertEquals(result, person.getUserName());
    }

    @Test
    void getIni() {
        String result = person.getIni();
        String expected = "PP";
        assertEquals(result, expected);
    }

    @Test
    void setIni() {
        String result = "Peter Hansen";
        person.setIni(result);
        assertEquals(result, person.getIni());
    }
//
//    @Test
//    void getRoles() {
//    }
//
//    @Test
//    void setRoles() {
//    }
//
//    @Test
//    void addRole() {
//    }
//
//    @Test
//    void removeRole() {
//    }

    @Test
    void getPassword() {
        String password = person.getPassword();
        assertFalse(password.isEmpty());
    }

    @Test
    void setPassword() {
        String result = "juked";
        person.setPassword(result);
        assertEquals(result, person.getPassword());
    }
}