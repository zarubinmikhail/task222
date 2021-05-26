package web.dao;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

public interface CarDao {
    String getCars(@RequestParam(value = "count", required = false) String count, Model model);
}
