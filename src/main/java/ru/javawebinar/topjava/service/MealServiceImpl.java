package ru.javawebinar.topjava.service;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class MealServiceImpl implements MealService {

    private MealRepository repository;

    @Override
    public boolean delete(int id, int userId) throws NotFoundException {
        return false;
    }

    @Override
    public Meal get(int id, int userId) throws NotFoundException {
        return null;
    }

    @Override
    public List<Meal> getBetweenDates(LocalDate startDate, LocalDate endDate, int userId) {
        return null;
    }

    @Override
    public List<Meal> getBetweenDateTimes(LocalDateTime startDateTime, LocalDateTime endDateTime, int userId) {
        return null;
    }

    @Override
    public List<Meal> getAll(int userId) {
        return null;
    }

    @Override
    public Meal update(Meal meal, int userId) throws NotFoundException {
        return null;
    }

    @Override
    public Meal create(Meal meal, int userId) {
        return null;
    }
}