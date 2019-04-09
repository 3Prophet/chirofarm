package ch.logvidmi.dcmreader;

import ij.plugin.DICOM;
import ij.util.DicomTools;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

// @formatter:off
 /*
            FileInputStream fis;
            try {
                fis = new FileInputStream(path);
                DICOM d = new DICOM(fis);
                d.run(path);
                Image picture = SwingFXUtils.toFXImage(d.getBufferedImage(), null);
                Button bt = new Button();
                bt.setGraphic(new ImageView(picture));
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            */
// @formatter:on
public class App extends Application {

    private DICOM dcm = new DICOM();
    private String path = "D:\\stw\\workspaces\\new\\dcmreader\\src\\main\\java\\ch\\logvidmi\\dcmreader\\f.dcm";
    private Image image;

    public static void main(String[] args) {

        launch(args);
        ;

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        dcm.open(path);
        primaryStage.setTitle("Dicom demo");

        ImageView iv = new ImageView();
        iv.setImage(getImage());
        iv.setFitHeight(500);
        iv.setFitWidth(500 / getAspectRatio());

        StackPane root = new StackPane();
        Scene scene = new Scene(root, 500, 500);
        root.getChildren()
                .add(iv);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private Image getImage() {
        dcm.open(path);
        image = SwingFXUtils.toFXImage(dcm.getBufferedImage(), null);
        return image;
    }

    private double getAspectRatio() {
        return image.getHeight() / image.getWidth();
    }

    private void printPixelDistance(DICOM dcm) {
        dcm.open(path);
        System.out.println(DicomTools.getTag(dcm, "0028,0030"));

    }

    private void printImageInfo() {
        System.out.println(dcm.getInfo(path));
    }

    private void showImage() {
        dcm.open(path);
        dcm.show();
    }
}
