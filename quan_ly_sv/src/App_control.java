import com.sun.xml.internal.bind.v2.runtime.property.PropertyFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.util.Scanner;

public class App_control implements Initializable {

    @FXML
    private Button logout;

    @FXML
    private TableView<Student> list_sv;

    @FXML
    private TableColumn<Student, String> name;

    @FXML
    private TableColumn<Student, String> grade;

    @FXML
    private TableColumn<Student, String> _class;

    @FXML
    private TableColumn<Student, String> company;

    @FXML
    private TableColumn<Student, String> job;

    @FXML
    private TableColumn<Student, String> teacher;

    @FXML
    private TextField sv;

    @FXML
    private TextField khoa;

    @FXML
    private TextField lop;

    @FXML
    private TextField cong_ty;

    @FXML
    private TextField vi_tri;

    @FXML
    private TextField gv;

    @FXML
    private Button them;

    @FXML
    private Button xoa;

    @FXML
    private TextField search;

    private ObservableList<Student> students_list;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        students_list = FXCollections.observableArrayList();

        name.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
        grade.setCellValueFactory(new PropertyValueFactory<Student, String>("grade"));
        _class.setCellValueFactory(new PropertyValueFactory<Student, String>("_class"));
        company.setCellValueFactory(new PropertyValueFactory<Student, String>("company"));
        job.setCellValueFactory(new PropertyValueFactory<Student, String>("job"));
        teacher.setCellValueFactory(new PropertyValueFactory<Student, String>("teacher"));


        list_sv.setItems(students_list);
        addStudent();
    }

    public void addStudent() {
        try {
            Scanner scanner = new Scanner(Paths.get("student.txt"), "UTF-8");
            while (scanner.hasNextLine()) {
                String str = scanner.nextLine();
                String[] parts = str.split(",");
                students_list.add(new Student(parts[0],parts[1],parts[2],parts[3],parts[4],parts[5]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void buttom_add() {
        students_list.add(
                new Student(
                    sv.getText(), khoa.getText(), lop.getText(), cong_ty.getText(), vi_tri.getText(), gv.getText()
                )
        );

        String content = "\n" + sv.getText() + "," + khoa.getText() + "," + lop.getText() +
        "," + cong_ty.getText() + "," + vi_tri.getText() + "," + gv.getText();
        //Specify the file name and path here
        File file = new File("student.txt");

        FileWriter fw = null;
        try {
            fw = new FileWriter(file,true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //BufferedWriter writer give better performance
        BufferedWriter bw = new BufferedWriter(fw);
        try {
            bw.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Closing BufferedWriter Stream
        try {
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void buttom_delete() {
        Student st = list_sv.getSelectionModel().getSelectedItem();
        students_list.remove(st);

        Path path = Paths.get("student.txt");
        Charset charset = StandardCharsets.UTF_8;

        String content = null;
        try {
            content = new String(Files.readAllBytes(path), charset);
        } catch (IOException e) {
            e.printStackTrace();
        }
        content = content.replaceAll("\n" + st.getName() + "," + st.getGrade() + "," + st.get_class() +
                "," + st.getCompany() + "," + st.getJob() + "," + st.getTeacher(), "");
        try {
            System.out.println("yes");
            Files.write(path, content.getBytes(charset));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setLogout(){
        Main m = new Main();
        try {
            m.changeScene("interface.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
