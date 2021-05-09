/**
 * Created by zfr on 16/2/2018
 * Abstract the project
 */

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Game {
    private List<String> list=new ArrayList<String>();
    private String randomMovie="";
    private StringBuffer buffer;


    public Game(){

    }

    public Game(String src) throws Exception{
        loadFile(src);
    }

    private void loadFile(String src) throws Exception{
        File file = new File(src);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            list.add(line);
        }
    }

    public String getRandomMovie(){
        int movieSize = list.size();
        int random = (int)(Math.random()*movieSize);
        return randomMovie = list.get(random);
    }

    public StringBuffer showHiddenMovie(){
        String temp="";
        for (int i=0; i<randomMovie.length();i++){
            //System.out.print(randomMovie.charAt(i)+"-");
            if(randomMovie.charAt(i)!=' '){
                temp+="*";
            }else {
                temp+=" ";
            }
        }
        return buffer = new StringBuffer(temp);
    }

    public void guessMovie(int score){
        int wrongCount = 0;
        String wrongLetters="";
        Boolean isWin  = false;
        while (score>0 && !isWin){
            System.out.println("You have guessed ("+wrongCount+") wrong letters:"+wrongLetters);
            System.out.print("Guess a letter:");
            Scanner userGuess = new Scanner(System.in);
            char guess = userGuess.nextLine().charAt(0);
            int index = randomMovie.indexOf(guess);
            if(index<0){
                score--;
                wrongCount++;
                wrongLetters+=guess+" ";
            }else {
                for(int i=0;i<randomMovie.length();i++){
                    if(randomMovie.charAt(i)==guess){
                        //buffer.deleteCharAt(i);
                        buffer.setCharAt(i,guess);
                    }
                }
            }
            if(buffer.indexOf("*")<0){
                isWin=true;
                break;
            }
            System.out.println("You are guessing:"+buffer.toString());
        }
        if(isWin){
            System.out.println("You win!");
            System.out.println("You have guessed '"+randomMovie+"' correctly.");
        }else {
            System.out.println("Game over...");
            System.out.println("You have guessed ("+wrongCount+") wrong letters:"+wrongLetters);
            System.out.println("The movie is '"+randomMovie+"'");
        }
    }
}
