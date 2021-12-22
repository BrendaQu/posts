package com.revature.project3;

import com.revature.project3.repositories.ReactionsRepository;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile("test")
@Configuration
public class ReactionRepositoryTestConfiguration {
    @Bean
    @Primary
    public ReactionsRepository reactionsRepository(){
        return Mockito.mock(ReactionsRepository.class);
    }
}
