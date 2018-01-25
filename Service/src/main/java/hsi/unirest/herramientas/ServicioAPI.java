package hsi.unirest.herramientas;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import hsi.unirest.mapeo.Carta;
import hsi.unirest.mapeo.Dorsal;
import hsi.unirest.mapeo.Info;
import hsi.unirest.mapeo.ListaDeCartas;
import hsi.unirest.mapeo.ListaDeDorsales;

public class ServicioAPI {

	public ListaDeCartas getTodasLasCartas(Integer attack, Integer cost, Integer health,
			String locale) throws UnirestException {
		ListaDeCartas listaDeCartas = new ListaDeCartas();
		String consulta = "https://omgvamp-hearthstone-v1.p.mashape.com/cards?";
		
		consulta = comprobacionesAtributos(consulta, attack, cost, health, locale);

		HttpResponse<JsonNode> response = Unirest.get(consulta)
				.header("X-Mashape-Key", "65lMyicqJFmshoONWG7rijO8v9fap1oVHOUjsnCu6wDEybbrNT").asJson();

		// Obtenemos el array con la respuesta y en la posición 0 es donde están los
		// datos por la estructura del JSON
		JSONArray datosRespuesta = response.getBody().getArray();
		JSONObject datos = datosRespuesta.getJSONObject(0);

		// Obtención de las llaves para recorrer cada atributo del primer array (el de
		// las keys)
		String[] keys = JSONObject.getNames(datos);
		for (String string : keys) {

			JSONArray arraysKey = datos.getJSONArray(string);
			for (int i = 0; i < arraysKey.length(); i++) {
				JSONObject item = arraysKey.getJSONObject(i);
				Carta carta = new Carta();

				pasarAtributos(item, carta);

				listaDeCartas.getCartas().add(carta);
			}

		}

		if (listaDeCartas.getCartas().isEmpty())
			throw new UnirestException("Todos los datos de la peticón estaban vacios");

		return listaDeCartas;
	}

	public ListaDeCartas getCartasExpansion(String expansion, Integer attack, Integer cost, Integer health,
			String locale) throws UnirestException {
		
		ListaDeCartas listaDeCartas = new ListaDeCartas();
		expansion = expansion.replace(" ", "%20"); //Los espacios la API las sustituye por %20
		String consulta = "https://omgvamp-hearthstone-v1.p.mashape.com/cards/sets/" + expansion + "?";
		
		consulta = comprobacionesAtributos(consulta, attack, cost, health, locale);
		
		HttpResponse<JsonNode> response = Unirest.get(consulta)
				.header("X-Mashape-Key", "65lMyicqJFmshoONWG7rijO8v9fap1oVHOUjsnCu6wDEybbrNT").asJson();

		// Obtenemos el array con la respuesta y en la posición 0 es donde están los
		// datos por la estructura del JSON
		JSONArray datosRespuesta = response.getBody().getArray();
		
		cargarLista(datosRespuesta, listaDeCartas);

		if(listaDeCartas.getCartas().isEmpty())
			throw new UnirestException("Todos los datos de la peticón estaban vacios");
		
		return listaDeCartas;
	}
	
	public ListaDeCartas getCartasClases(String clase, Integer attack, Integer cost, Integer health,
			String locale) throws UnirestException {
		
		ListaDeCartas listaDeCartas = new ListaDeCartas();
		String consulta = "https://omgvamp-hearthstone-v1.p.mashape.com/cards/classes/" + clase + "?";
		
		consulta = comprobacionesAtributos(consulta, attack, cost, health, locale);
		
		HttpResponse<JsonNode> response = Unirest.get(consulta)
				.header("X-Mashape-Key", "65lMyicqJFmshoONWG7rijO8v9fap1oVHOUjsnCu6wDEybbrNT").asJson();
		
		// Obtenemos el array con la respuesta y en la posición 0 es donde están los
		// datos por la estructura del JSON
		JSONArray datosRespuesta = response.getBody().getArray();
		
		cargarLista(datosRespuesta, listaDeCartas);
		
		if(listaDeCartas.getCartas().isEmpty())
			throw new UnirestException("Todos los datos de la peticón estaban vacios");
		
		return listaDeCartas;
	}
	
	public ListaDeCartas getCartasFacciones(String faccion, Integer attack, Integer cost, Integer health,
			String locale) throws UnirestException {
		
		ListaDeCartas listaDeCartas = new ListaDeCartas();
		faccion = faccion.replace(" ", "%20");
		String consulta = "https://omgvamp-hearthstone-v1.p.mashape.com/cards/factions/" + faccion + "?";
		
		consulta = comprobacionesAtributos(consulta, attack, cost, health, locale);
		
		HttpResponse<JsonNode> response = Unirest.get(consulta)
				.header("X-Mashape-Key", "65lMyicqJFmshoONWG7rijO8v9fap1oVHOUjsnCu6wDEybbrNT").asJson();
		
		JSONArray datosRespuesta = response.getBody().getArray();
		
		cargarLista(datosRespuesta, listaDeCartas);
		
		if(listaDeCartas.getCartas().isEmpty())
			throw new UnirestException("Todos los datos de la peticón estaban vacios");
		
		return listaDeCartas;
	}
	
