/*
 * Mitchell Golding 3552573
 * CS1073 Assignment 5, question 1
 * Created October 12 2016
 * 
 * Purpose: Drive the Movie Collection Classes and allow interaction with the private functions
 * Input: A decade, yes or no
 * Output: How many films were released that decade, what percentage they watched
 */
package cs1073_assign5_q1;
import java.util.Scanner; import java.io.*;
public class TopMovieDriver {
    public static void main(String[] args) throws IOException{
        String Title="";int Year =0;int len = 0;//declarations
        MovieList top100 = new MovieList(100);int i = 0;
        
        Scanner filein = new Scanner(new File("top_100_Sci-Fi_Films.txt"));//file scanner
        while(filein.hasNext())//loop of scanning each line of file
        {                   //Though it is always going to be 100 for a top 100 so it could be a for loop as well
                            //Especially because I use an interating variable for indexing the list of Movies
            Title = filein.nextLine().trim();//Trim it so blank spaces don't affect the next part
            len = Title.length();//Get length so we can substring it
            Year = Integer.parseInt(Title.substring((len-5),(len-1)));//Parsing year from the line
            Title = Title.substring(0,len-6);//Removing year from the line
            top100.addFilm(i, new Movie(Title,Year));//Add a new movie object to the list of movies
            i++;//Iterate it so that the next movie to be added doesn't replace the previous one
        }
        filein.close();//Close file scanner, we are never scanning it again so why not
        
        Scanner in = new Scanner(System.in);
        System.out.println(top100.getOldest()+", "+top100.getNewest());
        System.out.println(top100.perDecade());
        System.out.println("Enter a decade: ");
        System.out.println(top100.getDecade(in.nextInt()));
        System.out.println(top100.numberSeen());
        top100.sortList();
        System.out.println(top100);
    }
    
}
