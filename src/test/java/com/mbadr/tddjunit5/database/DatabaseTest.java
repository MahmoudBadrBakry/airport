package com.mbadr.tddjunit5.database;

import com.mbadr.tddjunit5.MockitoExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DatabaseTest {

    @Mock
    Database database;
    private final Credentials credentials = new Credentials("mbadr", "pass");

    @Test
    void testUserSuccessLogin() {
        when(database.login(credentials)).thenReturn(true);
        Credentials sameCredentials = new Credentials("mbadr", "pass");

        assertTrue(database.login(sameCredentials));
    }


    @Test
    void testUserFailedLogin() {
        when(database.login(credentials)).thenReturn(true);
        Credentials otherCredentials = new Credentials("mbadr", "pass");
        otherCredentials.setUsername("other");
        otherCredentials.setPassword("newPass");

        assertNotEquals(credentials.getUsername(), otherCredentials.getUsername());
        assertNotEquals(credentials.getPassword(), otherCredentials.getPassword());
        assertNotEquals(credentials.hashCode(), otherCredentials.hashCode());
        assertFalse(database.login(otherCredentials));
    }


}
