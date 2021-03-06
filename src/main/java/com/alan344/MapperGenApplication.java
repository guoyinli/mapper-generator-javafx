package com.alan344;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Optional;

/**
 * @author AlanSun
 * @date 2019/8/7 17:07
 */
@Slf4j
@SpringBootApplication
public class MapperGenApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private FXMLLoader fxmlLoader;

    @Override
    public void init() {
        ConfigurableApplicationContext run = SpringApplication.run(MapperGenApplication.class);
        fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(run::getBean);
        HostServices hostServices = getHostServices();
        run.getBeanFactory().registerSingleton("hostServices", hostServices);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        fxmlLoader.setLocation(getClass().getResource("/fxml/main.fxml"));
        Parent root = fxmlLoader.load();

//        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root));
        //图标
        primaryStage.getIcons().add(new Image("/image/icon.png"));
        primaryStage.setWidth(1200);
        primaryStage.setHeight(700);
        primaryStage.setTitle("mapper 生成小工具");
//        primaryStage.setOnCloseRequest(event -> {
//            closeDialog(primaryStage);
//        });
        primaryStage.show();
    }
}
