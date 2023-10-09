package com.akirolabs.generator;

import com.akirolabs.generator.services.impl.GeneratorServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GeneratorServiceTest {
    private GeneratorServiceImpl generatorService;
    private Random random;
    @BeforeEach
    void setUp()
    {
        this.generatorService = Mockito.spy(GeneratorServiceImpl.class);
        random = Mockito.mock(Random.class);
    }

    @Test
    public void generateTokenTestWithOnlyAllowDigits() throws Exception {
        String digits = "2,3,5,7,9";
        String tokenFormat = "XXXX-XXXX-XXXX-XXXX";
        ReflectionTestUtils.setField(this.generatorService, "tokenFormat", "XXXX-XXXX-XXXX-XXXX");

        when(generatorService.getRandomObj()).thenReturn(random);
        when(random.ints(tokenFormat.replace("-","").length(), 0 , 10)).
                thenReturn(IntStream.of(3,2,5,5,7,9,3,2,5,5,2,9,7,7,9,7));

        String token = generatorService.generateToken(digits).getToken();
        assertEquals("3255-7932-5529-7797", token);
    }

    @Test
    public void generateTokenTestWithNotAllowDigits() throws Exception {
        String digits = "2,3,5,7,9";
        String tokenFormat = "XXXX-XXXX-XXXX-XXXX";
        ReflectionTestUtils.setField(this.generatorService, "tokenFormat", "XXXX-XXXX-XXXX-XXXX");

        when(generatorService.getRandomObj()).thenReturn(random);
        when(random.ints(tokenFormat.replace("-","").length(), 0 , 10)).
                thenReturn(IntStream.of(3,2,5,5,7,9,3,2,1,8,4,0,5,5,2,9,7,7,9,7));

        String token = generatorService.generateToken(digits).getToken();
        assertEquals("3255-7932-5529-7797", token);
    }
}