	public ListaDeCartas getCartasRareza(String rareza, Integer attack, Integer cost, Integer health,
			String locale) throws UnirestException {
		ListaDeCartas listaDeCartas = new ListaDeCartas();
		rareza = rareza.replace(" ", "%20");
		String consulta = "https://omgvamp-hearthstone-v1.p.mashape.com/cards/qualities/" + rareza + "?";
		
		consulta = comprobacionesAtributos(consulta, attack, cost, health, locale);
		
		HttpResponse<JsonNode> response = Unirest.get(consulta)
				.header("X-Mashape-Key", "65lMyicqJFmshoONWG7rijO8v9fap1oVHOUjsnCu6wDEybbrNT").asJson();
		
		JSONArray datosRespuesta = response.getBody().getArray();
		
		cargarLista(datosRespuesta, listaDeCartas);
		
		if(listaDeCartas.getCartas().isEmpty())
			throw new UnirestException("Todos los datos de la peticón estaban vacios");
		
		return listaDeCartas;
	}
	
	public ListaDeCartas getCartasRaza(String raza, Integer attack, Integer cost, Integer health,
			String locale) throws UnirestException {
		ListaDeCartas listaDeCartas = new ListaDeCartas();
		raza = raza.replace(" ", "%20");
		String consulta = "https://omgvamp-hearthstone-v1.p.mashape.com/cards/races/" + raza + "?";
		
		consulta = comprobacionesAtributos(consulta, attack, cost, health, locale);
		
		HttpResponse<JsonNode> response = Unirest.get(consulta)
				.header("X-Mashape-Key", "65lMyicqJFmshoONWG7rijO8v9fap1oVHOUjsnCu6wDEybbrNT").asJson();
		
		JSONArray datosRespuesta = response.getBody().getArray();
		
		cargarLista(datosRespuesta, listaDeCartas);
		
		if(listaDeCartas.getCartas().isEmpty())
			throw new UnirestException("Todos los datos de la peticón estaban vacios");
		
		return listaDeCartas;
	}
	
	public ListaDeCartas getCartasTipo(String tipo, Integer attack, Integer cost, Integer health,
			String locale) throws UnirestException {
		ListaDeCartas listaDeCartas = new ListaDeCartas();
		tipo = tipo.replace(" ", "%20");
		String consulta = "https://omgvamp-hearthstone-v1.p.mashape.com/cards/types/" + tipo + "?";
		
consulta = comprobacionesAtributos(consulta, attack, cost, health, locale);
		
		HttpResponse<JsonNode> response = Unirest.get(consulta)
				.header("X-Mashape-Key", "65lMyicqJFmshoONWG7rijO8v9fap1oVHOUjsnCu6wDEybbrNT").asJson();
		
		JSONArray datosRespuesta = response.getBody().getArray();
		
		cargarLista(datosRespuesta, listaDeCartas);
		
		if(listaDeCartas.getCartas().isEmpty())
			throw new UnirestException("Todos los datos de la peticón estaban vacios");
		
		return listaDeCartas;
	}
	
	private static void cargarLista(JSONArray origen, ListaDeCartas listaDeCartas) {
		for (int i = 0; i < origen.length(); i++) {
			JSONObject item = origen.getJSONObject(i);
			Carta carta = new Carta();
			
			pasarAtributos(item, carta);
			
			listaDeCartas.getCartas().add(carta);
		}
	}
	
	private static void pasarAtributos(JSONObject origen, Carta destino) {
		destino.setCardId(origen.getString("cardId"));
		destino.setDbfId(origen.getString("dbfId"));
		destino.setName(origen.getString("name"));
		destino.setCardSet(origen.getString("cardSet"));
		destino.setType(origen.getString("type"));
		destino.setLocale(origen.getString("locale"));
		try {
			destino.setText(origen.getString("text"));
		} catch (JSONException e) {
		}

		try {
			destino.setPlayerClass(origen.getString("playerClass"));
		} catch (JSONException e) {
		}

		try {
			destino.setFaction(origen.getString("faction"));
		} catch (JSONException e) {
		}

		try {
			destino.setRarity(origen.getString("rarity"));
		} catch (JSONException e) {
		}

		try {
			destino.setCost(origen.getInt("cost"));
		} catch (JSONException e) {
		}

		try {
			destino.setAttack(origen.getInt("attack"));
		} catch (JSONException e) {
		}

		try {
			destino.setHealth(origen.getInt("health"));
		} catch (JSONException e) {
		}

		try {
			destino.setFlavor(origen.getString("flavor"));
		} catch (JSONException e) {
		}

		try {
			destino.setArtist(origen.getString("artist"));
		} catch (JSONException e) {
		}

		try {
			destino.setCollectible(origen.getBoolean("collectible"));
		} catch (JSONException e) {
		}

		try {
			destino.setHowToGetGold(origen.getString("howToGetGold"));
		} catch (JSONException e) {
		}

		try {
			destino.setImg(origen.getString("img"));
		} catch (JSONException e) {
		}

		try {
			destino.setImgGold(origen.getString("imgGold"));
		} catch (JSONException e) {
		}

		try {
			String name = origen.getJSONArray("mechanics").getJSONObject(0).getString("name");
			destino.setMechanics(name);
		} catch (JSONException e) {
		}
	}
	
