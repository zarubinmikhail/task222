package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.CarDao;
import web.models.Car;


import java.util.ArrayList;
import java.util.List;


@Controller
public class CarsController {

    List<Car> list = new ArrayList<>();

    @Autowired
    CarDao dao;

    @GetMapping(value = "/cars")
    public String showCars(@RequestParam(value = "count", required = false) String count, Model model) {

        setList();
        model.addAttribute("cars", dao.getCars(count, list));
        return "/cars";
    }

    public void setList() {
        list.clear();
        list.add(new Car("Lada", "Priora", "Black"));
        list.add(new Car("Chevrole", "Niva", "White"));
        list.add(new Car("Lambo", "Diablo", "Yellow"));
        list.add(new Car("Jeep", "Wrangler", "Green"));
        list.add(new Car("Volvo", "XC80", "White"));
        list.add(new Car("Mers", "SLK", "Blue"));
    }
}
