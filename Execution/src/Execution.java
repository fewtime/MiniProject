import java.io.*;

/**
 * Created by cowlog on 18-2-24.
 * Execution
 */
public class Execution {

    public static void main(String[] args) throws IOException{
        String[] save = new String[5];
        save[0] = "execution";
        save[1] = "abc";
        save[2] = "bcd";
        save[3] = "cde";
        save[4] = "def";
        //guess process
        while(true){
            guess(save);
            System.out.println("Do you want to guess for another word? Y or N?");
            BufferedReader ba = new BufferedReader(new InputStreamReader(System.in));
            char control=(char)ba.read();
            if(control!='n' && control!='N' && control!='y' && control !='Y'){
                System.out.println("Input Error!");
                System.exit(0);
            }

            else if(control=='n' || control=='N'){
                System.out.println("BYE~");
                System.exit(0);
            }
            //again
        }
    }

    public static void  guessword(String guessword) throws IOException{
        int length=guessword.length();
        int tone=0;
        char[] hidechar= new char[length];
        for(int i=0;i<length;i++){
            hidechar[i]='*';
        }
        String hideword=String.valueOf(hidechar);
        while(!hideword.equals(guessword)){
            int flag=0;
            System.out.println("Enter a letter in word "+ hideword);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            char test=(char)br.read();
            for(int i=0;i<length;i++){
                if(guessword.charAt(i)==test){
                    hidechar[i]=test;
                    flag=1;
                }
            }
            if(flag!=1){
                tone++;
                System.out.println(test+" is not in the word.");
            }
            hideword=String.valueOf(hidechar);
        }
        System.out.println("BINGO!");
        System.out.println("Wrong "+tone+" times.");
    }

    public static void  guess(String[] save) throws IOException{
        int k=(int)(Math.random()*(save.length));
        String guessword=save[k];
        //guess process
        guessword(guessword);
    }
}

