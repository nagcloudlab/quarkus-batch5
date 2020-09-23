package org.acme.quarkus.sample;

import io.quarkus.test.junit.NativeImageTest;

@NativeImageTest
public class NativeVillainResourceIT extends VillainResourceTest {

    // Execute the same tests but in native mode.
}