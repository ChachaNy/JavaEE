package ch.hevs.musicservice;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import ch.hevs.businessobject.Album;
import ch.hevs.businessobject.Artist;

@Stateful
public class ArtistBean implements ArtistInterface {

	@Resource
	private SessionContext ctx;
	@PersistenceContext(name = "musicPU", type = PersistenceContextType.EXTENDED)
	private EntityManager em;

	@Override
	public List<Artist> getArtists() {
		TypedQuery query = em.createQuery("SELECT a FROM Artist a", Artist.class);
		List<Artist> list = query.getResultList();
		return list;
	}

	@Override
	public Set<Album> showArtistAlbums(long id_artist) {
		Query query = em.createQuery("SELECT art FROM Artist art WHERE art.id=:id");
		query.setParameter("id", id_artist);

		Artist artist = (Artist) query.getSingleResult();
		
		//Impossible de caster comme �a
		//List<Album> albumsList = (List<Album>) artist.getAlbums();
		Set<Album> albumsList = artist.getAlbums();
		

		return albumsList;
	}

}