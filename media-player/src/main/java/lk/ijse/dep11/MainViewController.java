package lk.ijse.dep11;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;

import java.io.File;

public class MainViewController {
    public TextField txtAudioPath;
    public Button btnBrowseAudio;
    public Button btnPlayAudio;
    public Button btnStopAudio;
    public TextField txtVideoPath;
    public Button btnBrowseVideo;
    public Button btnPlayVideo;
    public Button btnStopVideo;
    public MediaView mvMain;
    public AnchorPane root;
    MediaPlayer audioPlayer;
    MediaPlayer videoPlayer;

    public void btnBrowseAudioOnAction(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters()
                .add(new FileChooser.ExtensionFilter("Mp3 Files", "*.mp3"));
        fileChooser.getExtensionFilters()
                .add(new FileChooser.ExtensionFilter("Wave Files", "*.wav"));
        File audioFile = fileChooser.showOpenDialog(root.getScene().getWindow());
        if (audioFile != null) {
            txtAudioPath.setText(audioFile.getAbsolutePath());

            Media media = new Media(audioFile.toURI().toString());
            audioPlayer = new MediaPlayer(media);
        }else{
            txtAudioPath.clear();
        }
    }

    public void btnPlayAudioOnAction(ActionEvent actionEvent) {
        if (audioPlayer != null) audioPlayer.play();
    }

    public void btnStopAudioOnAction(ActionEvent actionEvent) {
        if (audioPlayer != null) audioPlayer.stop();
    }

    public void btnBrowseVideoOnAction(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters()
                .add(new FileChooser.ExtensionFilter("Video Files", "*.mp4", "*.avi", "*.mkv"));
        File videoFile = fileChooser.showOpenDialog(root.getScene().getWindow());
        if (videoFile != null) {
            txtVideoPath.setText(videoFile.getAbsolutePath());
            Media media = new Media(videoFile.toURI().toString());
            videoPlayer = new MediaPlayer(media);
        }else {
            txtVideoPath.clear();
        }
    }

    public void btnPlayVideoOnAction(ActionEvent actionEvent) {
        if (videoPlayer != null){
            mvMain.setMediaPlayer(videoPlayer);
            videoPlayer.play();
        }
    }

    public void btnStopVideoOnAction(ActionEvent actionEvent) {
        if (videoPlayer != null) {
            mvMain.setMediaPlayer(null);
            videoPlayer.stop();
        }
    }
}
