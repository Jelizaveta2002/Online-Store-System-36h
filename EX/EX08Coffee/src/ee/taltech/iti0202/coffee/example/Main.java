package ee.taltech.iti0202.coffee.example;

import ee.taltech.iti0202.coffee.machine.AutomaticMachine;
import ee.taltech.iti0202.coffee.machine.CoffeeMachine;

public class Main {
    public static void main(String[] args) {
        CoffeeMachine machine = new CoffeeMachine.CoffeeMachineBuilder("name").cupsOfCoffeeCanBeDone(8).build();
        AutomaticMachine machine1 = new AutomaticMachine(new CoffeeMachine.CoffeeMachineBuilder("name").cupsOfCoffeeCanBeDone(9));
        System.out.println(machine1);
    }
}
