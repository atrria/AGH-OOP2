import java.util.Arrays;

/**
 * The lab04string abstract class provides methods for operating on Strings and chars.
 */
abstract public class lab04string
{
	/**
	 * Returns the length of a String.
	 *
	 * @param s1 the String to get the length of
	 * @return length of s1
	 */
	public static int dlugosc(String s1)
	{
		return s1.length();
	}
	
	/**
	 * Returns occurrences of a char in a String.
	 *
	 * @param s1 the String to count occurrences in
	 * @param c  the character to count occurrences of
	 * @return number of c occurrences in s1
	 */
	public static int ile_razy_literka_wystepuje(String s1, char c)
	{
		return (int)s1.chars().filter(i -> i == c).count();
	}
	
	/**
	 * Checks whether two Strings are lexicographically equal.
	 *
	 * @param s1 the String
	 * @param s2 the other String
	 * @return true if s1 is lexicographically equal to s2, false otherwise
	 */
	public static boolean czy_takie_same(String s1, String s2)
	{
		return s1.equals(s2);
	}
	
	/**
	 * Returns reversed version of a String.
	 *
	 * @param s1 the String to be reversed
	 * @return reversed s1
	 */
	public static String wspak(String s1)
	{
		return new StringBuilder(s1).reverse().toString();
	}
	
	/**
	 * Checks whether a String is a palindrome, meaning it reads the same backward as forward.
	 *
	 * @param s1 the String to be checked for being a palindrome
	 * @return true if s1 is a palindrome, false otherwise
	 */
	public static boolean czy_plaindrom(String s1)
	{
		return czy_takie_same(wspak(s1), s1);
	}
	
	/**
	 * Checks whether letters in a String are in an ascending alphabetical order.
	 *
	 * @param s1 the String to be checked
	 * @return true if s1 is in an ascending alphabetical order, false otherwise
	 */
	public static boolean czy_abecadlowe(String s1)
	{
		for (int i = 0; i < s1.length() - 1; i++)
		{
			if (s1.charAt(i) >= s1.charAt(i + 1))
			{
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Rotates String with Caesar Cipher by offset of 13, meaning 'a' changes to 'n', 'z' to 'm' and so on.
	 * Characters other than letters are ignored and appended to the result without rotation.
	 *
	 * @param s1 the String to be rotated
	 * @return s1 rotated with Caesar Cipher
	 */
	public static String rot13(String s1)
	{
		StringBuilder s2 = new StringBuilder();
		for (char c: s1.toCharArray())
		{
			if (Character.isLetter(c))
			{
				s2.append(Character.toChars('a' + (c - 'a' + 13) % 26));
			}
			else
			{
				s2.append(c);
			}
		}
		return s2.toString();
	}
}
