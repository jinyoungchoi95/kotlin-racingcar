package racingcar.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource

class CarNameTest {

    @Test
    fun `자동차의 이름이 5자를 초과할 경우 예외가 발생한다`() {
        val exception = shouldThrowExactly<IllegalArgumentException> { CarName(value = "123456") }
        exception.message shouldBe "자동차의 이름을 5 자를 초과할 수 없다"
    }

    @ParameterizedTest
    @EmptySource
    fun `자동차의 이름은 공백이 들어올 경우 예외가 발생한다`(input: String) {
        val exception = shouldThrowExactly<IllegalArgumentException> { CarName(value = input) }
        exception.message shouldBe "자동차의 이름은 공백이 들어올 수 없다"
    }

    @Test
    fun `자동차의 이름을 저장한다`() {
        val actual = CarName(value = "pobi")
        actual.value shouldBe "pobi"
    }
}
