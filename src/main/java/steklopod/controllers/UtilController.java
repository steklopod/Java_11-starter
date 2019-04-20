package steklopod.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

//@Slf4j
@RestController
@Api(tags = {"Utils", "Вспомогательные"}, value = "Utils", description = "Rest API for utility methods")
public class UtilController {

    private static final Map<String, AtomicInteger> visits = new HashMap<>();

    private static class Util {
        @NotNull
        private static synchronized Integer getCountOfVisits(String hostAddress) {
            visits.putIfAbsent(hostAddress, new AtomicInteger(0));
            return visits.get(hostAddress).incrementAndGet();
        }
    }


    @GetMapping
    public String home() throws UnknownHostException {
        String hostAddress = InetAddress.getLocalHost().getHostAddress();
        return "Привет! Твой хост адресс: " + hostAddress +
                "\n >>> Колличество визитов: [ " + Util.getCountOfVisits(hostAddress) + " ] <<<";
    }

    @RequestMapping("/raiseError")
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ApiOperation(value = "Бросает ошибку", response = Exception.class)
    public val raiseError() {
        throw new IllegalArgumentException("Упс. Ты вызвал ошибку.");
    }


    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleError(IllegalArgumentException e) {
//        log.info("Обработчик исключений вызван. ");
        return e.getMessage();
    }

}
