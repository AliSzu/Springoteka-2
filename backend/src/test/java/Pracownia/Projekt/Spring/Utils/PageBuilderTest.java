package Pracownia.Projekt.Spring.Utils;

import org.junit.jupiter.api.Test;
import org.springframework.data.domain.PageRequest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PageBuilderTest {

    @Test
    void shouldReturnFirstPageWhenProvidedPageNumberIsNegative() {
        PageRequest pageRequestWithNegative = PageBuilder.buildPageRequest(-20, 2);
        assertThat(pageRequestWithNegative.getPageNumber()).isEqualTo(0);
    }

    @Test
    void shouldReturnFirstPageWhenProvidedPageNumberIsNull() {
        PageRequest pageRequestWithNull = PageBuilder.buildPageRequest(null, 22);
        assertThat(pageRequestWithNull.getPageNumber()).isEqualTo(0);
    }
}