package uz.efood.app

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage
import uz.efood.app.util.AbstractWindow

class HelloApplication : AbstractWindow() {
    override fun start(stage: Stage) {
        val fxmlLoader = FXMLLoader(HelloApplication::class.java.getResource("views/layouts/MainLayout.fxml"))
        val scene = Scene(fxmlLoader.load(), 320.0, 240.0)
        stage.title = "Hello!"
        stage.scene = scene
        stage.sizeToScene();
        stage.show()
    }
}

fun main() {
    Application.launch(HelloApplication::class.java)
}