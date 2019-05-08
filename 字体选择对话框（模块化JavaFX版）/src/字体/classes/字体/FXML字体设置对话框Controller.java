/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package 字体;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight; 

/**
 * FXML Controller class
 *
 * @author yanxi
 */
public class FXML字体设置对话框Controller implements Initializable { 
    String[] fonts = Font.getFamilies().toArray(new String[]{}); 
    String[] styles={"常规Aa","粗体Aa","斜体Aa","粗斜体Aa"};
    String[] sizes={ "8", "9", "10", "11", "12", "14", "16", "18", "20", "22",
                "24", "26", "28", "36", "48", "72", "初号", "小初", "一号", "小一", "二号", "小二", "三号", "小三", "四号", "小四", "五号",
                "小五", "六号", "小六", "七号", "八号" };
    // 字号值
    int sizeValue[] = { 8, 9, 10, 11, 12, 14, 16, 18, 20, 22, 24, 26, 28, 36, 48, 72, 42, 36, 26, 24, 22, 18, 16,
            15, 14, 12, 11, 9, 8, 7, 6, 5 };
    
    public SimpleStringProperty family=new SimpleStringProperty();
    public SimpleStringProperty style=new SimpleStringProperty();
    public SimpleStringProperty size=new SimpleStringProperty();
     
    @FXML
    private TextField textField字体;
    
    @FXML 
    private TextField textField样式;
    
    @FXML 
    private TextField textField大小;
    
    @FXML
    private ListView<String> listView字体;
    
    @FXML 
    private ListView<String> listView样式;
    
    @FXML 
    private ListView listView大小; 
    
