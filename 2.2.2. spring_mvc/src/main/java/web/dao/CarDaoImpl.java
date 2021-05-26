package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.models.Car;
import org.springframework.stereotype.Repository;
import web.controller.CarsController;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {
    private List<Car> carList = new ArrayList<>();

    @Override
    @SuppressWarnings("unchecked")
    @GetMapping(value = "/cars")
    public String getCars(@RequestParam(value = "count", required = false) String count, Model model) {
        List<Car> cars = new ArrayList<>();
        int tmp = 0;
        setList();
        if (count == null) {
            for (Car l : carList)
                cars.add(l);
            model.addAttribute("cars", cars);
            return "/cars";
        } else {
            tmp = Integer.parseInt(count);
            if (tmp < 5) {
                for (int i = 0; i < tmp; i++) {
                    cars.add(carList.get(i));
                }
                model.addAttribute("cars", cars);
            } else if (tmp >= 5) {
                for (Car l : carList)
                    cars.add(l);
                model.addAttribute("cars", cars);
            }

            return "/cars";
        }
    }

    public void setList() {
        carList.clear();
        carList.add(new Car("Lada", "Priora", "Black"));
        carList.add(new Car("Chevrole", "Niva", "White"));
        carList.add(new Car("Lambo", "Diablo", "Yellow"));
        carList.add(new Car("Jeep", "Wrangler", "Green"));
        carList.add(new Car("Volvo", "XC80", "White"));
        carList.add(new Car("Mers", "SLK", "Blue"));
    }
}
