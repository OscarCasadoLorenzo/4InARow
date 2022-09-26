package com.bosonit.Secundario.configuration;

import com.bosonit.Secundario.infrastructure.repository.PartidaRepository;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.r2dbc.connection.init.CompositeDatabasePopulator;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;

public class ServiceConfiguration {
    @Bean
    public ConnectionFactoryInitializer initialize(ConnectionFactory factory) {
        var initializer = new ConnectionFactoryInitializer();
        initializer.setConnectionFactory(factory);
        var populator = new CompositeDatabasePopulator();
        populator.addPopulators(
                new ResourceDatabasePopulator(new ClassPathResource("/schema.sql")),
                new ResourceDatabasePopulator(new ClassPathResource("/data.sql"))
        );
        initializer.setDatabasePopulator(populator);
        return initializer;
    }

//    @Bean
//    public PartidaService service(PartidaRepository repository) {
//        return new PartidaService(repository);
//    }
//
//    @Bean
//    public PartidaHandler handler(PartidaService service) {
//        return new PartidaHandler(service);
//    }
}
