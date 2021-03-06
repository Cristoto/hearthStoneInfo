package hsi.items;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

/**
 * Clase que contendrá toda la información de las cartas.
 * 
 * @author Cristo
 *
 */
public class Carta {
	
	private StringProperty id;
	private StringProperty nombre;
	private StringProperty expansion;
	private StringProperty tipo;
	private StringProperty faccion;
	private StringProperty rareza;
	private IntegerProperty coste;
	private IntegerProperty ataque;
	private IntegerProperty salud;
	private StringProperty accion;
	private StringProperty descripcion;
	private BooleanProperty elite;
	private StringProperty raza;
	private StringProperty artista;
	private StringProperty clase;
	private ObjectProperty<Image> img;
	private StringProperty imgDorada;
	private StringProperty mecanismo;
	
	public Carta() {
		id = new SimpleStringProperty(this, "id");
		nombre = new SimpleStringProperty(this, "nombre");
		expansion = new SimpleStringProperty(this, "expansion");
		tipo = new SimpleStringProperty(this, "tipo");
		faccion = new SimpleStringProperty(this, "faccion");
		rareza = new SimpleStringProperty(this, "rareza");
		coste = new SimpleIntegerProperty(this, "coste");
		ataque = new SimpleIntegerProperty(this, "ataque");
		salud = new SimpleIntegerProperty(this, "salud");
		accion = new SimpleStringProperty(this, "accion");
		descripcion = new SimpleStringProperty(this, "descripcion");
		elite = new SimpleBooleanProperty(this, "elite");
		raza = new SimpleStringProperty(this, "raza");
		artista = new SimpleStringProperty(this, "artista");
		clase = new SimpleStringProperty(this, "clase");
		img = new SimpleObjectProperty<>(this, "img");
		imgDorada = new SimpleStringProperty(this, "imgDorada");
		mecanismo = new SimpleStringProperty(this, "mecanismo");
	}

	public final StringProperty idProperty() {
		return this.id;
	}
	

	public final String getId() {
		return this.idProperty().get();
	}
	

	public final void setId(final String id) {
		this.idProperty().set(id);
	}
	

	public final StringProperty nombreProperty() {
		return this.nombre;
	}
	

	public final String getNombre() {
		return this.nombreProperty().get();
	}
	

	public final void setNombre(final String nombre) {
		this.nombreProperty().set(nombre);
	}
	

	public final StringProperty expansionProperty() {
		return this.expansion;
	}
	

	public final String getExpansion() {
		return this.expansionProperty().get();
	}
	

	public final void setExpansion(final String expansion) {
		this.expansionProperty().set(expansion);
	}
	

	public final StringProperty tipoProperty() {
		return this.tipo;
	}
	

	public final String getTipo() {
		return this.tipoProperty().get();
	}
	

	public final void setTipo(final String tipo) {
		this.tipoProperty().set(tipo);
	}
	

	public final StringProperty faccionProperty() {
		return this.faccion;
	}
	

	public final String getFaccion() {
		return this.faccionProperty().get();
	}
	

	public final void setFaccion(final String faccion) {
		this.faccionProperty().set(faccion);
	}
	

	public final StringProperty rarezaProperty() {
		return this.rareza;
	}
	

	public final String getRareza() {
		return this.rarezaProperty().get();
	}
	

	public final void setRareza(final String rareza) {
		this.rarezaProperty().set(rareza);
	}
	

	public final IntegerProperty costeProperty() {
		return this.coste;
	}
	

	public final int getCoste() {
		return this.costeProperty().get();
	}
	

	public final void setCoste(final int coste) {
		this.costeProperty().set(coste);
	}
	

	public final IntegerProperty ataqueProperty() {
		return this.ataque;
	}
	

	public final int getAtaque() {
		return this.ataqueProperty().get();
	}
	

	public final void setAtaque(final int ataque) {
		this.ataqueProperty().set(ataque);
	}
	

	public final IntegerProperty saludProperty() {
		return this.salud;
	}
	

