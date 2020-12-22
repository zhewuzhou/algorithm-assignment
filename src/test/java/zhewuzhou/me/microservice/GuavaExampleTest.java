package zhewuzhou.me.microservice;

import com.google.common.util.concurrent.RateLimiter;
import org.junit.Test;

import java.time.ZonedDateTime;
import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class GuavaExampleTest {
    @Test
    public void givenLimitedResourceWhenRequestOnceThenShouldPermitWithoutBlocking() throws InterruptedException {
        // given
        RateLimiter rateLimiter = RateLimiter.create(100);

        // when
        long startTime = ZonedDateTime.now().getSecond();
        rateLimiter.acquire(100);
        doSomeLimitedOperation();
        long elapsedTimeSeconds = ZonedDateTime.now().getSecond() - startTime;

        // then
        assertThat(elapsedTimeSeconds <= 1, is(true));
    }

    @Test
    public void givenLimitedResourceWhenUseRateLimiterThenShouldLimitPermits() {
        // given
        RateLimiter rateLimiter = RateLimiter.create(100);

        // when
        long startTime = ZonedDateTime.now().getSecond();
        IntStream.range(0, 1000).forEach(i -> {
            rateLimiter.acquire();
            try {
                doSomeLimitedOperation();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        long elapsedTimeSeconds = ZonedDateTime.now().getSecond() - startTime;

        // then
        assertThat(elapsedTimeSeconds >= 10, is(true));
    }

    private void doSomeLimitedOperation() throws InterruptedException {
        Thread.sleep(10);
        System.out.println("This is the place do something");
    }

}