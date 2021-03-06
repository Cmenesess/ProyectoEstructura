
package GUI;

import Collecciones.CircularDoublyLinkedList;
import estructura.LecturaDeArchivos;
import java.io.File;
import java.util.Iterator;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class video {
    private MediaPlayer mediaPlayer;
    private MediaView mediaView;
    
    public video(){
        LecturaDeArchivos l = new LecturaDeArchivos();
        CircularDoublyLinkedList<String> csl = l.leerArchivoVideos();
        crearMediaView(csl);
    }
    public MediaView getVideo(){
        return mediaView;
    }
    public void correrVideo(MediaView media, Iterator<String> it){
        if(it.hasNext()){
            mediaPlayer = new MediaPlayer(new Media(new File(("src/Archivos/"+it.next())).toURI().toString()));
            media.setMediaPlayer(mediaPlayer);
            mediaPlayer.setAutoPlay(true);
            mediaPlayer.setOnEndOfMedia(() -> {correrVideo(mediaView, it);
            }
            );
        }
    }
    public MediaView crearMediaView(CircularDoublyLinkedList dirs){
        mediaView = new MediaView();
        correrVideo(mediaView,dirs.iterator());
        mediaView.setOnMouseClicked(e->{
            if(mediaView.getMediaPlayer().getStatus()==MediaPlayer.Status.PLAYING){
                mediaView.getMediaPlayer().pause();
            }else if(mediaView.getMediaPlayer().getStatus()==MediaPlayer.Status.PAUSED){
                
                mediaView.getMediaPlayer().play();
            }
        });
        mediaView.setFitHeight(450);
        mediaView.setFitWidth(450);
        return mediaView;
    }
    
}