	public final int getSalud() {
		return this.saludProperty().get();
	}
	

	public final void setSalud(final int salud) {
		this.saludProperty().set(salud);
	}
	

	public final StringProperty accionProperty() {
		return this.accion;
	}
	

	public final String getAccion() {
		return this.accionProperty().get();
	}
	

	public final void setAccion(final String accion) {
		this.accionProperty().set(accion);
	}
	

	public final StringProperty descripcionProperty() {
		return this.descripcion;
	}
	

	public final String getDescripcion() {
		return this.descripcionProperty().get();
	}
	

	public final void setDescripcion(final String descripcion) {
		this.descripcionProperty().set(descripcion);
	}
	

	public final BooleanProperty eliteProperty() {
		return this.elite;
	}
	

	public final boolean isElite() {
		return this.eliteProperty().get();
	}
	

	public final void setElite(final boolean elite) {
		this.eliteProperty().set(elite);
	}
	

	public final StringProperty razaProperty() {
		return this.raza;
	}
	

	public final String getRaza() {
		return this.razaProperty().get();
	}
	

	public final void setRaza(final String raza) {
		this.razaProperty().set(raza);
	}
	

	public final StringProperty artistaProperty() {
		return this.artista;
	}
	

	public final String getArtista() {
		return this.artistaProperty().get();
	}
	

	public final void setArtista(final String artista) {
		this.artistaProperty().set(artista);
	}
	

	public final StringProperty claseProperty() {
		return this.clase;
	}
	

	public final String getClase() {
		return this.claseProperty().get();
	}
	

	public final void setClase(final String clase) {
		this.claseProperty().set(clase);
	}
	

	public final ObjectProperty<Image> imgProperty() {
		return this.img;
	}
	

	public final Image getImg() {
		return this.imgProperty().get();
	}
	

	public final void setImg(final Image img) {
		this.imgProperty().set(img);
	}
	

	public final StringProperty imgDoradaProperty() {
		return this.imgDorada;
	}
	

	public final String getImgDorada() {
		return this.imgDoradaProperty().get();
	}
	

	public final void setImgDorada(final String imgDorada) {
		this.imgDoradaProperty().set(imgDorada);
	}
	

	public final StringProperty mecanismoProperty() {
		return this.mecanismo;
	}
	

	public final String getMecanismo() {
		return this.mecanismoProperty().get();
	}
	

	public final void setMecanismo(final String mecanismo) {
		this.mecanismoProperty().set(mecanismo);
	}
	
	public static Carta fromCartaServicio(hsi.unirest.mapeo.Carta cartaServicio) {
		Carta carta = new Carta();
		carta.setId(cartaServicio.getCardId());
		carta.setNombre(cartaServicio.getName());
		carta.setExpansion(cartaServicio.getCardSet());
		carta.setTipo(cartaServicio.getType());
		carta.setFaccion(cartaServicio.getFaction());
		carta.setRareza(cartaServicio.getRarity());

		if (cartaServicio.getCost() != null)
			carta.setCoste(cartaServicio.getCost());

		if (cartaServicio.getAttack() != null)
			carta.setAtaque(cartaServicio.getAttack());

		if (cartaServicio.getHealth() != null)
			carta.setSalud(cartaServicio.getHealth());

		carta.setAccion(cartaServicio.getFlavor());
		carta.setDescripcion(cartaServicio.getText());
		carta.setRaza(cartaServicio.getRace());
		carta.setArtista(cartaServicio.getArtist());
		carta.setClase(cartaServicio.getPlayerClass());
		
		if (cartaServicio.getImg() != null)
			carta.setImg(new Image(cartaServicio.getImg()));
		else {
			carta.setImg(new Image("http://wow.zamimg.com/images/hearthstone/backs/original/Card_Back_Default.png"));
		}
		if (cartaServicio.getImgGold() != null)
			carta.setImgDorada(cartaServicio.getImgGold());

		carta.setMecanismo(cartaServicio.getMechanics());
		return carta;
	}
	
}
