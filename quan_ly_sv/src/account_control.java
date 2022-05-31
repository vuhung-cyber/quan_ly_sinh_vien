import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;

import java.net.URL;
import java.util.ResourceBundle;

public class account_control implements Initializable {
    Manage_Account manage_account = new Manage_Account();

    @FXML
    private javafx.scene.control.TextField user;

    @FXML
    private PasswordField pass;

    @FXML
    private Button ok;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        manage_account.get_account_to_file();
    }

    public void check_pass() throws Exception {
        Main main = new Main();
        int length = manage_account.list_account.size();

        for(int i=0; i<length; i++) {
            if(manage_account.list_account.get(i).user.equals(user.getText())){
                // check pass
                if(manage_account.list_account.get(i).password.equals(pass.getText())) {
                    main.changeScene("app_interface.fxml");
                }else {
                    Alert al = new Alert(Alert.AlertType.ERROR);
                    al.setTitle("Error");
                    al.setContentText("sai pass r nguu");
                    al.show();
                }
            }
            else {
                Alert al = new Alert(Alert.AlertType.ERROR);
                al.setTitle("Error");
                al.setContentText("Nguu");
                al.show();
            }
        }
    }

}
