package demo;

import demo.servicea.ServiceA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xuebj on 2017/3/6.
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@RestController
public class ServerBApplication {

    @Autowired
    private ServiceA serviceA;

    @RequestMapping("/add")
    public String add(@RequestParam Integer a, @RequestParam Integer b){
        return  "From Service-B-0, Result is " + serviceA.add(a,b);
    }
    public static void main(String[] args) {
        new SpringApplicationBuilder(ServerBApplication.class).web(true).run(args);
    }
}
