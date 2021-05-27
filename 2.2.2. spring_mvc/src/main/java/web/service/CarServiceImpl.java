package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.CarDao;
import web.models.Car;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class CarServiceImpl implements CarService {

    private CarDao carDao;

    @Autowired
    public void setCarDao(CarDao carDao) {
        this.carDao = carDao;
    }

    @Override
    @Transactional
    public List<Car> getCars(String count, List<Car> list) {
        return carDao.getCars(count, list);
    }
}
