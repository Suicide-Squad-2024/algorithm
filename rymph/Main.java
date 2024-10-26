import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 3; i++){
            int value;
            try{
                value = Integer.parseInt(br.readLine());
            }catch(NumberFormatException e){
                continue;
            }

            int test = value + (3 - i);
            if(test % 15 == 0){
                System.out.println("FizzBuzz");
            }else if(test % 3 == 0){
                System.out.println("Fizz");
            }else if(test % 5 == 0){
                System.out.println("Buzz");
            }else{
                System.out.println(test);
            }
            break;
        }
    }
}