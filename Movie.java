/*
 * Mitchell Golding 3552573
 * CS1073 Assignment 5, question 1
 * Created October 12 2016
 * 
 * Purpose: To store information on each movie
 * Input: Title and Year
 * Output: Title and Year
 */
package cs1073_assign5_q1;

public class Movie {
    private String Title;private int Year;
    Movie(String Title, int Year)
    {
        this.Title = Title;
        this.Year = Year;
    }
    public String getTitle()
    {
        return Title;
    }
    public int getYear()
    {
        return Year;
    }
    @Override
    public String toString()//overide the toString so it can print easier
    {
        return Title+" ("+Year+")";
    }
}
