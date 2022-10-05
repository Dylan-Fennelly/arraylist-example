package autoboxing;

import java.util.ArrayList;

class IntClass
{
    private int myValue;

    public IntClass(int myvalue)
    {
        this.myValue = myvalue;
    }

    public int getMyValue() {
        return myValue;
    }
}

public class Main
{
    public static void main(String[] args)
    {
        String[] strArray = new String[10];
        int[] intArray = new int[10];

        ArrayList<String> strArrayList = new ArrayList<>();
        strArrayList.add("Craig");
        ArrayList<IntClass> intClassArrayList = new ArrayList<IntClass>();
        intClassArrayList.add(new IntClass(54));

        Integer my_int = new Integer(54);
        Double my_double = new Double(12.25);

        ArrayList<Integer> intArrayList = new ArrayList<>();
        for(int i =0; i<=10; i++)
        {
            //Auto boxing
            intArrayList.add(i);
        }
        for(int i = 0; i<=10; i++)
        {
            //Auto boxing
            System.out.println(i + "---->" + intArrayList.get(i).intValue());
        }

        ArrayList<Double> myDoubles = new ArrayList<>();
        for(double dbl = 0.0; dbl <=10.0; dbl += 0.5)
        {
            myDoubles.add(dbl);
        }
        for(int i = 0; i<myDoubles.size();i++)
        {
            double value= myDoubles.get(i);
            System.out.println(value);
        }

    }
}
