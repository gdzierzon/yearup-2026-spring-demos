package com.pluralsight.services;

import com.pluralsight.models.Actor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CsvActorsDao implements ActorsDao
{
    @Override
    public List<Actor> getAll()
    {
        return List.of();
    }

    @Override
    public List<Actor> searchByName(String firstName, String lastName)
    {
        return List.of();
    }

    @Override
    public Actor getById(int id)
    {
        return null;
    }

    @Override
    public Actor addActor(Actor actor)
    {
        return null;
    }

    @Override
    public void updateActor(Actor actor)
    {

    }

    @Override
    public void deleteActor(int actorId)
    {

    }
}
