package demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xuebj on 2017/3/6.
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
public class ServerAApplication {

    @RequestMapping("/add")
    public String add(@RequestParam Integer a, @RequestParam Integer b){
        Integer r = a + b;
        return  "From Service-A-0, Result is " + r;
    }
    public static void main(String[] args) {
        new SpringApplicationBuilder(ServerAApplication.class).web(true).run(args);
    }
}
