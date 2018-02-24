import java.io.*;

/**
 * Created by cowlog on 18-2-24.
 * Execution
 */

import java.util.Scanner;

public class Execution {

    public static void main(String[] args) throws Exception {

        java.io.File file=new java.io.File("word.txt");
        Scanner input=new Scanner(file);
        Scanner put=new Scanner(System.in);
        String [] words=new String[5];
        int i=0;

        while(input.hasNext()){
            words[i]=input.next();
            i++;
        }

        String [] S=new String[5];

        for(i=0;i<5;i++){
            S[i]="";
        }

        for(i=0;i<words.length;i++){
            for(int j=0;j<words[i].length();j++)
                S[i]=S[i]+"*";
        }

        String Set="";
        String str="";

        do{
            int index=(int) (Math.random()*5);
            char [] chars=words[index].toCharArray();
            char [] C=S[index].toCharArray();

            do
            {

                System.out.print("请输入第"+(index+1)+"个单词中字母");
                for(i=0;i<C.length;i++)
                    System.out.print(C[i]);
                System.out.println("");

                String temp=put.next();
                char t=temp.charAt(0);

                for(i=0;i<chars.length;i++){
                    if(t==C[i])
                        System.out.println(t+"已经存在！");
                    else if(t==chars[i])
                        C[i]=t;
                }

                str=String.valueOf(C);

            }while(!str.equals(words[index]));

            System.out.println("第"+index+"个单词为:"+str);
            System.out.println("还要继续吗？Y/N");

            Set=put.next();

            if(Set=="N")
                break;
        }while(Set.equals("Y")||Set.equals("y"));
    }
}

