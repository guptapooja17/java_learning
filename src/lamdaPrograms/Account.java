package lamdaPrograms;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class AccountSummary {
    int id;
    int bal;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getbal() {
        return bal;
    }

    public void setbal(int bal) {
        this.bal = bal;
    }

    public AccountSummary() {
    }

    public AccountSummary(int id, int bal) {
        this.id = id;
        this.bal = bal;
    }

    public void print() {
        System.out.println("id =" + this.id + "Balance = " + this.bal);
    }

    @Override
    public String toString() {
        return "AccountSummary{" +
                "id=" + id +
                ", bal=" + bal +
                '}';
    }
}

public class Account {
    static List<AccountSummary> accounts;
    public static void main (String[] args) {
        accounts = new ArrayList<>();
        accounts.add(new AccountSummary(1 , 100));
        accounts.add(new AccountSummary(1 , 2000));
        accounts.add(new AccountSummary(1 , 500));
        accounts.add(new AccountSummary(1 , 600));
        accounts.add(new AccountSummary(1 , 1000));

        //predicate 1
        printAccountPredicate( account -> true);

        //Predicate 2
        System.out.println("balance > 300");
        printAccountPredicate( account -> account.getbal() > 300);

        //Predicate 3
        System.out.println("balance < 200 and > 500");
        printAccountPredicate( account -> account.getbal() > 500 && account.getbal() < 1000);

        simplePredicate(1000, i -> i > 400);
    }

    static void printAccountPredicate (Predicate<AccountSummary> tester) {
            for ( AccountSummary as : accounts){
                if(tester.test(as))
                    as.print();
            }
    }

    static void simplePredicate (int i, Predicate<Integer> tester) {
            if(tester.test(i))
                System.out.println(i);
    }
}
