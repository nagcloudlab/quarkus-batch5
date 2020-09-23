package org.acme.quarkus.sample;

import io.quarkus.test.junit.NativeImageTest;

@NativeImageTest
public class NativeFightResourceIT extends FightResourceTest {

    // Execute the same tests but in native mode.
}