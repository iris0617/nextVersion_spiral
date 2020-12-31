import java.io.*;

class MyCode {
	
  public static void main (String[] args) {
    String res = nextVersion("9.9");
    System.out.println(res);
	}
  
  private static String nextVersion(String version){
    String[] subVersions = version.split("\\.");
    String res = "";
    int carry = 0;
    for(int i = subVersions.length-1; i>=0; i--){
        int num = Integer.parseInt(subVersions[i]);
        /* add 1 to the last digit */
        if(i == subVersions.length-1){
          num++;
        }
        /* If there is carry from last digit's calculation, 
        add it to the current digit and set carry to 0 */
        if(carry != 0) {
          num +=carry;
          carry = 0;
        }
        /* If greater than/equal to 10 & not first digit, set to 0 
        and increase carry */
        if(num>=10 && i!=0){
            num=0;
            carry++;
        }
        /* Concatenate string */
        res=num+"."+res;
    }
    /* Remove the extra '.' added to the last number*/
    return res.substring(0, res.length()-1);
  }
}