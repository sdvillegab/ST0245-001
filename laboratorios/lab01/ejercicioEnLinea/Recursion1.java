/**
 * Aqui se ponen los ejercicioss realizados de Recursion-1 en CodingBat
 * 
 * @autor Julian Ramirez,Samuel Villegas
 */
public class Recursion1{
    public String allStar(String str) {
        if(str.length() == 0) return "";
        if(str.length()>1) return String.valueOf(str.charAt(0)) +"*"+ allStar(str.substring(1));
        else return String.valueOf(str.charAt(0))+allStar(str.substring(1));
    }

    public int countPairs(String str) {
        if(str.length() <=2)return 0;
        if(str.charAt(0)==str.charAt(2))return 1 + countPairs(str.substring(1));
        else return countPairs(str.substring(1));
    }

    public String stringClean(String str) {
        if(str.length()<=1) return str;
        if(str.charAt(0) == str.charAt(1)) return stringClean(str.substring(1));
        else return String.valueOf(str.charAt(0))+ stringClean(str.substring(1));
    }

    public boolean nestParen(String str) {
        if(str.length()==0) return true;
        if(str.length() == 2) return str.equals("()");
        if(str.charAt(0)=='(' && str.charAt(str.length()-1)==')') return nestParen(str.substring(1,str.length()-1));
        else return false;
    }

    public String changeXY(String str) {
        if(str.length()==0) return "";
        if(str.charAt(0)=='x') return "y" + changeXY(str.substring(1));
        else return String.valueOf(str.charAt(0)) + changeXY(str.substring(1));
    }
}