package ch.logvidmi.dcmreader;

import ij.plugin.DICOM;

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
public class App {
    public static void main(String[] args) {

        String path = "D:\\stw\\workspaces\\new\\dcmreader\\src\\main\\java\\ch\\logvidmi\\dcmreader\\f.dcm";
        DICOM dcm = new DICOM();
        // dcm.open(path);
        // dcm.show();
        System.out.println(dcm.getInfo(path));

    }
}
