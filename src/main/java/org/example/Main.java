package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The Main Class.
 * @author Josh Sherry
 */
public class Main {
    public Main() {
    }

    /**
     * The main method. The entry point for this program.
     * @param args Arguments to be processed.
     * @throws FileNotFoundException Exception error if the file couldn't be found.
     */
    public static void main(String[] args) throws FileNotFoundException {
        //Establish a new list to hold houses.
        PriorityQueueList HouseList = new PriorityQueueList();

        //Locate the file location and read each line until no lines are left.
        //There has to be an even amount of lines for this to work.
        File houseFile = new File("src/main/resources/houses.txt");
        Scanner textReader = new Scanner(houseFile);
        while(textReader.hasNextLine()) {
            House house = new House();
            house.setOwner(textReader.nextLine());
            house.setValue( Integer.parseInt( textReader.nextLine() ) );
            HouseList.add(house);
        }



        //Display the most expensive house on the list.
        System.out.println("Most Expensive: " + HouseList.getMostExpensive());

        //Create a deep copy before removing elements from original list.
        PriorityQueueList HouseListCopy = new PriorityQueueList(HouseList);

        //Change the owner name of the first element in original list.
        //The copy should be unaffected.
        HouseList.peek().setOwner("Josh Sherry");
        //Go through each element in the list, print, and remove the element.
        int size = HouseList.getLength();
        System.out.println("Current list length: " + size);
        for (int i = 0; i < size; i++) {
            House house = HouseList.peek();
            System.out.println(house);
            HouseList.poll();
        }
        //Length should be 0 now.
        System.out.println("Current list length: "  + HouseList.getLength());
        System.out.println("Current first in queue: "  + HouseList.peek());
        System.out.print("\n");



        //The length of the copy should still be 1000 and
        //the first element should be owned by Hannah Ward, not Josh Sherry.
        System.out.println("Before Clear: ");
        System.out.println("House List COPY length: " + HouseListCopy.getLength());
        System.out.println("House List COPY first in queue: " + HouseListCopy.peek());
        System.out.print("\n");

        //Clear the copy. The length should be 0 with null first element.
        HouseListCopy.clear();
        System.out.println("After Clear: ");
        System.out.println("Current House List COPY length: " + HouseListCopy.getLength());
        System.out.println("House List COPY first in queue: " + HouseListCopy.peek());
        System.out.print("\n");



        //Equals method check. Create two house with different owner reference but the same owner value.
        House dreamFutureHome = new House("Josh", 1000000000.0f); System.out.println(dreamFutureHome);
        House futureHome = new House(new String("Josh"), 1.0f); System.out.println(futureHome);

        System.out.println("Are both these homes owned by Josh? \n" + (dreamFutureHome.equals(futureHome)?"Yup!":"Nope.."));

    }
}