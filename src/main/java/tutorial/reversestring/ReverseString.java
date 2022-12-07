package tutorial.reversestring;

public class ReverseString {

    public static void main(String[] args) {
        String str = "love";
        String result = "";
//        for (int i = 0; i < str.length(); i++){
//            char a = str.charAt(i);
//            result = a + result;
//        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        StringBuilder result1;
       //result = String.valueOf(stringBuilder.reverse());
       result1 = stringBuilder.reverse();

        //System.out.println("The reverse string is: "+result);
        System.out.println("The reverse string is: "+result1);
    }
}
