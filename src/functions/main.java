package functions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

import static java.lang.Character.toLowerCase;

public class main {

  // extra tasks

  //1
  static int Rearrange(int num)
  {
    int save_num;
    save_num = num;
    boolean negativeFlag = false;
    if (num < 0)
    {
      negativeFlag = true;
      num = -num ;
    }

    int rn = 0;

    while (num != 0)
    {
      int curr_digit = num%10;

      rn = (rn*10) + curr_digit;

      num = num/10;
    }

    if (rn > save_num){
      return (negativeFlag == true)? -rn : rn;
    }else{
      return -1;
    }
  }

  //2

  static String convertToIPv4(long i) {
    return
            (i >> 24 & 0xFF) + "." +
                    ((i >> 16) & 0xFF) + "." +
                    ((i >> 8) & 0xFF) + "." +
                    (i & 0xFF);
  }


  // task 1
  static ArrayList getIntegersFromList(List list) {
    ArrayList ints = new ArrayList();
    for (var nnn : list) {
      if (nnn instanceof Integer) {
        ints.add(nnn);
      }
    }
    return ints;
  }

  // task2
  static char getFirstNonRepeatingLetter(String string) {
    for (int i = 0; i < string.length(); i++) {
      boolean nrs = true;
      char c = toLowerCase(string.charAt(i));
      for (int j = 0; j < string.length(); j++) {
        if (i != j && c == toLowerCase(string.charAt(j))) {
          nrs = false;
          break;
        }
      }
      if (nrs) {
        return string.charAt(i);
      }
    }
    return ' ';
  }

  // task3
  public int getDigitalRoot(int number) {

    int dr = 0;
    int tempNumber = number;
    int mod = 0;
    while (tempNumber > 0) {
      mod = tempNumber % 10;
      dr += mod;
      tempNumber = tempNumber / 10;
    }
    if (dr / 10 != 0) {
      return getDigitalRoot(dr);
    }
    return dr;
  }

  // task4
  // 1
  static int getPairsCountFor(int[] array, int sum) {
    int pc = 0;
    for (int i = 0; i < array.length; i++) {
      for (int j = i; j < array.length; j++) {
        if (i != j && array[i] + array[j] == sum) pc++;
      }
    }
    return pc;
  }

  // 2
  static int getPairsCountArray(int[] array, int sum) {
    int pc = 0;
    for (int i = 0; i < array.length; i++) {
      int finalI = i;
      pc +=
          IntStream.range(finalI, array.length)
              .filter(j -> finalI != j && array[finalI] + array[j] == sum)
              .count();
    }
    return pc;
  }

  // task5
  static class Person {
    private String name;
    private String surname;

    Person(String n, String s) {
      this.name = n;
      this.surname = s;
    }

    String getName() {
      return name;
    }

    String getSurname() {
      return surname;
    }

    String to_string() {
      return ("(" + surname + ", " + name + ")");
    }
  }

  public static void main(String args[]) {}

  static String SortGeeks(String friends) {
    List<Person> personList = new ArrayList<>();
    String person[];
    friends = friends.toUpperCase();
    for (String splt : friends.split(";")) {
      person = splt.split(":");
      personList.add(new Person(person[0], person[1]));
    }
    Collections.sort(
        personList, Comparator.comparing(Person::getSurname).thenComparing(Person::getName));
    StringBuilder friendsList = new StringBuilder();
    for (Person pers : personList) {
      friendsList.append(pers.to_string());
    }
    return friendsList.toString();
  }

  }



















