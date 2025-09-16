import java.util.Scanner;


public class RodSculpture {

    public static void main(String[] args){

        // Taking inputs
        Scanner input = new Scanner(System.in);

        String dir = "+x";
        int length = input.nextInt();
        

        // Calculations
        while(length > 1){

            String operation = input.next();
            dir = bend(dir, operation);
            length--;
        }

        input.close();

        // Output
        System.out.print(dir); // don't start a new line with println.
    }

    public static String bend(String dir, String operation){
        
        // There are a few cases:
        // 0. we only bend in y and z direction, default rule

        // 1. if the direction is +x, then the dir should be the same as next operand

        // 2. if the dir is -x, then the dir should be the right oposite of next operand

        // 3. if the dir is +y or -y and the operand is +z or -z, nothing changes

        // 4. same thing happens with +z or -z, if operand is somethingY, then nothing changes

        // 5. if dir and operand is the oposite, then +x again

        // 6 if dir and operand is the exact same? -x

        // 7. 'No' has no effect

        if(operation.equals("No")){
            return dir; // by 7.
        }

        if(dir.equals("+x")){
            return operation; // by 1.

        }

        if(dir.equals("-x")){
            String newDir = "";
            // Flip sign, by 2.
            if(operation.charAt(0) == '+'){
                newDir = "-" + operation.substring(1);

            }else{
                newDir = "+" + operation.substring(1);
                
            }
            return newDir;
        }

        if(dir.equals("+y")){

            if(operation.equals("+y")){ // by 5.
                return "-x";
            }
            if(operation.equals("-y")){ // by 6.
                return "+x";
            }
            return dir; //if z then nothing changed, 3.
        }

        if(dir.equals("-y")){

            if(operation.equals("-y")){ // by 5.
                return "-x";
            }
            if(operation.equals("+y")){ // by 6.
                return "+x";
            }
            return dir; //if z then nothing changed, 3.
        }

        if(dir.equals("+z")){

            if(operation.equals("+z")){ // by 5.
                return "-x";
            }
            if(operation.equals("-z")){ // by 6.
                return "+x";
            }
            return dir; //if z then nothing changed, 3.
        }

        if(dir.equals("-z")){

            if(operation.equals("-z")){ // by 5.
                return "-x";
            }
            if(operation.equals("+z")){ // by 6.
                return "+x";
            }
            return dir; //if z then nothing changed, 3.
        }

        return dir;
    }
}
