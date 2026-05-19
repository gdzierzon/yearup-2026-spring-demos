package com.pluralsight.models.pairs;

import com.pluralsight.models.pairs.music.Musician;

public class Pair<T extends Musician>
{
    private T left;
    private T right;

    public Pair(T left, T right)
    {
        this.left = left;
        this.right = right;
    }

    public Object getLeft()
    {
        return left;
    }

    public Object getRight()
    {
        return right;
    }

    public void swap()
    {
        T temp = left;
        left = right;
        right = temp;
    }

    public void perform()
    {
        left.perform();
        right.perform();
    }
}
