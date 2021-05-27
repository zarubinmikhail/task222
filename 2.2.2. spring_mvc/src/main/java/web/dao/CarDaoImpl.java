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
    public List<Car> getCars(String count, List<Car> list) {
        carList.clear();
        int tmp = 0;
        if (count == null) {

            return list;
        } else {
            tmp = Integer.parseInt(count);
            if (tmp < 5) {
                for (int i = 0; i < tmp; i++) {
                    carList.add(list.get(i));
                }
                return carList;
            } else {

                return list;

            }
        }
    }
}