	private String comprobacionesAtributos(String consulta, Integer attack, Integer cost, Integer health,
			String locale) {
		if (attack != null)
			consulta += "attack=" + attack + "&";

		if (cost != null)
			consulta += "cost=" + cost + "&";

		if (health != null)
			consulta += "health=" + health + "&";

		if (locale != null)
			consulta += "locale=" + locale;
		System.out.println(consulta);
		return consulta;
	}

	public ListaDeDorsales getDorsales(String idioma) throws UnirestException {
		ListaDeDorsales listaDeDorsales = new ListaDeDorsales();

		HttpResponse<JsonNode> response = Unirest
				.get("https://omgvamp-hearthstone-v1.p.mashape.com/cardbacks?locale=" + idioma)
				.header("X-Mashape-Key", "65lMyicqJFmshoONWG7rijO8v9fap1oVHOUjsnCu6wDEybbrNT").asJson();

		JSONArray datosRespuesta = response.getBody().getArray();
		for (int i = 0; i < datosRespuesta.length(); i++) {
			JSONObject datos = datosRespuesta.getJSONObject(i);

			Dorsal dorsal = new Dorsal();

			pasarAtributos(datos, dorsal);

			listaDeDorsales.getDorsales().add(dorsal);
		}

		return listaDeDorsales;
	}

	private static void pasarAtributos(JSONObject origen, Dorsal destino) {
		destino.setCardBackId(origen.getString("cardBackId"));
		destino.setName(origen.getString("name"));
		destino.setDescription(origen.getString("description"));
		destino.setSource(origen.getString("source"));
		try {
			destino.setSourceDescription(origen.getString("sourceDescription"));
		} catch (JSONException e) {
		}
		destino.setEnabled(origen.getBoolean("enabled"));
		destino.setImg(origen.getString("img"));
		destino.setImgAnimated(origen.getString("imgAnimated"));
		destino.setSortCategory(origen.getString("sortCategory"));
		destino.setSortOrder(origen.getString("sortOrder"));
		destino.setLocale(origen.getString("locale"));
	}

	public Info getInfo(String idioma) throws UnirestException {
		Info info = new Info();

		HttpResponse<JsonNode> response = Unirest
				.get("https://omgvamp-hearthstone-v1.p.mashape.com/info?locale=" + idioma)
				.header("X-Mashape-Key", "65lMyicqJFmshoONWG7rijO8v9fap1oVHOUjsnCu6wDEybbrNT")
				.header("Accept", "application/json").asJson();

		JSONArray datosRespuesta = response.getBody().getArray();
		JSONObject datos = datosRespuesta.getJSONObject(0);

		info.setPatch(datos.getString("patch"));

		JSONArray clases = datos.getJSONArray("classes");
		for (int i = 0; i < clases.length(); i++) {
			info.getClasses().add(clases.get(i).toString());
		}

		JSONArray expansiones = datos.getJSONArray("sets");
		for (int i = 0; i < expansiones.length(); i++) {
			if (!expansiones.get(i).equals("Credits") && !expansiones.get(i).equals("Debug")
					&& !expansiones.get(i).equals("System"))
				info.getSets().add(expansiones.get(i).toString());
		}

		JSONArray standards = datos.getJSONArray("standard");
		for (int i = 0; i < standards.length(); i++) {
			info.getStandards().add(standards.get(i).toString());
		}

		JSONArray wilds = datos.getJSONArray("wild");
		for (int i = 0; i < wilds.length(); i++) {
			info.getWilds().add(wilds.get(i).toString());
		}

		JSONArray types = datos.getJSONArray("types");
		for (int i = 0; i < types.length(); i++) {
			info.getTypes().add(types.get(i).toString());
		}

		JSONArray factions = datos.getJSONArray("factions");
		for (int i = 0; i < factions.length(); i++) {
			info.getFactions().add(factions.get(i).toString());
		}

		JSONArray qualities = datos.getJSONArray("qualities");
		for (int i = 0; i < qualities.length(); i++) {
			info.getQualities().add(qualities.get(i).toString());
		}

		JSONArray races = datos.getJSONArray("races");
		for (int i = 0; i < races.length(); i++) {
			info.getRaces().add(races.get(i).toString());
		}

		JSONArray locales = datos.getJSONArray("locales");
		for (int i = 0; i < locales.length(); i++) {
			info.getLocales().add(locales.get(i).toString());
		}

		for (int i = 0; i < info.getLocales().size(); i++) {
			System.out.println(info.getLocales().get(i));
		}

		return info;

	}

	

}
