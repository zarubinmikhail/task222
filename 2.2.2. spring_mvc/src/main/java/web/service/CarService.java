package web.service;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

public interface CarService {
    String getCars(@RequestParam(value = "count", required = false) String count, Model model);
}
