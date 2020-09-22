package org.acme.quarkus.sample;

import io.quarkus.test.junit.NativeImageTest;

@NativeImageTest
public class NativeHeroResourceIT extends HeroResourceTest {

    // Execute the same tests but in native mode.
}