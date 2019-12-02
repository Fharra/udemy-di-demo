package guru.springframework.conf;

import guru.springframework.examplebeans.FakeDataSource;
import guru.springframework.examplebeans.OtherFakeDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource({"classpath:otherdatasource.properties", "classpath:datasource.properties"})
public class PropertyConfig {

    @Autowired
    Environment environment;

    @Value("${guru.user}")
    String user;
    @Value("${guru.password}")
    String password;
    @Value("${guru.url}")
    String url;

    @Value("${guru.oth.user}")
    String userOther;
    @Value("${guru.oth.password}")
    String passwordOther;
    @Value("${guru.oth.url}")
    String urlOther;

    @Bean
    public FakeDataSource fakeDataSource(){
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUser(environment.getProperty("USERNAME"));
        fakeDataSource.setPassword(password);
        fakeDataSource.setUrl(url);
        return fakeDataSource;
    }

    @Bean
    public OtherFakeDataSource otherFakeDataSource(){
        OtherFakeDataSource fakeDataSource = new OtherFakeDataSource();
        fakeDataSource.setUserOther(userOther);
        fakeDataSource.setUserOther(userOther);
        fakeDataSource.setPasswordOther(passwordOther);
        fakeDataSource.setUrlOther(urlOther);
        return fakeDataSource;
    }


    @Bean
    public static PropertySourcesPlaceholderConfigurer properties(){
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        return propertySourcesPlaceholderConfigurer;
    }
}
