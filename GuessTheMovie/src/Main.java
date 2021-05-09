/**
    Guess The Movie
 */

//import java.util.Iterator;

public class Main {
    public static void main(String [] args) throws Exception{
        Game game = new Game("C:\\Users\\Student\\workspace\\guess-the-movie\\GuessTheMovie\\movies.txt");
        game.getRandomMovie();
        System.out.println("You are guessing:"+game.showHiddenMovie().toString());
        int guessCount = 10;
        game.guessMovie(guessCount);

        /*for (int i=0;i<movies.length;i++){
            System.out.println("movies"+i+":"+movies[i]);
        }
        for (String li:list){
            //System.out.println(li);
        }
        for(int i=0;i<list.size();i++){
            //System.out.println("movie["+i+"]:"+list.get(i));
        }
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }*/
    }
}
