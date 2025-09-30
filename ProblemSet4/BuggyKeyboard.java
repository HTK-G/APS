import java.util.Scanner;

public class BuggyKeyboard {

    public static void main(String[] args){
        
        // Input section
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();


        // Calculation steps
        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()){

            if(c == '<' && !sb.isEmpty()){
                sb.deleteCharAt(sb.length()-1);
            }else{
                sb.append(c);
            }
        }

        // Output section
        System.out.print(sb.toString());
        input.close();

    }
    
}
