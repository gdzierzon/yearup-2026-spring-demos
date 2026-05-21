package com.pluralsight.exercises;

import com.pluralsight.io.MetalsFileManager;
import com.pluralsight.models.Metal;
import com.pluralsight.models.MetalSummary;

import java.util.List;

public class Exercise03Metals
{
    private static List<Metal> metals = MetalsFileManager.loadMetals();

    public Metal getMetalByAtomicNumber(int atomicNumber)
    {
        return null;
    }

    public List<Metal> getMetalsWithMeltingPointAbove(int temp)
    {
        return null;
    }

    public List<Metal> getMetalsWithMeltingPointBelow(int temp)
    {
        return null;
    }

    public int getAverageMeltingTemp()
    {
        return 0;
    }

    public List<String> getMetalColors()
    {
        return null;
    }

    public List<Metal> getMetalsByColor(String color)
    {
        return null;
    }

    public List<MetalSummary> getMetalSummaries()
    {
        return null;
    }

    public List<MetalSummary> getMetalSummariesAlphabetized()
    {
        return null;
    }

    public List<MetalSummary> getMetalSummariesByColor(String color)
    {
        return null;
    }

    public List<MetalSummary> getTop5MetalSummariesByMeltingTemp()
    {
        return null;
    }

    public List<MetalSummary> getBottom5MetalSummariesByMeltingTemp()
    {
        return null;
    }

}
