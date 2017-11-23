import com.qq.service.HelloService;
import com.qq.service.HelloServiceService;

public class App {
    public static void main(String[] args) {
        HelloService helloService =  new HelloServiceService().getHelloServicePort();
        System.out.println(helloService.sayHello("李滔"));
        System.out.println(helloService.calcSquareRoot(4));
        System.out.println(helloService.translate("李滔"));
    }
}
