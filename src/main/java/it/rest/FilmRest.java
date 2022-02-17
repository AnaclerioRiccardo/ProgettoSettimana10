package it.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import it.dao.FilmDao;
import it.dao.FilmDaoImp;
import it.entity.Film;

@RestController
@RequestMapping("/film")
@Api(value = "FilmRest", tags = "Gestione informazioni dei Film")
public class FilmRest {
	
	//Attributi
	private FilmDao fd = new FilmDaoImp();	//Eager
	
	//Metodi
	@PostMapping
	@ApiOperation(value = "Inserimento Film", notes = "Permette di inserire un Film nella piattaforma")
	public ResponseEntity<String> inserisci(@RequestBody Film f){
		try {
			fd.salva(f);
			return new ResponseEntity<String>("Inserimento avvenuto con successo", HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<String>("Errore nell'inserimento: "+e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value = "Aggiornamento Film", notes = "Permette di aggiornare un Film nella piattaforma tramite l'id")
	public ResponseEntity<String> inserisci(@RequestBody Film f, @RequestParam int id){
		try {
			f.setId(id);
			fd.aggiorna(f);
			return new ResponseEntity<String>("Aggiornamento avvenuto con successo", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Errore nell'aggiornamento: "+e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Eliminazione Film", notes = "Permette di eliminare un Film nella piattaforma")
	public ResponseEntity<String> elimina(@PathVariable int id){
		try {
			fd.cancella(id);
			return new ResponseEntity<String>("Eliminazione avvenuto con successo", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Errore nell'eliminazione: "+e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping
	@ApiOperation(value = "Ritorna tutti i Film", notes = "Permette di visualizzare una lista di tutti i Film")
	public ResponseEntity<List<Film>> getAll(){
		try {
			return new ResponseEntity<List<Film>>(fd.trovaTutti(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Film>>((List<Film>)null, HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@GetMapping("/regista/{regista}")
	@ApiOperation(value = "Ritorna tutti i Film", notes = "Permette di visualizzare una lista di tutti i Film fatti da un regista specifico")
	public ResponseEntity<List<Film>> getFilmsByRegista(@PathVariable String regista){
		try {
			return new ResponseEntity<List<Film>>(fd.trovaByRegista(regista), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Film>>((List<Film>)null, HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Ritorna un Film", notes = "Permette di visualizzare un film specifico")
	public ResponseEntity<Film> getFilmsById(@PathVariable int id){
		try {
			return new ResponseEntity<Film>(fd.trova(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Film>((Film)null, HttpStatus.NOT_ACCEPTABLE);
		}
	}

}
