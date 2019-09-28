package ru.job4j.added;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ProFilterTest {

    @Test
    public void makeMagic() {
        var data = new int[]{1, 2, 3, 10};
        assertThat(ProFilter.makeMagic(data), is(104));
    }
}