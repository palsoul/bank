import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Bauka on 08.07.16.
 */
public class Console {

    private List<Account> accounts;

    private String services = "1. Sort by value\n2. Get available sum\n3. Get total sum";

    public Console(String path) {

        accounts = new ArrayList<Account>();

        try {
            BufferedReader in = new BufferedReader(new FileReader(path));
            String line;

            while ((line = in.readLine()) != null) {
                StringTokenizer tokens = new StringTokenizer(line);

                final int id = Integer.parseInt(tokens.nextToken());
                int money = Integer.parseInt(tokens.nextToken());

                boolean block = false;
                if (Integer.parseInt(tokens.nextToken()) == 1) {
                    block = true;
                }

                accounts.add(new Account(id, money, block));
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    public void startSession() {
        System.out.println("Please, choose service, or press '0' to stop session:" + '\n' + services);
        while (true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                String service = reader.readLine();

                switch (service) {
                    case "1": sort(); break;
                    case "2": getSum(); break;
                    case "3": getTotalSum(); break;
                    default: return;
                }
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
    }

    private void sort() {
        Collections.sort(accounts, new Comparator<Account>() {
            @Override
            public int compare(Account o1, Account o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        for (Account account: accounts) {
            System.out.print("id: " + account.getId() + ", value: " + account.getValue() + "$, status: ");
            if (account.isBlocked()) {
                System.out.println("blocked");
            } else {
                System.out.println("available");
            }
        }
    }

    private void getSum() {
        int count = 0;
        for (Account account: accounts) {
            if (!account.isBlocked()) {
                count += account.getValue();
            }
        }
        System.out.println(count);
    }

    private void getTotalSum() {
        int count = 0;
        for (Account account: accounts) {
            count += account.getValue();
        }
        System.out.println(count);
    }
}
