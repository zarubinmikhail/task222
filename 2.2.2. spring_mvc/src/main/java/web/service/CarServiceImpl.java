package web.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import web.dao.CarDao;
import javax.transaction.Transactional;


@Service
public class CarServiceImpl implements CarService {
    private CarDao carDao;

    public void setCarDao(CarDao carDao) {
        this.carDao = carDao;
    }

    @Override
    @Transactional
    public String getCars(String count, Model model) {
        return carDao.getCars(count, model);
    }
}
