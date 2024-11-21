package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Service
public class CarServiceImp implements CarService{
    private List<Car> cars;

    {
        cars = new ArrayList<>();
        cars.add(new Car("Toyota", "black", 100));
        cars.add(new Car("Lada", "white", 200));
        cars.add(new Car("Subaru", "red", 300));
        cars.add(new Car("Nissan", "pink", 400));
        cars.add(new Car("Skoda", "green", 500));
    }


    @Override
    public List<Car> carList(int count) {
        count = Math.min(count, 5);
        return cars.subList(0, count);
    }

}
