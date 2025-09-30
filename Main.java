
// This program is for submission's only
// Content subject to change at any moment
import java.util.*;

public class Main {
    public static void main(String[] args){

        // Input section
        Scanner input = new Scanner(System.in);
        char[] s = input.nextLine().toCharArray();
        input.close();

        HashSet<Character> set = new HashSet<>();
        HashMap<Character, Character> map = new HashMap<>();
        set.add('(');
        set.add(')');
        set.add('{');
        set.add('}');
        set.add('[');
        set.add(']');

        map.put('(', ')');
        map.put('{','}');
        map.put('[', ']');

        // Calculation steps
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length; i++){
            char cur = s[i];
            if(!set.contains(cur)) continue; // check if it's a bracket

            if(map.containsKey(cur)){
                // left bracket 
                stack.push(cur);

            }else{ 
                if(!stack.isEmpty()){
                    // right bracket
                    char temp = stack.pop();
                    if(map.get(temp) != cur){
                        System.out.println("NO " + (i+1));
                        return;
                    }
                }else{
                    System.out.println("NO " + (i+1));
                    return;
                }
            }

        }

        if(!stack.isEmpty()){
            System.out.println("NO " + (s.length + 1));
            return;
        }


        // Output Section
        System.out.println("YES");
    }
    
}
