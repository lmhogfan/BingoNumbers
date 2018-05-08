package com.company;

import java.util.*;

public class BingoNumbers
{
    private Set<Integer> calledNumbers = new HashSet<>();

    public static void main(String[] args)
    {
        BingoNumbers bingoNumbers = new BingoNumbers();
        bingoNumbers.run();
    }

    private void run()
    {
        Scanner call = new Scanner(System.in);
        String callSelection;
        String command;
        commandList();
        do
        {
            callSelection = call.nextLine();
            String[] commandSelection = callSelection.split(" ");
            command = commandSelection[0].toUpperCase();
            if (command.equals("CALL"))
            {
                try
                {
                    int number;
                    if(commandSelection.length==1)
                    {
                        number=randomNumber();
                    }
                    else
                    {
                        number = Integer.parseInt(commandSelection[1]);
                    }
                    if (number <= 75 && number > 0)
                    {
                        callNumber(number);
                    }
                    else
                    {
                        System.out.println("Please choose a number between 1-75!");
                    }
                }
                catch (Exception e)
                {
                    System.out.println("Please enter a number from 1-75!");
                }
            }
            else if (command.equals("CALLED"))
            {
                called();
            }
            else if (command.equals("VERIFY"))
            {
                try
                {
                    int number = Integer.parseInt(commandSelection[1]);
                    if (number <= 75 && number > 0)
                    {
                        verify(number);
                    } else
                    {
                        System.out.println("Please enter a number between 1-75!");
                    }
                } catch (Exception e)
                {
                    System.out.println("Please enter a number between 1-75!");
                }
            }
            else if (command.equals("CHALLENGE"))
            {
                try
                {
                    int number = Integer.parseInt(commandSelection[1]);
                    if (number <= 75 && number > 0)
                    {
                        challenge(number);
                    } else
                    {
                        System.out.println("Please enter a number between 1-75!");
                    }
                } catch (Exception e)
                {
                    System.out.println("Please enter a number between 1-75!");
                }
            }
            else if (command.equals("TOGO"))
            {
                toGo();
            }
            else if (command.equals("BINGO"))
            {
                bingo();
            }
            else
            {
                System.out.println("Please choose from the following commands!");
                commandList();
            }
        }
        while (!command.equals("BINGO"));
        System.out.println("Thanks for playing!");
    }

    private void commandList()
    {
        System.out.println("Welcome to BINGO!");
        System.out.println("Please choose from the following");
        System.out.println("Call <1-75>");
        System.out.println("Numbers Called");
        System.out.println("Verify <1-75>");
        System.out.println("Challenge<1-75>");
        System.out.println("ToGo");
        System.out.println("BINGO");
    }

    private void callNumber(int number)
    {
        if (calledNumbers.contains(number))
        {
            System.out.println("Number has already been called!");
        } else
        {
            calledNumbers.add(number);
            System.out.println("You called number " + number);
        }
    }

    private void called()
    {
        System.out.println("These numbers have been called");
        List<Integer> sortedList = new ArrayList<>(calledNumbers);
        Collections.sort(sortedList);
        System.out.println(sortedList);
    }

    private void verify(int number)
    {
        if (calledNumbers.contains(number))
        {
            System.out.println("Number has been called");
        } else
        {
            System.out.println("Number has not been called");
        }
    }

    private void challenge(int number)
    {
        if (calledNumbers.contains(number))
        {
            calledNumbers.remove(number);
            System.out.println("Number " + number + " was removed!");
        } else
        {
            System.out.println("This number hasn't been called");
        }
    }

    private void bingo()
    {
        if (calledNumbers.size() < 4)
        {
            System.out.println("You dirty cheater!");
        } else
        {
            System.out.println("You've won a fruit cake!");
        }
    }

    private void toGo()
    {
        Set<Integer> seventyFive = new HashSet<>();
        for (int x = 1; x <= 75; x++)
        {
            seventyFive.add(x);
        }
        seventyFive.removeAll(calledNumbers);
        System.out.println("Remaining uncalled numbers: ");
        System.out.println(seventyFive);
    }

    private int randomNumber()
    {
        Random rando = new Random();
        int rNG = rando.nextInt(75);
        return rNG;

    }

    private String addLetter(int number)
    {
        String letter="";
        if(number>0&&number<=15)
        {
            letter="B";
        }
        if(number>=16&&number<=30)
        {
            letter="I";
        }
        if (number>=31&&number<=45)
        {
            letter="N";
        }
        if(number>=46&&number<=60)
        {
            letter="G";
        }
        if (number>=61&&number<=75)
        {
            letter="O";
        }
        return letter;
    }
}