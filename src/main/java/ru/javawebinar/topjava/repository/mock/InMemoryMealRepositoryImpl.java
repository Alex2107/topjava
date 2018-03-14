package ru.javawebinar.topjava.repository.mock;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.util.MealsUtil;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class InMemoryMealRepositoryImpl implements MealRepository {
    private Map<Integer, Map<Integer, Meal>> repository = new ConcurrentHashMap<>();
    //private Map<Integer, Meal> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);

    {
        //MealsUtil.MEALS.forEach(this::save);
        MealsUtil.MEALS.forEach(m -> this.save(m, 1));
    }

    @Override
    public Meal save(Meal meal, int userId) {
        Objects.requireNonNull(meal);//бросает NPE эксепшен
        if (meal.isNew())
        {
            meal.setId(counter.incrementAndGet());
        }
        meal.setUserId(userId);         //map.computeIfAbsent(key, k -> new HashSet<V>()).add(v);
        Map<Integer, Meal> meals = repository.computeIfAbsent(userId, m -> new ConcurrentHashMap<>());
        meals.put(meal.getId(), meal);
        return meal;
            //repository.put(meal.getId(), meal);
          //  return meal;

        // treat case: update, but absent in storage
        //return repository.computeIfPresent(meal.getId(), (id, oldMeal) -> meal);
    }


    @Override
    public boolean delete(int id, int userId) {
        Map<Integer, Meal> map = repository.get(userId);
        return map.keySet().removeIf(k -> k == id);
        //repository.remove(id);
    }

    @Override
    public Meal get(int id, int userId) {
        Map<Integer, Meal> map = repository.get(userId);
        return map.get(id);
    }

    @Override
    public Collection<Meal> getAll(int userId) {

        Map<Integer, Meal> map = repository.get(userId);

        return map == null ? Collections.EMPTY_LIST : map.values().stream().sorted((m1, m2) -> m2.getDateTime().compareTo(m1.getDateTime())).collect(Collectors.toList());

    }

    @Override
    public List<Meal> getBetween(LocalDateTime startDate, LocalDateTime endDate, int userId) {
        return null;
    }
}

