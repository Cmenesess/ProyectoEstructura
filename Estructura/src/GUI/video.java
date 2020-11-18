	/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Collecciones.CircularDoublyLinkedList;
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
        mediaView.setFitHeight(450);
        mediaView.setFitWidth(450);
        return mediaView;
    }
    
}
