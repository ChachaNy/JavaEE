package ch.hevs.musicservice;

import java.util.List;
import java.util.Set;

import javax.ejb.Local;

import ch.hevs.businessobject.Album;
import ch.hevs.businessobject.Artist;
import ch.hevs.businessobject.Song;

@Local
public interface AlbumInterface {
	
	List<Album> showAlbumsByArtist(long id_artist);
	
	public void addAlbum(Album album);
	
	public boolean exist(String name);

	public Set<Song> showAlbumSongs(long id_album);
	
	//TODO : DELETE METHOD
	
	//TODO : UPDATE METHOD
	
	//TODO : SHOW ALL ALBUMS ?
}
