package uz.efood.app.util

import javafx.application.Application
import javafx.application.Platform
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage

abstract class AbstractWindow : Application() {
    private var fxmlfile = ""

    override fun start(stage: Stage) {
        try {
            val url = javaClass.getResource(fxmlfile)
            if (url == null) {
                println("Couldn't find file: $fxmlfile")
                Platform.exit()
            }
            val loader = FXMLLoader(url)
            val root = loader.load<Parent>()
            val scene = Scene(root)
            stage.scene = scene
            stage.sizeToScene()
            stage.isResizable = false
            stage.centerOnScreen()
            stage.show()
        } catch (e: Exception) {
            println("Couldn't load the url")
        }
    }

    /**
     * Set the filename for getting the wanted resource used by FXMLLoader.
     *
     * @param name
     * of fxml file
     */
    fun setFilename(name: String) {
        this.fxmlfile = name
    }
}