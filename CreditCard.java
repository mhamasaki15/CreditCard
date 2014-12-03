
public class CreditCard
{
  
  
  public String verify(String num)
  {
   int oddeven = 1; //Int that keeps track of whether the number is an odd or even term. 1 is odd, 0 is even.
   int totalsum = 0; //Placeholder for total sum.
   
  for (int i = num.length(); i>0; i--) //For loop that goes through each character (digit) of the String.
  {
  int digit = Integer.parseInt(num.substring(i-1, i));
    if (oddeven == 1)
    {
     totalsum += digit;
     oddeven = 0;
    }
    else 
    {
      int doubleeven = 2 * digit;
      if (doubleeven < 10)
      {
        totalsum += doubleeven;
      }
      else 
      {
        totalsum += doubleeven/10 + doubleeven % 10;
      }
    oddeven = 1;
    }
  }
   if (totalsum%10 == 0)
   {
    return "Yes.";
   }
   else 
   {
     return "No.";
   }
  }

  private String[] Diners = {"36", "38", "301", "302", "303", "304", "305"};
  
  public int findType(String num)
  {
    if (Integer.parseInt(num.substring(0, 2)) > 50 && Integer.parseInt(num.substring(0, 2)) < 56 && num.length() == 16) return 1;
    else if (num.substring(0, 1).equals("4") && (num.length() == 13 || num.length() == 16)) return 2;
    else if ((Integer.parseInt(num.substring(0, 2)) == 34 || Integer.parseInt(num.substring(0, 2)) == 37) && num.length() == 15) return 3;
    else if (num.substring(0, 4).equals("6011") && num.length() == 16) return 4;
    else //This one uses an array since there are so many possible starting numbers for Diner's club.
    {
      boolean dinerscard = false; //Set a boolean that determines if the card is a diners card.
      for (String dinernumbers: Diners)
      {
        if (num.indexOf(dinernumbers) == 0 && num.length() == 14) return 5; //If the credit card number starts with any of the numbers defined in the array, return the index of Diners card.
      }
        return 0;
    }
  }

}

