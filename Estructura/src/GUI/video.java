	/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Collecciones.CircularSimplyLinkedList;
import estructura.LecturaDeArchivos;
import java.io.File;
import java.util.Iterator;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

/**
 *
 * @author Xavier
 */
public class video {
    private MediaPlayer mediaPlayer;
    private MediaView mediaView;
    
    public video(){
        LecturaDeArchivos l = new LecturaDeArchivos("src/Archivos/videos.txt");
        CircularSimplyLinkedList<String> csl = l.leerArchivoVideos();
        crearMediaView(csl);
    }
    public MediaView getVideo(){
        return mediaView;
    }
    public void correrVideo(MediaView media, Iterator<String> it){
        if(it.hasNext()){
            mediaPlayer = new MediaPlayer(new Media(new File(("src/Archivos/"+it.next())).toURI().toString()));
            mediaPlayer.setAutoPlay(true);
            mediaPlayer.setOnEndOfMedia(() -> {correrVideo(mediaView, it);
            }
            );
            mediaView.setMediaPlayer(mediaPlayer);
        }
    }
    public MediaView crearMediaView(CircularSimplyLinkedList dirs){
        mediaView = new MediaView();
        correrVideo(mediaView, dirs.iterator());
        mediaView.setOnMouseClicked(e->{
            if(mediaView.getMediaPlayer().getStatus()==MediaPlayer.Status.PLAYING){
                mediaView.getMediaPlayer().pause();
            }else if(mediaView.getMediaPlayer().getStatus()==MediaPlayer.Status.PAUSED){
                
                mediaView.getMediaPlayer().play();
            }
        });
        mediaView.setFitHeight(200);
        mediaView.setFitWidth(200);
        return mediaView;
    }
    
}
