package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MealImpl implements MealDAO
{
    private Map<Integer, Meal> mealMap;
//public Meal(LocalDateTime dateTime, String description, int calories) {
    public MealImpl() {
        mealMap = new HashMap<Integer, Meal>(){
            {
                put(0, new Meal( LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500));
                put(1, new Meal( LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 1000));
                put(2, new Meal( LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 500));
                put(3, new Meal( LocalDateTime.of(2015, Month.MAY, 31, 10, 0), "Завтрак", 1000));
                put(4, new Meal( LocalDateTime.of(2015, Month.MAY, 31, 13, 0), "Обед", 500));
                put(5, new Meal( LocalDateTime.of(2015, Month.MAY, 31, 20, 0), "Ужин", 510));
            }
        };
    }
    @Override
    public List<Meal> getMeals()
    {
        ArrayList<Meal> list = new ArrayList<>();
        list.add(new Meal( LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500));
        list.add(new Meal( LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 1000));
        list.add(new Meal( LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 500));
        list.add(new Meal( LocalDateTime.of(2015, Month.MAY, 31, 10, 0), "Завтрак", 1000));
        list.add(new Meal( LocalDateTime.of(2015, Month.MAY, 31, 13, 0), "Обед", 500));
        list.add(new Meal( LocalDateTime.of(2015, Month.MAY, 31, 20, 0), "Ужин", 510));

        return list;
        //return mealMap.values().stream().collect(Collectors.toList());
    }

}



