package com.home.infopolustask.util;

import com.home.infopolustask.dto.ContactDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UtilsTest {

    @Test
    public void testCheckNotNullPassesNotNulls() {
        var notNullObject = ContactDTO.builder().id(1).build();
        assertDoesNotThrow(() -> Utils.checkNotNull(notNullObject, "notNullObject"));
    }

    @Test
    public void testCheckNotNullThrowsOnNull() {
        var npe = assertThrows(
                NullPointerException.class, () -> Utils.checkNotNull(null, "nullObject"));
        assertEquals(npe.getMessage(), "nullObject should not be null");
    }
}
