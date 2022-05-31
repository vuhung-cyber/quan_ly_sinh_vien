import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.nio.file.Paths;

public class Manage_Account {

    public ArrayList<Account> list_account = new ArrayList<>();

    public void get_account_to_file(){
        try {
            Scanner scanner = new Scanner(Paths.get("account.txt"), "UTF-8");
            while (scanner.hasNextLine()) {
                String str = scanner.nextLine();
                String[] parts = str.split("\t");
                list_account.add(new Account(parts[0], parts[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        Manage_Account a = new Manage_Account();
        a.get_account_to_file();
    }
}