    @FXML 
    private Label label预览; 
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {   
        init字体();
        init样式();
        init大小(); 
        family.bind(textField字体.textProperty());
        style.bind(textField样式.textProperty());
        size.bind(textField大小.textProperty()); 
        
        family.addListener(new  ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) { 
                updateLabel预览();
            }
        }); 
        
        style.addListener(new  ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) { 
                updateLabel预览();
            }
        }); 
        
        size.addListener(new  ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) { 
                updateLabel预览();
            }
        }); 
    } 
    
    private void updateLabel预览(){
        String s1=family.getValue();
        String s2=style.getValue();
        String s3=size.getValue();
        if((s1!=null)&&(s2!=null)&&(s3!=null)){
            label预览.setFont(getFxFont());
        }
    }
    
    private void init字体(){
        textField字体.textProperty().bind(listView字体.getSelectionModel().selectedItemProperty()); 
        listView字体.setItems(FXCollections.observableArrayList(fonts)); 
        listView字体.setCellFactory((ListView<String> l) -> new Cell字体()); 
        
        listView字体.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {   
            textField字体.setStyle("-fx-font-family: '"+newValue.toString()+"';");  
        }); 
        listView字体.getSelectionModel().selectFirst();
    }
    
    private void init样式(){
        textField样式.textProperty().bind(listView样式.getSelectionModel().selectedItemProperty()); 
        listView样式.setItems(FXCollections.observableArrayList(styles));
        listView样式.setCellFactory((ListView<String> l) -> new Cell样式()); 
        listView样式.getSelectionModel().selectFirst();
    }
    
    private void init大小(){
        listView大小.setItems(FXCollections.observableArrayList(sizes));  
        listView大小.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> { 
            textField大小.setText(newValue.toString());
            int i=0;
            for(;i<sizes.length;i++){
                if(newValue.equals(sizes[i]))break;
            }  
        });
        
        textField大小.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                onTextField大小Changed();
            }
        });
        listView大小.getSelectionModel().select(12);
    }   
    
    public Font getFxFont(){
        String name=family.getValue(); 
        FontWeight weight=FontWeight.NORMAL;
        FontPosture pos=FontPosture.REGULAR; 
        System.out.println(family+","+style+","+size);
        switch(style.getValue()){
            case "常规Aa":break;
            case "粗体Aa":weight=FontWeight.BOLD;break;
            case "斜体Aa":pos=FontPosture.ITALIC;break;
            case "粗斜体Aa":weight=FontWeight.BOLD;pos=FontPosture.ITALIC;break;
            default:;
        }  
        
        double dsize=getFxFontSize(size.getValue()); 
        return Font.font(name, weight, pos, dsize);
    }
    
    private double getFxFontSize(String sizeText){
        boolean flag=false;
        double size=10;
        int i=0;
        for(;i<sizes.length;i++){
            if(sizeText.equals(sizes[i])){
                flag=true;
                break;
            }
        }  
        if(flag)return sizeValue[i];
        
        try{ 
            size=Double.parseDouble(sizeText); 
        } catch(Exception e){  } 
        return size;
    }
    
    @FXML
    public void onTextField大小Changed(){
        double oldSize=label预览.getFont().getSize();
        boolean flag=false;
        int i=0;
        for(;i<sizes.length;i++){
            if(textField大小.getText().equals(sizes[i])){
                flag=true;
                break;
            }
        } 
        double size=oldSize;
        if(flag)size=sizeValue[i];
        
        try{ 
            size=Double.parseDouble(textField大小.getText());
            javafx.scene.text.Font f=label预览.getFont();

            String style=listView样式.getSelectionModel().getSelectedItem();
            if(null==style||style.isEmpty()){
                f=javafx.scene.text.Font.font(f.getFamily(),FontWeight.NORMAL,FontPosture.REGULAR,size);
            }
            else{
                System.out.println(style);
                switch(style){
                    case "常规Aa":f=javafx.scene.text.Font.font(f.getFamily(),FontWeight.NORMAL,FontPosture.REGULAR,size);break;
                    case "粗体Aa":f=javafx.scene.text.Font.font(f.getFamily(),FontWeight.BOLD,FontPosture.REGULAR,size);break;
                    case "斜体Aa":f=javafx.scene.text.Font.font(f.getFamily(),FontWeight.NORMAL,FontPosture.ITALIC,size);break;
                    case "粗斜体Aa":f=javafx.scene.text.Font.font(f.getFamily(),FontWeight.BOLD,FontPosture.ITALIC,size);break;
                    default:f=javafx.scene.text.Font.font(f.getFamily(),FontWeight.NORMAL,FontPosture.REGULAR,size);break;
                } 
            } 
            label预览.setFont(f); 
        }catch(Exception e){ 
            textField大小.setText(""+oldSize);
            Alert a=new Alert(Alert.AlertType.ERROR,"字体大小输入不合法");
            a.showAndWait();
        }
    } 
}

class Cell字体 extends ListCell<String> {  
    @Override  
    protected void updateItem(String item, boolean empty) {  
        super.updateItem(item, empty);  
        setFont(javafx.scene.text.Font.font(item));
        setText(item);
     }  
}  

class Cell样式 extends ListCell<String> {  
    @Override  
    protected void updateItem(String item, boolean empty) {  
        super.updateItem(item, empty); 
        if(empty)return;
        javafx.scene.text.Font f=getFont();
        switch(item){
            case "常规Aa":f=javafx.scene.text.Font.font("Times New Roman",FontWeight.NORMAL,FontPosture.REGULAR,f.getSize());break;
            case "粗体Aa":f=javafx.scene.text.Font.font("Times New Roman",FontWeight.BOLD,FontPosture.REGULAR,f.getSize());break;
            case "斜体Aa":f=javafx.scene.text.Font.font("Times New Roman",FontPosture.ITALIC,f.getSize());break;
            case "粗斜体Aa":f=javafx.scene.text.Font.font("Times New Roman",FontWeight.BOLD,FontPosture.ITALIC,f.getSize());break;
            default:;
        } 
        setFont(f);
        setText(item);
    }  
}  
