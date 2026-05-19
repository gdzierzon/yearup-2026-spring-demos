package com.pluralsight.models.pairs;

import java.time.LocalDate;

public class LocalDatePair
{
    private LocalDate leftDate;
    private LocalDate rightDate;

    public LocalDatePair(LocalDate leftDate, LocalDate rightDate)
    {
        this.leftDate = leftDate;
        this.rightDate = rightDate;
    }

    public LocalDate getLeftDate()
    {
        return leftDate;
    }

    public LocalDate getRightDate()
    {
        return rightDate;
    }


    public void swap()
    {
        LocalDate temp = leftDate;
        leftDate = rightDate;
        rightDate = temp;
    }
}
