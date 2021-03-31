package org.acme.rest.json;

import io.quarkus.test.junit.NativeImageTest;

@NativeImageTest
public class NativePersonsResourceIT extends PersonsResourceTest {

    // Execute the same tests but in native mode.
}