package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Override
    public List<Car> getAllCars() {
        return createCarsList();
    }

    public List<Car> getCarsByCount(int count) {
        if (count >= 5) {
            return createCarsList();
        }
        return createCarsList().subList(0, count);
    }

    private List<Car> createCarsList() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(1, "Lada", "white"));
        cars.add(new Car(2, "MERS", "blue"));
        cars.add(new Car(3, "AUDI", "red"));
        cars.add(new Car(4, "BMW", "black"));
        cars.add(new Car(5, "FORD", "green"));
        return cars;
    }


}
