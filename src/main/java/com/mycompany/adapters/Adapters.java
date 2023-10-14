package com.mycompany.adapters;

public class Adapters {

    public interface Duck {
        void quack();
        void fly();
    }

    public class MallardDuck implements Duck {
        @Override
        public void quack() {
            System.out.println("Quack");
        }

        @Override
        public void fly() {
            System.out.println("I am flying");
        }
    }

    public interface Turkey {
        void gobble();
        void fly();
    }

    public class WildTurkey implements Turkey {
        @Override
        public void gobble() {
            System.out.println("Gobble Gobble");
        }

        @Override
        public void fly() {
            System.out.println("I'm flying a short distance");
        }
    }

    public class TurkeyAdapter implements Duck { // Adapter for Turkey
        Turkey turkey;

        public TurkeyAdapter(Turkey turkey) {
            this.turkey = turkey;
        }

        @Override
        public void quack() {
            turkey.gobble();
        }

        @Override
        public void fly() {
            for (int j = 0; j < 5; j++)
                turkey.fly();
        }
    }

    public static void main(String[] args) {
        Adapters adapters = new Adapters(); // Creating an instance of the class
        adapters.run(); // Call the run method
    }
    
    public void run() {
        MallardDuck duck = new MallardDuck();
        WildTurkey turkey = new WildTurkey();
        Duck turkeyAdapter = new TurkeyAdapter(turkey); // Using the TurkeyAdapter as a Duck

        System.out.println("The Turkey says...");
        turkey.gobble();
        turkey.fly();

        System.out.println("\nThe Duck says...");
        duck.quack();
        duck.fly();

        System.out.println("\nThe TurkeyAdapter says...");
        turkeyAdapter.quack(); // Adapter being used to make the turkey quack like a duck.
        turkeyAdapter.fly(); // Adapter being used to make the turkey fly like a duck.
    }
}
