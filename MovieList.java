/*
 * Mitchell Golding 3552573
 * CS1073 Assignment 5, question 1
 * Created October 12 2016
 * 
 * Purpose: To compile a list of the Movies and allow interaction with them
 * Input: Movie infoformation to be made into an array of movie objects
 * Output: Organized movie lists and movies in each decade
 */
package cs1073_assign5_q1;
import java.util.Scanner; import java.util.Random;
public class MovieList {
    private Movie[] films;
    private int Size;
    Scanner answer = new Scanner(System.in);
    Random rng = new Random();
    
    MovieList(int size)
    {
        films= new Movie[size];
        Size =size;
    }
    public void addFilm(int index, Movie film)//Add a film to the list
    {
        films[index] = film;
    }
    public String getFilmTitle(int index)//Return Film's name
    {
        return films[index].getTitle();
    }
    public int getFilmYear(int index)//Return Film's year
    {
        return films[index].getYear();
    }
    public String getOldest()//Return oldest film in list(or one from the most distant year)
    {
        Movie Oldest = new Movie("null",0);int current=999999;//Drasitically inflated so it will never be oldest
        for(Movie film:films)
        {
            if(film.getYear()<=current)//or equal to in case of multiple one year
            {
                current = film.getYear();
                Oldest = film;
            }
        }
        return "Oldest Film: "+Oldest;
    }
    public String getNewest()//Return newest film in list(or one from the most recent year)
    {
       Movie Newest=new Movie("null",0);int current=-999999;//Drasitically deflated so it will never be newest
        for(Movie film:films)
        {
            if(film.getYear()>=current)//or equal in case of multiples
            {
                current = film.getYear();
                Newest = film;
            }
        }
        return "Newest Film: "+Newest; 
    }
    public String perDecade()//Return #films per decade
    {
        int d880s=0; int d890s=0;//Added these just incase someone throws in a REAL oldie
        int d900s=0; int d910s=0; int d920s=0; int d930s=0; int d940s=0; int d950s=0;
        int d960s=0; int d970s=0; int d980s=0; int d990s=0; int d000s=0; int d010s=0;//Every decade from 1880-2019. No film surviving to today
        for(Movie film:films)                                                        //exists outside of this range.
        {
            switch((film.getYear()-1800)/10)//Because it is an int it will automatically round down for each decade
            {//Iterate the decade counter if it is in that decade
                case 10:
                {d900s++;
                break;}
                case 11:
                {d910s++;
                break;}
                case 12:
                {d920s++;
                break;}
                case 13:
                {d930s++;
                break;}
                case 14:
                {d940s++;
                break;}
                case 15:
                {d950s++;
                break;}
                case 16:
                {d960s++;
                break;}
                case 17:
                {d970s++;
                break;}
                case 18:
                {d980s++;
                break;}
                case 19:
                {d990s++;
                break;}
                case 20:
                {d000s++;
                break;}
                case 21:
                {d010s++;
                break;}
                case 8:
                {d880s++;
                break;}
                case 9:
                {d890s++;
                break;}
            }
        }
    return "Films per Decade\n1880\'s: "+d880s+"\n1890\'s: "+d890s+"\n1900\'s: "
            +d900s+"\n1910\'s: "+d910s+"\n1920\'s: "+d920s+"\n1930\'s: "+d930s+
            "\n1940\'s: "+d940s+"\n1950\'s: "+d950s+"\n1960\'s: "+d960s+"\n1970\'s: "
            +d970s+"\n1980\'s: "+d980s+"\n1990\'s: "+d990s+"\n2000\'s: "+d000s+
            "\n2010\'s: "+d010s;//All decades with their counts.
    }
    public String getDecade(int Year)//Returns films in the decade of the year provided
    {
        String ofDec="Films from the "+(Year/10)*10+"\'s:\n";
        for(Movie film:films)
        {
            if(film.getYear()/10==Year/10)
                ofDec+=film.getTitle()+"\n";
        }
        return ofDec;
    }
    public String numberSeen()
    {
        int Seen=0;//ask a question for 20 random films, if yes Seen++
        Movie film = films[rng.nextInt(100)];//chooses random film from list, allows repetitions
        double SeenPercent; int perDecade=-1; int tempDecStorage=0;
        int[] decades = {1880,1890,1900,1910,1920,1930,1940,1950,1960,1970,1980,1990,2000,2010};
        //For getting the decade out of how many per decade
        int d880s=0; int d890s=0;//Copied all the decade stuff from above
        int d900s=0; int d910s=0; int d920s=0; int d930s=0; int d940s=0; int d950s=0;
        int d960s=0; int d970s=0; int d980s=0; int d990s=0; int d000s=0; int d010s=0;
        String out="";
        
        System.out.print("Have you seen ");
        for(int i=0;i<20;i++)//20 questions
        {
            System.out.println(film+" (Y/N)");
            if(answer.nextLine().equalsIgnoreCase("Y"))//If yes then
            {
                Seen++;
            switch((film.getYear()-1800)/10)//Because it is an int it will automatically round down for each decade
            {//Iterate the decade counter if it is in that decade
                case 10:
                {d900s++;
                break;}
                case 11:
                {d910s++;
                break;}
                case 12:
                {d920s++;
                break;}
                case 13:
                {d930s++;
                break;}
                case 14:
                {d940s++;
                break;}
                case 15:
                {d950s++;
                break;}
                case 16:
                {d960s++;
                break;}
                case 17:
                {d970s++;
                break;}
                case 18:
                {d980s++;
                break;}
                case 19:
                {d990s++;
                break;}
                case 20:
                {d000s++;
                break;}
                case 21:
                {d010s++;
                break;}
                case 8:
                {d880s++;
                break;}
                case 9:
                {d890s++;
                break;}
            }      
        }
            film = films[rng.nextInt(100)];
            }
        int[] decadeVals = {d880s,d890s,d900s,d910s,d920s,d930s,d940s,d950s,d960s,d970s,
            d980s,d990s,d000s,d010s};//For getting the decade value in a for loop
                                     //Down here because it is the only way to bulk load
                                     //With the updated values from the switch statement above
        for(int i=0;i<14;i++)
        {
            if(decadeVals[i]>=perDecade)
            {
                perDecade=decadeVals[i];
                tempDecStorage = i;
            }
        }
        SeenPercent = (double)Seen/20*100;
        Seen = (int)SeenPercent;
        if (perDecade<=0)
            out = "You have not watched any of these films. Take tomorrow off and enjoy some Sci-Fi.";
        else
            out = Seen+"%. Most films watched from the "+decades[tempDecStorage]+"\'s.\n";
        return out;//\n in the string above because there are so many lines we need spaces
    }
    public void sortList()
    {
        Movie[] newfilms = new Movie[Size];
        String current="";int currentyear = 0;
        int index = 99;//This will be changed in the for loop
        int change = 0;
        
        for(Movie film:films)
        {
            current=film.getTitle();
            currentyear = film.getYear();
            for(Movie Film:films)
            {
                change = current.compareToIgnoreCase(Film.getTitle());
                if(change<0)
                    change = -1;
                else if(change==0&&currentyear!=Film.getYear())
                {
                    if(currentyear>Film.getYear())
                        change = 0;
                    else
                        change = -1;
                }
                else
                    change=0;
                index += change;
            }
            newfilms[index]=film;
            index = 99;
        }
        films = newfilms;
    }
    @Override
    public String toString()//override to string so it prints the list as is
    {
        String out = "";
        for(Movie film:films)
        {
            out+=film+"\n";
        }
        return out;
    }
    }

