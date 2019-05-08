/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package 测试;

import java.util.Optional;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import 字体.字体对话框;

/**
 *
 * @author yanxi
 */
public class 测试界面 extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        Button b=new Button("显示字体对话框");
        stage.setScene(new Scene(new BorderPane(b)));
        stage.setWidth(300);
        stage.setHeight(200);
        stage.show();
        b.setOnAction(e->{
            字体对话框 dialog=new 字体对话框();
            Optional<Font> result = dialog.showAndWait();
            result.ifPresent(f -> {System.out.println(f);}); 
        }); 
    }
    
    public static void run(String[] arg){launch(arg);}
    
}
