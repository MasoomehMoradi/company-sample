package gateway;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * @author masoumeh moradi on 7/26/2020
 * Email: masoom.moradi2000@gmail.com
 */

@SpringBootApplication
@EnableZuulProxy
public class Gatewayapplication {
    public static void main(String[] args) {
        SpringApplication.run(Gatewayapplication.class, args);
    }

//     @Bean
//    public PreFilter preFilter() {
//        return new PreFilter();
//    }
//
//    @Bean
//    public PostFilter postFilter() {
//        return new PostFilter();
//    }
//
//    @Bean
//    public ErrorFilter errorFilter() {
//        return new ErrorFilter();
//    }
//
//    @Bean
//    public RouteFilter routeFilter() {
//        return new RouteFilter();
//    }

}
