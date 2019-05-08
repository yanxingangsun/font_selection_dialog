/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package 字体;

import java.io.IOException; 
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.text.Font;

/**
 *
 * @author yanxi
 */
public class 字体对话框 extends Dialog<Font>{
    FXML字体设置对话框Controller c;
    
    public 字体对话框(){
        setTitle("选择字体"); 
        
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("FXML字体设置对话框.fxml"));
        fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory()); 
        
        try {
            Parent root = fxmlLoader.load();//如果使用 Parent root = FXMLLoader.load(...) 静态读取方法，无法获取到Controller的实例对象 
            getDialogPane().setContent(root);
            c = fxmlLoader.getController();
        } catch (IOException ex) { 
            ex.printStackTrace();
        }
        
        ButtonType loginButtonType1 = new ButtonType("确定", ButtonBar.ButtonData.OK_DONE);
        ButtonType loginButtonType2 = new ButtonType("取消", ButtonBar.ButtonData.CANCEL_CLOSE);
        getDialogPane().getButtonTypes().addAll(loginButtonType1, loginButtonType2); 
        
        setResultConverter(dialogButton -> {
            if (dialogButton == loginButtonType1) {
                return c.getFxFont();
            }
            return null;
        }); 
    } 
}
