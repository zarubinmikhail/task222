package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.models.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;


@Controller
public class CarsController {
    private List<Car> list = new ArrayList<>();

    public List<Car> getList() {
        return list;
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


    @GetMapping(value = "/cars")
    public String getCars(@RequestParam(value = "count", required = false) String count, Model model) {
        List<Car> cars = new ArrayList<>();
        int tmp = 0;
        setList();
        if (count == null) {
            for (Car l : list)
                cars.add(l);
            model.addAttribute("cars", cars);
            return "/cars";
        } else {
            tmp = Integer.parseInt(count);
            if (tmp < 5) {
                for (int i = 0; i < tmp; i++) {
                    cars.add(list.get(i));
                }
                model.addAttribute("cars", cars);
            } else if (tmp >= 5) {
                for (Car l : list)
                    cars.add(l);
                model.addAttribute("cars", cars);
            }

            return "/cars";
        }
    }
}
//не работает с через интерфейс, не ясно, как реализовать через интерфейс?

//    public static List<Car> list = new ArrayList<>();
//    public static void setList() {
//        CarsController.list.clear();
//        CarsController.list.add(new Car("Lada", "Priora", "Black"));
//        CarsController.list.add(new Car("Chevrole", "Niva", "White"));
//        CarsController.list.add(new Car("Lambo", "Diablo", "Yellow"));
//        CarsController.list.add(new Car("Jeep", "Wrangler", "Green"));
//        CarsController.list.add(new Car("Volvo", "XC80", "White"));
//        CarsController.list.add(new Car("Mers", "SLK", "Blue"));
//    }
//    private CarService carService;
//
//    @Autowired
//    public void setCarService(CarService carService) {
//        this.carService = carService;
//    }
//
//    @GetMapping(value = "/cars")
//    public String getCars(@RequestParam(value = "count", required = false) String count, Model model) {
//        if (count != null)
//            model.addAttribute("cars", this.carService.getCars(count, model));
//        return "/cars";
//
//    }
//}